import React, { useState, useEffect } from 'react';
import './MarketStudent.css';
import Swal from 'sweetalert2';
import ButtonLarge1 from '../../Common/Atoms/ButtonLarge1.jsx';
import ButtonMiddle1 from '../../Common/Atoms/ButtonMiddle1.jsx';
import { useNavigation } from '../../../hooks/useNavigation.jsx';
import useShopApi from '../../../api/useShopApi.jsx';

const MarketStudent = () => {
    const cash = 20000;
    const { navigateToLogin } = useNavigation();
    const [purchaseList, setPurchaseList] = useState([]);

    const [productList, setProductList] = useState([]);

    const getProductList = async () => {
        try {
            const response = await useShopApi.shopGetList();
            if (response.code === 200) {
                setProductList(response.data);
            } else {
                console.log(response.code);
            }
        } catch (error) {
            navigateToLogin();
        }
    };

    // const handleBuy = async product => {
    //     try {
    //         const productData = {
    //             product,
    //         };
    //         const response = await useShopApi.shopDeleteShop(productData);
    //         if (response.code === 200) {
    //             Swal.fire('상품이 삭제되었습니다').then(result => {
    //                 if (result.isConfirmed) {
    //                     window.location.reload();
    //                 }
    //             });
    //         } else {
    //             console.log('상품 삭제 실패:', response.code);
    //         }
    //     } catch (error) {
    //         console.error('상품 삭제 중 오류 발생:', error);
    //     }
    // };

    const transformProductToTransaction = product => {
        return {
            id: product.id,
            product: product.product,
            desc: product.desc,
            price: product.price,
            amount: '-',
            button: (
                <ButtonMiddle1
                    title="구매하기"
                    onClick={() => handleBuy(product.product, product.amount)}
                />
            ),
        };
    };

    const transformPurchaseToDisplayItem = (item, index) => {
        return {
            ...item,
            id: item.id || index + 1,
            button: (
                <ButtonMiddle1
                    title="사용하기"
                    onClick={() => handleUse(item)}
                />
            ),
        };
    };

    const transactions = productList.map((product, index) =>
        transformProductToTransaction(product, index + 1),
    );

    const displayPurchases = purchaseList.map((item, index) =>
        transformPurchaseToDisplayItem(item, index),
    );

    const getPurchaseList = async () => {
        try {
            const response = await useShopApi.shopGetPurchase();
            if (response.code === 200) {
                setPurchaseList(response.data);
            } else {
                console.log(response.code);
            }
        } catch (error) {
            navigateToLogin();
        }
    };

    useEffect(() => {
        getProductList();
        getPurchaseList();
    }, []);

    return (
        <div>
            <div className="marketRightText">
                <ButtonLarge1 title={`사용가능한 금액 : ${cash}`} />
            </div>
            <div className="marketLeftText">구매할 수 있는 물품</div>
            <div className="marketStudentTableWrapper">
                <table border="1">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>상품설명</th>
                            <th>가격</th>
                            <th>수량</th>
                            <th>구매하기</th>
                        </tr>
                    </thead>
                    <tbody>
                        {transactions.map(transaction => (
                            <tr key={transaction.id}>
                                <td>{transaction.product}</td>
                                <td>{transaction.desc}</td>
                                <td>{transaction.price}</td>
                                <td>{transaction.amount}</td>
                                <td>{transaction.button}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <div className="marketLeftText">내가 구매한 물품</div>
            <div className="marketStudentTableWrapper">
                <table border="1">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>상품설명</th>
                            <th>가격</th>
                            <th>수량</th>
                            <th>사용하기</th>
                        </tr>
                    </thead>
                    <tbody>
                        {displayPurchases.map(item => (
                            <tr key={item.id}>
                                <td>{item.product}</td>
                                <td>{item.desc}</td>
                                <td>{item.price}</td>
                                <td>{item.amount}</td>
                                <td>{item.button}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default MarketStudent;
