/* eslint-disable jsx-a11y/control-has-associated-label */
/* eslint-disable no-nested-ternary */
import React, { useState } from 'react';

function OrderTab({ menu, onClick, className }) {
    const defaultButtonStyle = {
        color: '#090909',
        padding: '0.7em 2em',
        fontSize: '15px',
        borderRadius: '0.5em',
        background: '#e8e8e8',
        border: '1px solid #e8e8e8',
        transition: 'all .3s',
        boxShadow: '6px 6px 12px #c5c5c5, -6px -6px 12px #ffffff',
        fontFamily: 'GmarketSansMedium, cursive',
    };

    // `.active` 클래스가 있을 경우의 스타일
    const activeButtonStyle = {
        ...defaultButtonStyle,
        color: '#ffffff',
        background: '#262E3A',
        boxShadow: '4px 4px 12px #c5c5c5, -4px -4px 12px #ffffff',
    };

    // hover할 경우의 스타일
    const buttonHoverStyle = {
        ...defaultButtonStyle,
        background: '#D4D4D4',
        border: '1px solid white',
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
                {menu}
            </button>
        </div>
    );
}

export default OrderTab;
