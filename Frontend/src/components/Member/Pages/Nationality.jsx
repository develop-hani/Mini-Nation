// NationalityPage.jsx (Organism)
import React from 'react';
import joinImg from '../../../assets/images/join.jpg';
import MemberTitle from '../Atoms/MemberTitle.jsx';
import styles from './Nationality.module.css';
import NationalityInfo from '../Organisms/NationalityInfo.jsx';

const Nationality = () => {
    return (
        <div className={styles.background}>
            <div className={styles.container}>
                <MemberTitle title="국가가입" size={40} />
                <div className={styles.container2}>
                    <img src={joinImg} className={styles.img} alt="" />
                    <NationalityInfo />
                </div>
            </div>
        </div>
    );
};

export default Nationality;
