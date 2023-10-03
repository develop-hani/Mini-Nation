import React, { useState } from 'react';

// Common
import NavBar from '../../Common/Organisms/NavBar.jsx';
import './Stock.css';

// Atoms
import TabButton from '../Atoms/TabButton.jsx';

// MoleCules
import TickerTape from '../Molecules/TickerTape.jsx';
import StockChart from '../Molecules/StockChart.jsx';

// Organisms
import CompanyContent1 from '../Organisms/CompanyContent1.jsx';
import CompanyContent2 from '../Organisms/CompanyContent2.jsx';
import CompanyContent3 from '../Organisms/CompanyContent3.jsx';
import CompanyContent4 from '../Organisms/CompanyContent4.jsx';
import CompanyContent5 from '../Organisms/CompanyContent5.jsx';
import StockTrading from '../Organisms/StockTrading.jsx';
import PortFolio from '../Organisms/PortFolio.jsx';

// Images
import samsungLogo from '../../../assets/images/samsung-logo.png';
import hyundaiLogo from '../../../assets/images/hyundai-logo.png';
import nexonLogo from '../../../assets/images/nexon-logo.png';
import hybeLogo from '../../../assets/images/hybe-logo.png';
import kakaoLogo from '../../../assets/images/kakao-logo.png';

const Stock = () => {
    const [selectedButton, setSelectedButton] = useState('button1'); // 초기에는 어떤 버튼도 선택되지 않았다고 가정

    const handleButtonClick = buttonName => {
        setSelectedButton(buttonName);
    };

    return (
        <div className="section-master">
            <NavBar username="휘진" totalBalancebalance={1000} />
            <TickerTape />

            <div className="section-container">
                {/* Comapny-Info-Section */}
                <div className="tab-section">
                    {/* 삼성전자 */}
                    <TabButton
                        type="button"
                        imgsrc={samsungLogo}
                        className={`stockSelectButtonStyle ${
                            selectedButton === 'button1' ? 'active' : ''
                        }`}
                        onClick={() => handleButtonClick('button1')}
                    />
                    {/* 현대자동차 */}
                    <TabButton
                        type="button"
                        imgsrc={hyundaiLogo}
                        className={`stockSelectButtonStyle ${
                            selectedButton === 'button2' ? 'active' : ''
                        }`}
                        onClick={() => handleButtonClick('button2')}
                    />
                    {/* 넥슨 */}
                    <TabButton
                        type="button"
                        imgsrc={nexonLogo}
                        className={`stockSelectButtonStyle ${
                            selectedButton === 'button3' ? 'active' : ''
                        }`}
                        onClick={() => handleButtonClick('button3')}
                    />
                    {/* 하이브 */}
                    <TabButton
                        type="button"
                        imgsrc={hybeLogo}
                        className={`stockSelectButtonStyle ${
                            selectedButton === 'button4' ? 'active' : ''
                        }`}
                        onClick={() => handleButtonClick('button4')}
                    />
                    {/* 카카오 */}
                    <TabButton
                        type="button"
                        imgsrc={kakaoLogo}
                        className={`stockSelectButtonStyle ${
                            selectedButton === 'button5' ? 'active' : ''
                        }`}
                        onClick={() => handleButtonClick('button5')}
                    />
                </div>

                {/* CompanyContent Section */}
                <div className="company-content-section">
                    {selectedButton === 'button1' && <CompanyContent1 />}
                    {selectedButton === 'button2' && <CompanyContent2 />}
                    {selectedButton === 'button3' && <CompanyContent3 />}
                    {selectedButton === 'button4' && <CompanyContent4 />}
                    {selectedButton === 'button5' && <CompanyContent5 />}
                    <StockChart />
                </div>

                {/* Stock-Trading-Section */}
                <div className="stock-trading-section">
                    <PortFolio />
                    <StockTrading />
                </div>
            </div>
        </div>
    );
};

export default Stock;
