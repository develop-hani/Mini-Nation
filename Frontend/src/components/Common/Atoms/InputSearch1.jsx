import React, { useRef } from 'react';
import { ReactComponent as Dotbogi } from '../../../assets/icons/Dotbogi.svg';

function InputSearch1({ text, onClick, onChange }) {
    const containerStyle = {
        height: '40px',
        borderRadius: '100px',
        border: '1px solid #000',
        background: '#FFF',
        margin: 'auto',
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        padding: '0px 20px',
    };

    const inputStyle = {
        width: '80%',
        height: '35px',
        border: 'none',
        outline: 'none',
    };

    const dotbogiIconStyle = {
        width: '30px',
        height: '30px',
        cursor: 'pointer',
    };

    const inputRef = useRef(null);

    const handleDotbogiClick = () => {
        if (onClick) {
            onClick();
        }
    };

    const handleInputKeyPress = e => {
        if (e.key === 'Enter') {
            onClick();
        }
    };

    return (
        <div style={containerStyle}>
            <input
                value={text}
                name="text"
                onChange={onChange}
                style={inputStyle}
                ref={inputRef}
                onKeyDown={handleInputKeyPress}
            />
            <Dotbogi
                style={dotbogiIconStyle}
                onClick={handleDotbogiClick}
                tabIndex="0" // 포커스 가능하도록 tabIndex 추가
                onKeyDown={e => {
                    if (e.key === 'Enter') {
                        if (inputRef.current) {
                            inputRef.current.focus();
                        }
                    }
                }}
            />
        </div>
    );
}

export default InputSearch1;
