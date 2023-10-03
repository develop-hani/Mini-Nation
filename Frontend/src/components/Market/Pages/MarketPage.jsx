import React from 'react';
import { useRecoilState } from 'recoil';
import NavBar from '../../Common/Organisms/NavBar.jsx';
import './MarketPage.css';
import { identityState } from '../../../recoil/atoms.jsx';
import MarketStudent from '../Organisms/MarketStudent.jsx';
import MarketTeacher from '../Organisms/MarketTeacher.jsx';

const MarketPage = () => {
    const [identity] = useRecoilState(identityState);

    return (
        <div>
            <NavBar username="준혁" totalBalance="30000" />
            {identity === 'ST' && <MarketStudent />}
            {identity === 'TC' && <MarketTeacher />}
        </div>
    );
};

export default MarketPage;
