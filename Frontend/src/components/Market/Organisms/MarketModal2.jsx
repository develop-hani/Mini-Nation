import React, { useState } from 'react';
import Swal from 'sweetalert2';
import InputBox1 from '../../Common/Atoms/InputBox1.jsx';
import useShopApi from '../../../api/useShopApi.jsx';

const MarketModal2 = ({ hideModal }) => {
    const [product, setProduct] = useState('');
    const [desc, setDesc] = useState('');
    const [price, setPrice] = useState('');
    const [isHovered, setIsHovered] = useState(false);

    const handleRegister = async () => {
        try {
            const response = await useShopApi.shopPutShop(product, desc, price);
            if (response.code === 200) {
                Swal.fire('상품이 추가되었습니다');
                hideModal();
                window.location.reload();
            } else {
                console.log('200이 아닌 다른 code가 나오는중');
            }
        } catch (e) {
            Swal.fire('양식에 맞춰서 작성해주세요!');
        }
    };

    const modalStyle = {
        position: 'fixed',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        zIndex: 1000,
        backgroundColor: 'white',
        padding: '1.5em',
        border: '1px solid #ccc',
        boxShadow: '0px 0px 10px rgba(0, 0, 0, 0.1)',
        width: '400px',
        textAlign: 'center',
    };

    const overlayStyle = {
        position: 'fixed',
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        backgroundColor: 'rgba(0, 0, 0, 0.7)',
        zIndex: 999,
    };

    const h3Style = {
        fontSize: '2rem', // 글자 크기를 2rem으로 조절합니다.
    };

    const pStyle = {
        fontSize: '1.5rem', // 글자 크기를 1.5rem으로 조절합니다.
        margin: '1rem 0', // 상하 마진 추가
        textAlign: 'left',
    };

    const buttonStyle = {
        fontSize: '1.2rem', // 버튼 내의 글자 크기를 조절합니다.
        padding: '0.5rem 1rem',
        margin: '10px',
        cursor: 'pointer',
        border: 'none',
        backgroundColor: isHovered ? '#027a51' : '#029664',
        color: 'white',
        borderRadius: '5px',
        marginright: '1rem',
    };

    return (
        <div>
            <div style={overlayStyle} />
            <div style={modalStyle}>
                <h3 style={h3Style}>물품 추가하기</h3>
                <p style={pStyle}>
                    상품 명{' '}
                    <InputBox1
                        value={product}
                        onChange={e => setProduct(e.target.value)}
                    />
                </p>
                <p style={pStyle}>
                    상품 설명{' '}
                    <InputBox1
                        value={desc}
                        onChange={e => setDesc(e.target.value)}
                    />
                </p>
                <p style={pStyle}>
                    상품 가격{' '}
                    <InputBox1
                        value={price}
                        onChange={e => setPrice(e.target.value)}
                    />
                </p>
                <button
                    type="button"
                    style={buttonStyle}
                    onClick={handleRegister}
                    onMouseEnter={() => setIsHovered(false)}
                    onMouseLeave={() => setIsHovered(false)}
                >
                    등록하기
                </button>
                <button
                    type="button"
                    style={buttonStyle}
                    onClick={hideModal}
                    onMouseEnter={() => setIsHovered(true)}
                    onMouseLeave={() => setIsHovered(false)}
                >
                    닫기
                </button>
            </div>
        </div>
    );
};

export default MarketModal2;
