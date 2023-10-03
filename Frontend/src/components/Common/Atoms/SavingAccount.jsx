import React from 'react';

function SavingAccount1({ balance, onClick }) {
    const buttonStyle = {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        width: '300px',
        height: '40px',
        borderRadius: '2rem',
        border: 'none',
        boxShadow: '2px 2px 30px 2px lightgrey',
        backgroundColor: '#2D3D5E',
        color: 'white',
        cursor: 'pointer',
    };

    return (
        <div>
            <button type="button" style={buttonStyle} onClick={onClick}>
                입출금 계좌 잔고 : {balance}
            </button>
        </div>
    );
}

export default SavingAccount1;
