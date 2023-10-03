import React, { useState } from 'react';

function InputNumber1() {
    const [value, setValue] = useState(0);

    const containerStyle = {
        width: '150px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
    };

    const minusStyle = {
        width: '16px',
        height: '16px',
        padding: '16px',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        flexShrink: 0,
        borderRadius: '8px',
        background: '#029664',
        color: 'white',
    };

    const inputStyle = {
        minWidth: '60px',
        height: '40px',
        padding: '12px',
        borderRadius: '6px',
        border: '1px solid #B8D6BF',
        background: '#FFF',
    };

    const handleInputChange = event => {
        setValue(parseInt(event.target.value, 10));
    };

    const increment = () => {
        setValue(prevValue => prevValue + 1);
    };

    const decrement = () => {
        setValue(prevValue => (prevValue > 0 ? prevValue - 1 : prevValue));
    };

    return (
        <div style={containerStyle}>
            <button type="button" style={minusStyle} onClick={decrement}>
                -
            </button>
            <input
                style={inputStyle}
                type="number"
                value={value}
                onChange={handleInputChange}
            />
            <button type="button" style={minusStyle} onClick={increment}>
                +
            </button>
        </div>
    );
}

export default InputNumber1;
