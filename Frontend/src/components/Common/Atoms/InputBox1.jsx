import React, { useState } from 'react';

function InputBox1({ placeholder, inputText, onChange, type }) {
    const [isFocused, setIsFocused] = useState(false);

    const handleFocus = () => {
        setIsFocused(true);
    };

    const handleBlur = () => {
        setIsFocused(false);
    };

    const inputStyle = {
        boxSizing: 'border-box',
        width: '100%',
        padding: '1rem',
        borderRadius: '1rem',
        borderColor: isFocused ? '#a2d6ab' : '#c0c0c0',
        borderStyle: 'solid',
        outline: 'none', // 디폴트 아웃라인(검정) 삭제
    };

    return (
        <input
            value={inputText}
            placeholder={placeholder}
            name="text"
            style={inputStyle}
            onFocus={handleFocus}
            onBlur={handleBlur}
            onChange={onChange}
            type={type}
            autoComplete="off"
        />
    );
}

export default InputBox1;
