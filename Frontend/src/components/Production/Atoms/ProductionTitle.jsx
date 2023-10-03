import React from 'react';

const ProductionTitle = ({ title, size }) => {
    const titleStyle = {
        fontSize: `${size}px`,
        Width: '140px',
        margin: 'auto',
    };
    return <div style={titleStyle}>{title}</div>;
};

export default ProductionTitle;
