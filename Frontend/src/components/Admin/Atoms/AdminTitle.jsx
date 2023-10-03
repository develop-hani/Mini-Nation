import React from 'react';

function AdminTitle({ title, size }) {
    const titleStyle = {
        fontSize: `${size}px`, // 폰트 크기를 40px로 설정
    };
    return <div style={titleStyle}>{title}</div>;
}

export default AdminTitle;

AdminTitle.defaultProps = {
    size: 30,
};
