import React from 'react';

function ProductionButton1({ title, onClick }) {
    const buttonStyle = {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        width: '100px',
        height: '50px',
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

export default ProductionButton1;
