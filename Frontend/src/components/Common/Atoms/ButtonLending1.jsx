import React from 'react';

function ButtonLending1({ title, onClick }) {
    const buttonStyle = {
        display: 'flex', // flexbox 사용
        alignItems: 'center', // 상하 가운데 정렬
        justifyContent: 'center', // 좌우 가운데 정렬
        width: '200px',
        height: '70px',
        borderRadius: '2rem',
        border: 'none',
        backgroundColor: '#2B788B',
        color: 'white',
        cursor: 'pointer',
    };

    return (
        <div>
            <button type="button" style={buttonStyle} onClick={onClick}>
                {title}
            </button>
        </div>
    );
}

export default ButtonLending1;
