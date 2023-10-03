import React from 'react';
import LandingLayout from '../Molecules/LandingLayout.jsx';
import styles from './Landing.module.css';

const Landing = () => {
    return (
        <div className={styles.background}>
            <LandingLayout />
        </div>
    );
};

export default Landing;
