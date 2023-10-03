import React, { useState } from 'react';
import BankButtonMiddle from '../Atoms/BankButtonMiddle.jsx';
import './BankContent.css';
import BankContent1 from '../Molecules/BankContent1.jsx';
import BankContent2 from '../Molecules/BankContent2.jsx';
import BankContent3 from '../Molecules/BankContent3.jsx';

const BankContent = () => {
    const [selectedButton, setSelectedButton] = useState('button1');

    const handleButtonClick = buttonName => {
        setSelectedButton(buttonName);
    };

    return (
        <div>
            <div className="bankSelectBlackBackground">
                <div className="bankSelectButtonWrapperStyle">
                    <BankButtonMiddle
                        type="button"
                        title="입출금 내역조회"
                        className={`bankSelectButtonStyle ${
                            selectedButton === 'button1' ? 'active' : ''
                        }`}
                        onClick={() => handleButtonClick('button1')}
                    />
                </div>
                <div className="bankSelectButtonWrapperStyle">
                    <BankButtonMiddle
                        type="button"
                        title="가입한 상품조회"
                        className={`bankSelectButtonStyle ${
                            selectedButton === 'button2' ? 'active' : ''
                        }`}
                        onClick={() => handleButtonClick('button2')}
                    />
                </div>
                <div className="bankSelectButtonWrapperStyle">
                    <BankButtonMiddle
                        type="button"
                        title="금융상품 조회"
                        className={`bankSelectButtonStyle ${
                            selectedButton === 'button3' ? 'active' : ''
                        }`}
                        onClick={() => handleButtonClick('button3')}
                    />
                </div>
            </div>
            {selectedButton === 'button1' && <BankContent1 />}
            {selectedButton === 'button2' && <BankContent2 />}
            {selectedButton === 'button3' && <BankContent3 />}
        </div>
    );
};

export default BankContent;
