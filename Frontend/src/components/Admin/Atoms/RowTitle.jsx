import React from 'react';

const RowTitle = ({ text, size }) => {
    const hrStyle = {
        fontSize: `${size}px`,
        width: '25%',
    };

    return <div style={hrStyle}>{text}</div>;
};

export default RowTitle;

RowTitle.defaultProps = {
    size: 20,
};
