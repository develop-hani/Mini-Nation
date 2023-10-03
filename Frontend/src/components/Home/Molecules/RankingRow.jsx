import React from 'react';

function RankingRow({ img, ranking, name, asset }) {
    const rowStyle = {
        width: '100%',
        display: 'flex',
        justifyContent: 'space-around',
        alignItems: 'center',
    };
    const imageStyle = {
        width: '60px',
        height: '60px',
    };
    const rankingStyle = {
        fontSize: '18px',
        marginRight: '8px',
    };
    const nameStyle = {
        fontSize: '18px',
        marginRight: '8px',
    };
    const assetStyle = {
        fontSize: '24px',
        marginRight: '8px',
    };

    return (
        <div style={rowStyle}>
            <img style={imageStyle} src={img} alt="ranking" />
            <p style={rankingStyle}>{ranking}순위</p>
            <p style={nameStyle}>{name}</p>
            <p style={assetStyle}>{asset}</p>
        </div>
    );
}

export default RankingRow;
