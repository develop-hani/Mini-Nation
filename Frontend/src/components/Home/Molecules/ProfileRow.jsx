import React from 'react';
import ProfileJob from '../Atoms/ProfileJob';
import ProfileAsset from '../Atoms/ProfileAsset';
import ProfileProduct from '../Atoms/ProfileProduct';

const ProfileRow = ({
    name,
    jobName,
    pay,
    currency,
    totalBalance,
    productAmount,
}) => {
    const nameStyle = {
        fontSize: '19px',
    };

    return (
        <div>
            <p>
                <span style={nameStyle}>{name}</span>님, 오늘도 화이팅이에요!
            </p>
            <ProfileJob jobName={jobName} pay={pay} currency={currency} />
            <ProfileAsset totalBalance={totalBalance} currency={currency} />
            <ProfileProduct productAmount={productAmount} />
        </div>
    );
};

export default ProfileRow;
