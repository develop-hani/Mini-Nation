import React from 'react';

const ProductionRequirement = ({ title, size }) => {
    const titleStyle = {
        fontSize: `${size}px`,
        color: '#757575',
    };
    return <div style={titleStyle}>{title}</div>;
};

export default ProductionRequirement;
