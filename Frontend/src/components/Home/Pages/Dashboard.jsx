import React from 'react';
import NavBar from '../../Common/Organisms/NavBar.jsx';
import Nation from '../Organisms/Nation.jsx';
import Constitution from '../Organisms/Constitution.jsx';
import Population from '../Organisms/Population.jsx';
import styles from './Dashboard.module.css';
import Ranking from '../Organisms/Ranking.jsx';
import Economy from '../Organisms/Economy.jsx';
import Profile from '../Organisms/Profile.jsx';

const Dashboard = () => {
    return (
        <div className={styles.body}>
            <NavBar username="준혁" totalBalance="30000" />
            <div className={styles.container}>
                <div className={styles.nation}>
                    <Nation />
                </div>
                <div className={styles.profile}>
                    <Profile />
                </div>
                <div className={styles.constitution}>
                    <Constitution />
                </div>
                <div className={styles.ranking}>
                    <Ranking />
                </div>
                <div className={styles.population}>
                    <Population />
                </div>
                <div className={styles.economy}>
                    <Economy />
                </div>
            </div>
        </div>
    );
};

export default Dashboard;
