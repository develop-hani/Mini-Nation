/* eslint-disable react/no-unescaped-entities */
/* eslint-disable react/style-prop-object */
import React from 'react';
import './CompanyContent.css';

const CompanyContent3 = () => {
    return (
        <div class="company-content-container">
            <div class="company-name">넥슨</div>
            {/* <div class="company-image-parent">
                <img
                    src={SamsungCover}
                    alt="삼성배경"
                    class="company-coverimage"
                />
            </div> */}
            <div class="company-image-parent">
                <video autoPlay loop muted class="company-covervideo">
                    <source
                        src="https://www.nexongames.co.kr/video/Hit2.mp4"
                        type="video/mp4"
                    />
                    Your browser does not support the video tag.
                </video>
            </div>
            <div class="company-description">
                넥슨게임즈는 넥슨 컴퍼니의 게임 개발사로서, '서든어택', 'V4',
                '히트2' 등 다양한 장르의 게임을 개발, 국내는 물론 세계 각국에
                선보이고 있어요. 넥슨게임즈는 기존의 게임보다 한층 돋보이는
                재미를 담은 다양한 신작들을 통해 한국을 넘어 세계로부터 주목받는
                글로벌 개발사로 성장해 나가고 있어요.
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

export default CompanyContent3;
