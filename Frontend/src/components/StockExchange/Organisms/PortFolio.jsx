import React, { useState, useEffect } from 'react';
import './PortFolio.css';

// Images
import samsungLogo from '../../../assets/images/samsung-logo.png';
import hyundaiLogo from '../../../assets/images/hyundai-logo.png';
import nexonLogo from '../../../assets/images/nexon-logo.png';
import hybeLogo from '../../../assets/images/hybe-logo.png';
import kakaoLogo from '../../../assets/images/kakao-logo.png';
import portfolioSum from '../../../assets/images/portfolio-sum.png';

function PortFolio() {
    const [status, setStatus] = useState('positive'); // 초기값을 'positive'로 설정합니다.

    // API로부터 데이터를 받아온다고 가정하고, 해당 데이터에 따라 status를 업데이트합니다.
    useEffect(() => {
        // API에서 받아온 데이터를 기반으로 status를 업데이트합니다.
        // 예를 들어, API에서 'positive'일 경우 setStatus('positive')를 호출하고,
        // 'negative'일 경우 setStatus('negative')를 호출합니다.
        // 실제 API 호출 및 데이터 처리 코드를 여기에 추가하세요.
        // setStatus('positive') 또는 setStatus('negative')를 호출하세요.
    }, []); // 빈 배열을 전달하여 한 번만 실행되도록 설정합니다.

    return (
        <div className="portfolio-container">
            <div className="portfolio-item">
                <div className="portfolio-item-logo center">
                    <img
                        src={samsungLogo}
                        alt="Samsung Logo"
                        style={{
                            width: '40px',
                            borderRadius: '50%',
                            border: '1px solid white',
                        }}
                    />
                </div>
                <div className="portfolio-item-holdings center">
                    <span>10주</span>
                    <span>X</span>
                    <span>6000</span>
                </div>
                <div className="portfolio-item-value center">
                    <div>
                        현재가치 <span>10000</span>
                    </div>
                    <div>
                        구매금액 <span>10000</span>
                    </div>
                    <div>
                        손익<span>10000</span>
                    </div>
                </div>
                <div className="porftolio-item-status center">
                    {/* status에 따라 클래스를 동적으로 추가합니다. */}
                    <div
                        className={`status-box center ${
                            status === 'positive'
                                ? 'positive-status'
                                : 'negative-status'
                        }`}
                    >
                        +15%
                    </div>
                </div>
            </div>
            <div className="portfolio-item">
                <div className="portfolio-item-logo center">
                    <img
                        src={hyundaiLogo}
                        alt="Hyundai Logo"
                        style={{
                            width: '40px',
                            borderRadius: '50%',
                            border: '1px solid white',
                        }}
                    />
                </div>
                <div className="portfolio-item-holdings center">
                    <span>10주</span>
                    <span>X</span>
                    <span>6000</span>
                </div>
                <div className="portfolio-item-value center">
                    <div>
                        현재가치 <span>10000</span>
                    </div>
                    <div>
                        구매금액 <span>10000</span>
                    </div>
                    <div>
                        손익<span>10000</span>
                    </div>
                </div>
                <div className="porftolio-item-status center">
                    {/* status에 따라 클래스를 동적으로 추가합니다. */}
                    <div
                        className={`status-box center ${
                            status === 'positive'
                                ? 'positive-status'
                                : 'negative-status'
                        }`}
                    >
                        +15%
                    </div>
                </div>
            </div>
            <div className="portfolio-item">
                <div className="portfolio-item-logo center">
                    <img
                        src={nexonLogo}
                        alt="Nexon Logo"
                        style={{
                            width: '40px',
                            borderRadius: '50%',
                            border: '1px solid white',
                        }}
                    />
                </div>
                <div className="portfolio-item-holdings center">
                    <span>10주</span>
                    <span>X</span>
                    <span>6000</span>
                </div>
                <div className="portfolio-item-value center">
                    <div>
                        현재가치 <span>10000</span>
                    </div>
                    <div>
                        구매금액 <span>10000</span>
                    </div>
                    <div>
                        손익<span>10000</span>
                    </div>
                </div>
                <div className="porftolio-item-status center">
                    {/* status에 따라 클래스를 동적으로 추가합니다. */}
                    <div
                        className={`status-box center ${
                            status === 'positive'
                                ? 'positive-status'
                                : 'negative-status'
                        }`}
                    >
                        +15%
                    </div>
                </div>
            </div>
            <div className="portfolio-item">
                <div className="portfolio-item-logo center">
                    <img
                        src={hybeLogo}
                        alt="Hybe Logo"
                        style={{
                            width: '40px',
                            borderRadius: '50%',
                            border: '1px solid white',
                        }}
                    />
                </div>
                <div className="portfolio-item-holdings center">
                    <span>10주</span>
                    <span>X</span>
                    <span>6000</span>
                </div>
                <div className="portfolio-item-value center">
                    <div>
                        현재가치 <span>10000</span>
                    </div>
                    <div>
                        구매금액 <span>10000</span>
                    </div>
                    <div>
                        손익<span>10000</span>
                    </div>
                </div>
                <div className="porftolio-item-status center">
                    {/* status에 따라 클래스를 동적으로 추가합니다. */}
                    <div
                        className={`status-box center ${
                            status === 'positive'
                                ? 'positive-status'
                                : 'negative-status'
                        }`}
                    >
                        +15%
                    </div>
                </div>
            </div>
            <div className="portfolio-item">
                <div className="portfolio-item-logo center">
                    <img
                        src={kakaoLogo}
                        alt="kakao Logo"
                        style={{
                            width: '40px',
                            borderRadius: '50%',
                            border: '1px solid white',
                        }}
                    />
                </div>
                <div className="portfolio-item-holdings center">
                    <span>10주</span>
                    <span>X</span>
                    <span>6000</span>
                </div>
                <div className="portfolio-item-value center">
                    <div>
                        현재가치 <span>10000</span>
                    </div>
                    <div>
                        구매금액 <span>10000</span>
                    </div>
                    <div>
                        손익<span>10000</span>
                    </div>
                </div>
                <div className="porftolio-item-status center">
                    {/* status에 따라 클래스를 동적으로 추가합니다. */}
                    <div
                        className={`status-box center ${
                            status === 'positive'
                                ? 'positive-status'
                                : 'negative-status'
                        }`}
                    >
                        +15%
                    </div>
                </div>
            </div>
            <div className="portfolio-item">
                <div className="portfolio-item-logo center">
                    <img
                        src={portfolioSum}
                        alt="포트폴리오"
                        style={{
                            width: '40px',
                            borderRadius: '50%',
                            border: '1px solid white',
                        }}
                    />
                </div>
                <div className="portfolio-item-holdings center">
                    <span>10주</span>
                    <span>X</span>
                    <span>6000</span>
                </div>
                <div className="portfolio-item-value center">
                    <div>
                        현재가치 <span>10000</span>
                    </div>
                    <div>
                        구매금액 <span>10000</span>
                    </div>
                    <div>
                        손익<span>10000</span>
                    </div>
                </div>
                <div className="porftolio-item-status center">
                    {/* status에 따라 클래스를 동적으로 추가합니다. */}
                    <div
                        className={`status-box center ${
                            status === 'positive'
                                ? 'positive-status'
                                : 'negative-status'
                        }`}
                    >
                        +15%
                    </div>
                </div>
            </div>
        </div>
    );
}

export default PortFolio;
