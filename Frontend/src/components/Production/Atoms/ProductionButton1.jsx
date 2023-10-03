import React, { useState } from 'react';

function ProductionButton1({ title, onClick }) {
    const [isHovered, setIsHovered] = useState(false);
    const buttonStyle = {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        width: '100px',
        height: '30px',
        borderRadius: '1.5rem',
        border: 'none',
        backgroundColor: isHovered ? '#027a51' : '#029664',
        color: 'white',
        cursor: 'pointer',
        margin: '1px',
        fontFamily: "'GmarketSansMedium', cursive",
    };

    return (
        <div>
            <button
                type="button"
                style={buttonStyle}
                onClick={onClick}
                className="importantbutton"
                onMouseEnter={() => setIsHovered(true)}
                onMouseLeave={() => setIsHovered(false)}
            >
                {title}
            </button>
        </div>
    );
}

export default ProductionButton1;
