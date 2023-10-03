import React from 'react';

function ButtonSmall1({ title, onClick }) {
    const buttonStyle = {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        width: '30px',
        height: '30px',
        borderRadius: '2rem',
        border: 'none',
        backgroundColor: '#029664',
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

export default ButtonSmall1;
