import React from 'react';

function NationTitle({ title }) {
    const titleStyle = {
        fontSize: '50px', // 폰트 크기를 40px로 설정
        marginBottom: '10px',
    };
    return <div style={titleStyle}>{title}</div>;
}

export default NationTitle;
