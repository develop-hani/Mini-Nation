/* eslint-disable no-nested-ternary */
import React, { useState } from 'react';

function TabButton({ imgsrc, onClick, className }) {
    const defaultButtonStyle = {
        display: 'grid',
        alignItems: 'center',
        background: '#e3edf7',
        padding: '0',
        borderRadius: '15px',
        cursor: 'pointer',
        transition: 'transform 0.5s',
        boxShadow:
            '6px 6px 10px -1px rgba(0,0,0,0.15), -6px -6px 10px -1px rgba(255,255,255,0.7)',
        border: '1px solid rgba(0,0,0,0)',
        filter: 'grayscale(100%)',
    };

    // `.active` 클래스가 있을 경우의 스타일
    const activeButtonStyle = {
        ...defaultButtonStyle,
        boxShadow:
            'inset 4px 4px 6px -1px rgba(0,0,0,0.2), inset -4px -4px 6px -1px rgba(255,255,255,0.7), -0.5px -0.5px 0px rgba(255,255,255,1), 0.5px 0.5px 0px rgba(0,0,0,0.15), 0px 12px 10px -10px rgba(0,0,0,0.05)',
        border: '1px solid rgba(0,0,0,0.1)',
        transform: 'translateY(0.5em)',
        filter: 'grayscale(0%)',
    };

    const buttonHoverStyle = {
        ...defaultButtonStyle,
        transform: 'scale(1.1)', // 버튼이 1.1배로 확대됨
    };

    // className에 'active'가 포함되어 있는지 확인
    const isButtonActive = className && className.includes('active');
    const [isHovered, setIsHovered] = useState(false);

    return (
        <div>
            <button
                type="button"
                style={
                    isButtonActive
                        ? activeButtonStyle
                        : isHovered
                        ? buttonHoverStyle
                        : defaultButtonStyle
                }
                onClick={onClick}
                className="tab-button"
                onMouseEnter={() => setIsHovered(true)}
                onMouseLeave={() => setIsHovered(false)}
            >
                <img
                    src={imgsrc}
                    alt="Icon"
                    width="80"
                    height="80"
                    style={{ borderRadius: '15px' }}
                />
            </button>
        </div>
    );
}

export default TabButton;
