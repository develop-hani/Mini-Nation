import React from 'react';

function MemberTitle({ title, size }) {
    const titleStyle = {
        fontSize: `${size}px`,
    };
    return <div style={titleStyle}>{title}</div>;
}

export default MemberTitle;
