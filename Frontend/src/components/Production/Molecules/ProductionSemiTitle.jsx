import React from 'react';

const ProductionTitle = ({ title }) => {
    const titleStyle = {
        fontSize: '15px',
        Width: '140px',
        textAlign: 'right',
    };
    return <div style={titleStyle}>{title}</div>;
};

export default ProductionTitle;
