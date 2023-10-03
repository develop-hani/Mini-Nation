import React from 'react';
import useNavigation from '../../../hooks/useNavigation';
import styles from './Profile.module.css';

function ProfileAsset({ totalBalance, currency }) {
    const { navigateToBankPage } = useNavigation();

    if (totalBalance) {
        return (
            <p>
                가지고 있는 총 자산은{' '}
                <a className={styles.aStyle} onClick={navigateToBankPage}>
                    {totalBalance}
                    {currency}
                </a>{' '}
                입니다.
            </p>
        );
    } else {
        return (
            <p>
                아직 자산이 없습니다.{' '}
                <a className={styles.aStyle} onClick={navigateToBankPage}>
                    은행 이동
                </a>
            </p>
        );
    }
}

export default ProfileAsset;
