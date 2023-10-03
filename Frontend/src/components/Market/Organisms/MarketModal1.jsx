import React from 'react';

const MarketModal1 = ({ hideModal }) => {
    const modalStyle = {
        position: 'fixed',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        zIndex: 1000,
        backgroundColor: 'white',
        padding: '1.5em',
        border: '1px solid #ccc',
        boxShadow: '0px 0px 10px rgba(0, 0, 0, 0.1)',
        width: '400px',
        textAlign: 'center',
    };

    const overlayStyle = {
        position: 'fixed',
        top: 0,
        left: 0,
        right: 0,
        bottom: 0,
        backgroundColor: 'rgba(0, 0, 0, 0.7)',
        zIndex: 999,
    };

    const h3Style = {
        fontSize: '2rem', // 글자 크기를 2rem으로 조절합니다.
    };

    const pStyle = {
        fontSize: '1.5rem', // 글자 크기를 1.5rem으로 조절합니다.
        margin: '1rem 0', // 상하 마진 추가
    };

    const buttonStyle = {
        fontSize: '1.2rem', // 버튼 내의 글자 크기를 조절합니다.
        padding: '0.5rem 1rem', // 버튼의 패딩을 조절하여 버튼 크기를 키웁니다.
        cursor: 'pointer',
        border: 'none',
        backgroundColor: '#029664',
        color: 'white',
        borderRadius: '5px',
    };

    return (
        <div>
            <div style={overlayStyle} />
            <div style={modalStyle}>
                <h3 style={h3Style}>알림</h3>
                <p style={pStyle}>구매가 완료되었습니다.</p>
                <button type="button" style={buttonStyle} onClick={hideModal}>
                    닫기
                </button>
            </div>
        </div>
    );
};

export default MarketModal1;
