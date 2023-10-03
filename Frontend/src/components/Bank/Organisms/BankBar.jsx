import React, { useState, useEffect } from 'react';
import { useNavigation } from '../../../hooks/useNavigation.jsx';
import bank1 from '../../../assets/images/bank1.png';
import bank2 from '../../../assets/images/bank2.png';
import bank3 from '../../../assets/images/bank3.png';
import './BankBar.css';
import useBankApi from '../../../api/useBankApi.jsx';

const BankBar = () => {
    const { navigateToLogin } = useNavigation();

    const [cashValue, setCashValue] = useState([]);
    const [stockValue, setStockValue] = useState([]);
    const [saveValue, setSaveValue] = useState([]);

    const getAssetList = async () => {
        try {
            const response = await useBankApi.bankGetBank();
            if (response.code === 200) {
                setCashValue(response.data.asset.cash);
                setStockValue(response.data.asset.stock);
                setSaveValue(response.data.asset.save);
            } else {
                console.log(response.code);
            }
        } catch (error) {
            navigateToLogin();
        }
    };

    useEffect(() => {
        getAssetList();
    }, []);

    return (
        <div className="bankBarContainer">
            <div className="bankTitleContainer">
                <div className="bankBarTitle">내 자산 </div>
            </div>
            <div className="bankBarBlackBackground">
                <div className="assetItem">
                    <img
                        src={bank1}
                        alt="Bank"
                        style={{
                            marginRight: '3vh',
                            width: '7vh',
                            height: '7vh',
                        }}
                    />
                    내 현금 자산 : {cashValue}
                </div>
                <div className="assetItem">
                    <img
                        src={bank2}
                        alt="Bank"
                        style={{
                            marginRight: '3vh',
                            width: '7vh',
                            height: '7vh',
                        }}
                    />
                    내 주식 자산 : {stockValue}
                </div>
                <div className="assetItem">
                    <img
                        src={bank3}
                        alt="Bank"
                        style={{
                            marginRight: '3vh',
                            width: '7vh',
                            height: '7vh',
                        }}
                    />
                    내 저축 자산 : {saveValue}
                </div>
            </div>
        </div>
    );
};

export default BankBar;
