import React from 'react';

const RowInput = ({ text, onTextChange, onKeyPress, width }) => {
    const inputStyle = {
        width: `${width}px`,
        height: '40px',
        borderRadius: '100px',
        border: '1px solid #000',
        background: '#FFF',
        alignItems: 'center',
        padding: '0px 20px',
    };
    return (
        <input
            style={inputStyle}
            type="text"
            value={text}
            onChange={e => onTextChange(e.target.value)}
            onKeyDown={e => {
                if (e.key === 'Enter') {
                    // 'Enter' 키 누를 때 이벤트 처리
                    onKeyPress(); // onKeyPress 함수 호출
                }
            }}
        />
    );
};

RowInput.defaultProps = {
    width: 40,
};

export default RowInput;
