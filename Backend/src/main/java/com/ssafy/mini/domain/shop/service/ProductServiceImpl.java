package com.ssafy.mini.domain.shop.service;

import com.ssafy.mini.domain.account.entity.Account;
import com.ssafy.mini.domain.account.repository.AccountRepository;
import com.ssafy.mini.domain.account.service.AccountService;
import com.ssafy.mini.domain.member.entity.Member;
import com.ssafy.mini.domain.member.repository.MemberRepository;
import com.ssafy.mini.domain.shop.dto.request.AddProductRequest;
import com.ssafy.mini.domain.shop.dto.request.BuyProductRequest;
import com.ssafy.mini.domain.shop.dto.request.DeleteProductRequest;
import com.ssafy.mini.domain.shop.dto.response.MyProductResponse;
import com.ssafy.mini.domain.shop.dto.response.ProductInfoResponse;
import com.ssafy.mini.domain.shop.entity.Possess;
import com.ssafy.mini.domain.shop.entity.Product;
import com.ssafy.mini.domain.shop.mapper.ProductMapper;
import com.ssafy.mini.domain.shop.repository.PossessRepository;
import com.ssafy.mini.domain.shop.repository.ProductRepository;
import com.ssafy.mini.global.exception.ErrorCode;
import com.ssafy.mini.global.exception.MNException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final AccountService accountService;

    private final ProductRepository productRepository;
    private final PossessRepository possessRepository;
    private final MemberRepository memberRepository;
    private final AccountRepository accountRepository;

    private final ProductMapper productMapper;

    private final String SHOP_EXPRESSION = "SP"; // master 테이블의 백화점 코드

    @Override
    public List<ProductInfoResponse> listProducts(String memberId) {
        log.info("Service Layer::listProducts() called");

        // 회원이 속한 국가 찾기
        Member member = getMemberByMemberId(memberId);

        // TODO: QueryDSL로 객체 반환
        List<Product> products = productRepository.findAllByIsoSeq(member.getIsoSeq());

        return products.stream()
                .map(prdocut -> productMapper.productToProductInfoResponse(prdocut))
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(String memberId, AddProductRequest addProductRequest) {
        log.info("Service Layer::addProduct() called");

        Member member = getMemberByMemberId(memberId);
        isTeacher(member); // 선생님인지 확인

        // TODO: Optional을 반환하도록 변경
        Product product = productMapper.addProductRequestToProduct(addProductRequest);
        product.setNation(member.getIsoSeq());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(String memberId, DeleteProductRequest deleteProductRequest) {
        log.info("Service Layer::deleteProduct() called");

        Member member = getMemberByMemberId(memberId);
        isTeacher(member); // 선생님인지 확인

        Product product = getProductByProdName(deleteProductRequest.getProduct());
        productRepository.delete(product);
    }

    @Override
    public void buyProduct(String memberId, BuyProductRequest buyProductRequest) {
        log.info("Service Layer::buyProduct() called");

        Member member = getMemberByMemberId(memberId);
        Product product = getProductByProdName(buyProductRequest.getProduct());

        // 상품 구매
        int moneyNeed = product.getProdPrice() * buyProductRequest.getAmount();
        Account moneyHave = accountRepository.getMoneyToUse(memberId);

        if (moneyNeed > moneyHave.getAcctBalance()) throw new MNException(ErrorCode.NOT_ENOUGH_MONEY); // 돈이 부족한 경우
        accountService.updateAccountBalance(moneyHave, -moneyNeed, SHOP_EXPRESSION , buyProductRequest.getProduct()); // account table 보유 금액 변경
        member.updateMembalance(-moneyNeed); // member table 보유 금액 변경
        memberRepository.save(member);

        // 보유한 상품 수량 변경
        Possess possess = possessRepository.findByMemberIdAndName(memberId, product.getProdName()).orElse(
                Possess.builder()
                        .member(member)
                        .product(product)
                        .possAmount(0)
                        .build()
                    );
        possess.updatePossAmount(buyProductRequest.getAmount());
        possessRepository.save(possess);
    }

    @Override
    public void useProduct(String memberId, DeleteProductRequest deleteProductRequest) {
        log.info("Service Layer::useProduct() called");

        Member member = getMemberByMemberId(memberId);
        Product product = getProductByProdName(deleteProductRequest.getProduct());

        Possess possess = possessRepository.findByMemberIdAndName(memberId, product.getProdName())
                .orElseThrow(() -> new MNException(ErrorCode.NOT_ENOUGH_PRODUCT));
        if (possess.getPossAmount() < 1) throw new MNException(ErrorCode.NOT_ENOUGH_PRODUCT); // 상품이 부족한 경우

        // 보유한 상품 수량 변경
        possess.updatePossAmount(-1);
        possessRepository.save(possess);
    }

    @Override
    public List<MyProductResponse> listMyProducts(String memberId) {
        List<Possess> myProducts = possessRepository.findAllByMemId(memberId);

        // 보유한 물품이 0개 이상인 경우에 대해서만 반환
        return myProducts.stream().filter(possess -> possess.getPossAmount() > 0)
                .map(possess -> productMapper.possessToMyProductResponse(possess))
                .collect(Collectors.toList());
    }

    /**
     * 회원 아이디로 회원 찾기
     * @param memberId 회원 아이디
     * @return 회원
     */
    private Member getMemberByMemberId(String memberId) {
        return memberRepository.findByMemId(memberId)
                .orElseThrow(() -> new MNException(ErrorCode.NO_SUCH_MEMBER));
    }

    /**
     * 선생님인지 확인
     * @param member 회원
     */
    private void isTeacher(Member member) {
        if (!member.getMemType().getExpression().equals("TC")) {
            throw new MNException(ErrorCode.NO_PERMISSION);
        }
    }

    /**
     * 상품 이름으로 상품 찾기
     * @param prodName 상품 이름
     * @return 상품
     */
    private Product getProductByProdName(String prodName) {
        return productRepository.findByProdName(prodName)
                .orElseThrow(() -> new MNException(ErrorCode.NO_SUCH_PRODUCT));
    }

}
