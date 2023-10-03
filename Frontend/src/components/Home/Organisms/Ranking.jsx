import React, { useState, useEffect } from 'react';
import useHomeApi from '../../../api/useHomeApi';
import RankingRow from '../Molecules/RankingRow';
import HomeCard from '../Molecules/HomeCard';
import cardGif from '../../../assets/gif/ranking.gif';
import ranking1 from '../../../assets/images/medal1.png';
import ranking2 from '../../../assets/images/medal2.png';
import ranking3 from '../../../assets/images/medal3.png';

const imageUrls = [ranking1, ranking2, ranking3];

const Ranking = () => {
    const [response, setResponse] = useState({ rich: [] });

    const getRichApi = async () => {
        const response = await useHomeApi.homeGetRich();
        if (response.code === 200) {
            setResponse(response.data);
        }
    };

    const { rich } = response;

    useEffect(() => {
        getRichApi();
    }, []);

    const contentDom = (
        <>
            {rich.map((citizen, idx) => (
                <RankingRow
                    key={citizen.name}
                    img={imageUrls[idx]}
                    ranking={idx + 1}
                    name={citizen.name}
                    asset={citizen.asset}
                />
            ))}
        </>
    );

    return (
        <div>
            <HomeCard
                title="순위"
                content={contentDom}
                gif={cardGif}
                contentStyle="center"
            />
        </div>
    );
};

export default Ranking;
