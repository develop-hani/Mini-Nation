import React, { useState, useEffect } from 'react';
import useHomeApi from '../../../api/useHomeApi';
import HomeCard from '../Molecules/HomeCard';
import cardGif from '../../../assets/gif/profile.gif';
import ProfileRow from '../Molecules/ProfileRow.jsx';

const Profile = () => {
    const [response, setResponse] = useState({});
    const { name, jobName, pay, currency, totalBalance, productAmount } =
        response;
    // const response = {
    //     name: '정준혁',
    //     jobName: '은행원',
    //     pay: 200,
    //     currency: '미소',
    //     totalBalance: 5000,
    //     productAmount: 3,
    // };

    const getProfileApi = async () => {
        const response = await useHomeApi.homeGetProfile();
        if (response.code === 200) {
            setResponse(response.data);
        }
    };

    useEffect(() => {
        getProfileApi();
    }, []);

    const contentDom = (
        <div>
            <ProfileRow
                name={name}
                jobName={jobName}
                pay={pay}
                currency={currency}
                totalBalance={totalBalance}
                productAmount={productAmount}
            />
        </div>
    );

    return (
        <div>
            <HomeCard
                title="프로필"
                content={contentDom}
                gif={cardGif}
                contentStyle="center"
            />
        </div>
    );
};

export default Profile;
