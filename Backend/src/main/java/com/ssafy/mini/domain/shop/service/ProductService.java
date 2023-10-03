package com.ssafy.mini.domain.shop.service;

import com.ssafy.mini.domain.shop.dto.request.AddProductRequest;
import com.ssafy.mini.domain.shop.dto.request.BuyProductRequest;
import com.ssafy.mini.domain.shop.dto.request.DeleteProductRequest;
import com.ssafy.mini.domain.shop.dto.response.MyProductResponse;
import com.ssafy.mini.domain.shop.dto.response.ProductInfoResponse;

import java.util.List;

public interface ProductService {

    List<ProductInfoResponse> listProducts(String memberId);

    void addProduct(String memberId, AddProductRequest addProductRequest);

    void deleteProduct(String memberId, DeleteProductRequest deleteProductRequest);

    void buyProduct(String memberId, BuyProductRequest buyProductRequest);

    void useProduct(String memberId, DeleteProductRequest deleteProductRequest);

    List<MyProductResponse> listMyProducts(String memberId);
}
