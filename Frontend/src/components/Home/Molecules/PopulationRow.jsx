import React from 'react';

function PopulationRow({ name, role }) {
    const rowStyle = {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        margin: '0px 10px',
    };
    const nameStyle = {
        fontSize: '20px',
    };

    return (
        <div style={rowStyle}>
            <p style={nameStyle}>{name}</p>
            <p>{role}</p>
        </div>
    );
}

export default PopulationRow;
