import React, { useState, useEffect } from 'react';
import './MarketTeacher.css';
import Swal from 'sweetalert2';
import ButtonMiddle1 from '../../Common/Atoms/ButtonMiddle1.jsx';
import MarketModal2 from './MarketModal2.jsx';
import { useNavigation } from '../../../hooks/useNavigation.jsx';
import useShopApi from '../../../api/useShopApi.jsx';

const MarketTeacher = () => {
    const { navigateToLogin } = useNavigation();

    const [productList, setProductList] = useState([]);

    const getProductList = async () => {
        try {
            const response = await useShopApi.shopGetList();
            console.log('보냈죠?', response);
            if (response.code === 200) {
                setProductList(response.data);
            } else {
                console.log(response.code);
            }
        } catch (error) {
            navigateToLogin();
        }
    };

    const handleDelete = async product => {
        try {
            const productData = {
                product,
            };
            const response = await useShopApi.shopDeleteShop(productData);
            if (response.code === 200) {
                Swal.fire('상품이 삭제되었습니다').then(result => {
                    if (result.isConfirmed) {
                        window.location.reload();
                    }
                });
            } else {
                console.log('상품 삭제 실패:', response.code);
            }
        } catch (error) {
            console.error('상품 삭제 중 오류 발생:', error);
        }
    };

    const transformProductToTransaction = product => {
        return {
            id: product.id,
            product: product.product,
            desc: product.desc,
            price: product.price,
            amount: '-',
            button: (
                <ButtonMiddle1
                    title="삭제하기"
                    onClick={() => handleDelete(product.product)}
                />
            ),
        };
    };

    const transactions = productList.map((product, index) =>
        transformProductToTransaction(product, index + 1),
    );

    // 모달의 상태를 관리하는 state
    const [isModal2Visible, setModal2Visible] = useState(false);

    // 모달을 보여주는 함수
    const showModal2 = () => {
        setModal2Visible(true);
    };

    // 모달을 숨기는 함수
    const hideModal2 = () => {
        setModal2Visible(false);
    };

    useEffect(() => {
        getProductList();
    }, []);

    return (
        <div>
            <div className="marketRightText">
                <ButtonMiddle1 title="물품추가" onClick={showModal2} />
            </div>
            <div className="marketLeftText">구매할 수 있는 물품</div>
            <div className="marketTeacherTableWrapper">
                <table border="1">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>상품설명</th>
                            <th>가격</th>
                            <th>수량</th>
                            <th>삭제</th>
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
            {isModal2Visible && <MarketModal2 hideModal={hideModal2} />}
        </div>
    );
};

export default MarketTeacher;
