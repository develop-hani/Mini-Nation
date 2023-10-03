import React from 'react';

const RowDescription = ({ text, size }) => {
    return (
        <div
            style={{
                opacity: '40%',
                fontSize: `${size}px`,
                whiteSpace: 'normal',
                marginLeft: 'auto',
            }}
        >
            {text}
        </div>
    );
};

export default RowDescription;

RowDescription.defaultProps = {
    size: 14,
};
