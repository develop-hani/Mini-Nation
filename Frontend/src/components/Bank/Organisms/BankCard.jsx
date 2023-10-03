import React from 'react';
import BankChart from './BankChart.jsx';
import BankBar from './BankBar.jsx';
import './BankCard.css';

const BankCard = () => {
    return (
        <div className="bankCardContainer">
            <div className="bankCardBlackBackground">
                <BankBar />
                <BankChart />
            </div>
        </div>
    );
};

export default BankCard;
