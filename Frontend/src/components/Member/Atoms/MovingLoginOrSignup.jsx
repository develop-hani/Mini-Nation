import { light } from '@mui/material/styles/createPalette';
import React from 'react';

function MovingLoginOrSignup({ description, title, onClick }) {
    const contanierStyle = {
        display: 'flex',
        justifyContent: 'flex-end',
    };
    const pStyle = {
        color: 'rgba(53, 91, 62, 0.44)',
    };
    const buttonStyle = {
        border: 'none',
        background: 'none',
        color: '#355B3E',
        textDecorationLine: 'underline',
        cursor: 'pointer',
        fontWeight: 'bold',
    };

    return (
        <div style={contanierStyle}>
            <p style={pStyle}>{description}</p>
            <button style={buttonStyle} type="button" onClick={onClick}>
                {title}
            </button>
        </div>
    );
}

export default MovingLoginOrSignup;
