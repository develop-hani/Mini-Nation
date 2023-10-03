import React from 'react';

function LandingTitle({ title }) {
    const titleStyle = {
        fontSize: '50px', // 폰트 크기를 40px로 설정
    };
    return <div style={titleStyle}>{title}</div>;
}

export default LandingTitle;
