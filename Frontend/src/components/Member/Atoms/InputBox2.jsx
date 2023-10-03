import React, { useState } from 'react';

function InputBox2({ title, placeholder, inputText, onChange, onBlur, type }) {
    const [isFocused, setIsFocused] = useState(false);
    const handleFocus = () => {
        setIsFocused(true);
        console.log(isFocused);
    };

    const handleBlur = () => {
        setIsFocused(false);
        console.log(isFocused);
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
            onChange={onChange}
            onBlur={onBlur}
            type={type}
            onFocus={handleFocus}
        />
    );
}

export default InputBox2;
