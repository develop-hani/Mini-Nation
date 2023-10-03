/* eslint-disable react/style-prop-object */
import React from 'react';
import './CompanyContent.css';

const CompanyContent2 = () => {
    return (
        <div class="company-content-container">
            <div class="company-name">현대자동차</div>
            <div class="company-image-parent">
                <img
                    src="https://blog.kakaocdn.net/dn/bCmfq4/btqxG7OOGdC/Eepm4tqFfQOy6KkY9maiqk/img.gif"
                    alt="현대차배경"
                    class="company-coverimage"
                />
            </div>
            <div class="company-description">
                현대자동차는 자동차, 그리고 자동차 부품을 제조하고 판매하는
                완성차 제조업체에요. 국내 최초로 독자 모델 포니를 개발하며
                대한민국 자동차 산업의 선구자 역할을 해 왔어요. 세계 200개국에
                자동차를 수출하고 글로벌 생산기지를 건설하는 한편, 선도적
                자율주행 기술을 바탕으로 미래 모빌리티 산업을 견인하고 있어요.
            </div>

            <div class="outlink-btns">
                <a
                    href="https://comp.fnguide.com/SVO2/ASP/SVD_Finance.asp?pGB=1&gicode="
                    class="outlink-btn"
                    style={{ textDecoration: 'none' }}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <span class="tooltip">FN가이드 페이지로 이동할께요</span>
                    <span>재무제표</span>
                </a>
                <a
                    href="https://www.samsung.com/sec/"
                    class="outlink-btn"
                    style={{ textDecoration: 'none' }}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <span class="tooltip">제품판매 페이지로 이동할께요</span>
                    <span>제품정보</span>
                </a>
                <a
                    href="https://www.samsung.com/sec/about-us/company-info/"
                    class="outlink-btn"
                    style={{ textDecoration: 'none' }}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <span class="tooltip">기업 홍보 페이지로 이동할께요</span>
                    <span>기업정보</span>
                </a>
            </div>
        </div>
    );
};

export default CompanyContent2;
