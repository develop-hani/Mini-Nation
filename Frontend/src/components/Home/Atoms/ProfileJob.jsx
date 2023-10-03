import React from 'react';
import useNavigation from '../../../hooks/useNavigation';
import styles from './Profile.module.css';

function ProfileJob({ jobName, pay, currency }) {
    const { navigateToJobPosting } = useNavigation();
    if (jobName) {
        return (
            <p>
                현재 직업은{' '}
                <a className={styles.aStyle} onClick={navigateToJobPosting}>
                    {jobName}
                </a>{' '}
                이고, 주급은 {pay}
                {currency} 입니다.
            </p>
        );
    } else {
        return (
            <p>
                아직 직업이 없습니다.{' '}
                <a className={styles.aStyle} onClick={navigateToJobPosting}>
                    채용공고 이동
                </a>
            </p>
        );
    }
}

export default ProfileJob;
