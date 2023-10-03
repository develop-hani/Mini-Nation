/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { useState, useEffect } from 'react';

const DropDown2 = ({
    options,
    selectedValue,
    onValueChange,
    closeOtherDropdowns,
    isOpen,
}) => {
    const [isDropDownOpen, setDropDownOpen] = useState(isOpen);

    useEffect(() => {
        setDropDownOpen(isOpen);
    }, [isOpen]);

    const dropDownStyle = {
        position: 'relative',
        display: 'block',
        fontFamily: 'Segoe UI, Tahoma, Geneva, Verdana, sans-serif',
    };

    const buttonStyle = {
        backgroundColor: '#4CAF50',
        color: '#212121',
        padding: '10px 15px',
        fontSize: '15px',
        fontWeight: 'bold',
        border: '2px solid transparent',
        borderRadius: '15px',
        cursor: 'pointer',
        transition: 'border-radius 0.3s',
    };

    const activeButtonStyle = {
        ...buttonStyle,
        borderRadius: '15px 15px 0 0',
    };

    const dropDownContentStyle = {
        display: isDropDownOpen ? 'block' : 'none',
        fontSize: '13px',
        position: 'absolute',
        zIndex: '1',
        minWidth: '200px',
        backgroundColor: '#212121',
        border: '2px solid #4CAF50',
        borderRadius: '0 0 15px 15px',
        boxShadow: '0px 8px 16px 0px rgba(0,0,0,0.2)',
        maxHeight: `${options.length > 8 ? 250 : options.length * 40}px`, // 최대 8개의 옵션 또는 옵션 수에 따라 높이 조정
        overflowY: 'auto', // 스크롤 추가
    };

    const linkStyle = {
        color: '#4CAF50',
        padding: '8px 10px',
        textDecoration: 'none',
        display: 'block',
    };

    const linkHoverStyle = {
        ...linkStyle,
        backgroundColor: '#4CAF50',
        color: '#212121',
        borderRadius: '0',
    };

    // eslint-disable-next-line no-unused-vars
    const linkFocusStyle = {
        ...linkStyle,
        backgroundColor: '#212121',
        color: '#4CAF50',
        borderRadius: '0',
    };

    const handleOptionClick = value => {
        // 드롭다운 옵션을 클릭했을 때 호출되는 함수
        onValueChange(value); // 선택된 값을 부모 컴포넌트로 전달
        setDropDownOpen(false); // 현재 드롭다운을 닫기
        closeOtherDropdowns(); // 다른 드롭다운들도 닫기
    };

    const [hoveredOption, setHoveredOption] = useState(null);

    return (
        <div style={dropDownStyle}>
            <button
                style={isDropDownOpen ? activeButtonStyle : buttonStyle}
                onClick={() => {
                    setDropDownOpen(!isDropDownOpen);
                    closeOtherDropdowns();
                }}
                type="button"
            >
                {selectedValue} &nbsp; {isDropDownOpen ? '▲' : '▼'}
            </button>
            <div style={dropDownContentStyle}>
                {options.map(option => (
                    <a
                        key={option}
                        href="#"
                        style={
                            hoveredOption === option
                                ? linkHoverStyle
                                : linkStyle
                        }
                        onClick={e => {
                            e.preventDefault(); // 링크의 기본 동작 막기
                            handleOptionClick(option); // 옵션 선택 처리
                        }}
                        onMouseEnter={() => setHoveredOption(option)}
                        onMouseLeave={() => setHoveredOption(null)}
                    >
                        {option}
                    </a>
                ))}
            </div>
        </div>
    );
};

export default DropDown2;
