import React from 'react';
import PopulationRow from '../Molecules/PopulationRow';
import HomeCard from '../Molecules/HomeCard';
import cardGif from '../../../assets/gif/population.gif';

const Population = () => {
    const response = {
        president: '이정화',
        citizen: [
            '김싸피',
            '박싸피',
            '김싸피',
            '박싸피',
            '김싸피',
            '박싸피',
            '김싸피',
            '박싸피',
            '김싸피',
            '박싸피',
            '김싸피',
            '박싸피',
            '김싸피',
            '박싸피',
        ],
    };
    const { president, citizen } = response;
    const contentDom = (
        <>
            <PopulationRow name={president} role="대통령" />
            {citizen.map((name, idx) => (
                <PopulationRow key={idx} name={name} role="국민" />
            ))}
        </>
    );

    return (
        <div>
            <HomeCard
                title={`인구(${citizen.length + 1}명)`}
                content={contentDom}
                gif={cardGif}
                contentStyle="wrap"
            />
        </div>
    );
};

export default Population;
