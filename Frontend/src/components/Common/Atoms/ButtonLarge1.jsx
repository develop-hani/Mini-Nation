import React from 'react';

function ButtonLarge1({ title, onClick }) {
    const buttonStyle = {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        width: '300px',
        height: '40px',
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

export default ButtonLarge1;
