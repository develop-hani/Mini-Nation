import React from 'react';

function BankButtonMiddle({ title, onClick, className }) {
    const defaultButtonStyle = {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        width: '110px',
        height: '50px',
        borderRadius: '2rem',
        border: 'none',
        backgroundColor: '#029664',
        color: 'white',
        cursor: 'pointer',
    };

    // `.active` 클래스가 있을 경우의 스타일
    const activeButtonStyle = {
        ...defaultButtonStyle,
        backgroundColor: 'blue',
        color: 'white',
    };

    // className에 'active'가 포함되어 있는지 확인
    const isButtonActive = className && className.includes('active');

    return (
        <div>
            <button
                type="button"
                style={isButtonActive ? activeButtonStyle : defaultButtonStyle}
                onClick={onClick}
            >
                {title}
            </button>
        </div>
    );
}

export default BankButtonMiddle;
