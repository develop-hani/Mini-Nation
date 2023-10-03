import React from 'react';
import RowTitle from '../Atoms/RowTitle.jsx';

const InfoRow = ({ title, secondComp, thirdComp }) => {
    const containerStyle = {
        display: 'flex',
        alignItems: 'center',
        flexWrap: 'wrap',
        height: '40px',
    };
    return (
        <div>
            <div style={containerStyle}>
                <RowTitle text={title} size={20} />
                {secondComp}
                {thirdComp}
            </div>
            <hr />
        </div>
    );
};

export default InfoRow;
