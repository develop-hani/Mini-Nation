import React from 'react';

function ConstitutionRow({ number, content }) {
    const rowStyle = {
        display: 'flex',
        alignItems: 'center',
    };
    const numberStyle = {
        fontSize: '18px',
        marginRight: '8px',
    };

    return (
        <div style={rowStyle}>
            <p style={numberStyle}>{number}조</p>
            <p>{content}</p>
        </div>
    );
}

export default ConstitutionRow;
