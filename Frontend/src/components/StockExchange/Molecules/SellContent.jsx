/* eslint-disable jsx-a11y/label-has-associated-control */
import React, { useState } from 'react';
import './BuySell.css';
import Swal from 'sweetalert2';

import SamsungLogo from '../../../assets/images/samsung-logo.png';
import HyundaiLogo from '../../../assets/images/hyundai-logo.png';
import NexonLogo from '../../../assets/images/nexon-logo.png';
import HybeLogo from '../../../assets/images/hybe-logo.png';
import KakaoLogo from '../../../assets/images/kakao-logo.png';

const SellContent = () => {
    const [price, setPrice] = useState('');
    const [quantity, setQuantity] = useState('');
    const [finalPrice, setFinalPrice] = useState(null);

    const handlePriceChange = e => {
        setPrice(e.target.value);
        // eslint-disable-next-line no-use-before-define
        calculateFinalPrice(e.target.value, quantity);
    };

    const handleQuantityChange = e => {
        setQuantity(e.target.value);
        // eslint-disable-next-line no-use-before-define
        calculateFinalPrice(price, e.target.value);
    };

    // eslint-disable-next-line no-shadow
    const calculateFinalPrice = (price, quantity) => {
        const parsedPrice = parseFloat(price);
        const parsedQuantity = parseFloat(quantity);

        // eslint-disable-next-line no-restricted-globals
        if (!isNaN(parsedPrice) && !isNaN(parsedQuantity)) {
            const result = parsedPrice * parsedQuantity;
            setFinalPrice(result.toFixed(0));
        } else {
            setFinalPrice(null);
        }
    };

    const handleSellClick = () => {
        Swal.fire('매도되었습니다.');
    };

    return (
        <div className="buy-sell-content">
            {/* 주식선택 */}
            <div class="radio-inputs">
                <label>
                    <input class="radio-input" type="radio" name="engine" />
                    <span class="radio-tile">
                        <span class="radio-icon" />
                        <span class="radio-label" />
                        <img
                            src={SamsungLogo}
                            alt="삼성로고"
                            class="trading-company-logo"
                        />
                    </span>
                </label>
                <label>
                    <input class="radio-input" type="radio" name="engine" />
                    <span class="radio-tile">
                        <span class="radio-icon" />
                        <span class="radio-label" />
                        <img
                            src={HyundaiLogo}
                            alt="현대로고"
                            class="trading-company-logo"
                        />
                    </span>
                </label>
                <label>
                    <input class="radio-input" type="radio" name="engine" />
                    <span class="radio-tile">
                        <span class="radio-icon" />
                        <span class="radio-label" />
                        <img
                            src={NexonLogo}
                            alt="넥슨로고"
                            class="trading-company-logo"
                        />
                    </span>
                </label>
                <label>
                    <input class="radio-input" type="radio" name="engine" />
                    <span class="radio-tile">
                        <span class="radio-icon" />
                        <span class="radio-label" />
                        <img
                            src={HybeLogo}
                            alt="하이브로고"
                            class="trading-company-logo"
                        />
                    </span>
                </label>
                <label>
                    <input class="radio-input" type="radio" name="engine" />
                    <span class="radio-tile">
                        <span class="radio-icon" />
                        <span class="radio-label" />
                        <img
                            src={KakaoLogo}
                            alt="카카오로고"
                            class="trading-company-logo"
                        />
                    </span>
                </label>
            </div>
            {/* 주문가격, 주문수량 */}
            <div className="stock-price-quantity">
                <div className="input-group">
                    <label className="label">주문가격</label>
                    <input
                        autoComplete="off"
                        name="Price"
                        id="Price"
                        className="input price"
                        value={price}
                        onChange={handlePriceChange}
                    />
                </div>
                <span>x</span>
                <div className="input-group">
                    <label className="label">주문수량</label>
                    <input
                        autoComplete="off"
                        name="Quantity"
                        id="Quantity"
                        className="input quantity"
                        value={quantity}
                        onChange={handleQuantityChange}
                    />
                </div>
                <span>=</span>
                <div className="calc-price">
                    <div className="calc-price-heading">매매금액</div>
                    {/* 최종가격이 null 일 때는 빈 문자열 표시 */}
                    <div className="calc-price-result">
                        {finalPrice !== null ? finalPrice : ''}
                    </div>
                </div>
            </div>
            {/* 매도버튼 */}
            <button
                type="button"
                className="buy-sell-btn sell-btn"
                onClick={handleSellClick}
            >
                매도하기
            </button>
        </div>
    );
};

export default SellContent;
