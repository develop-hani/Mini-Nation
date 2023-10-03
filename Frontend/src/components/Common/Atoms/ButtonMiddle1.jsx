import React from 'react';

function ButtonMiddle1({ title, onClick, width, height }) {
    const buttonStyle = {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        width: `${width}px`,
        height: `${height}px`,
        borderRadius: '2rem',
        border: 'none',
        backgroundColor: '#029664',
        color: 'white',
        cursor: 'pointer',
    };

    const containerStyle = {
        display: 'flex',
        justifyContent: 'end',
    };

    return (
        <div style={containerStyle}>
            <button type="button" style={buttonStyle} onClick={onClick}>
                {title}
            </button>
        </div>
    );
}

ButtonMiddle1.defaultProps = {
    height: 50, // height의 기본값을 50으로 설정
    width: 100, // width의 기본값을 100으로 설정
};

export default ButtonMiddle1;
