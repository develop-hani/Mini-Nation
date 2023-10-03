import React from 'react';
import useNavigation from '../../../hooks/useNavigation';
import styles from './Profile.module.css';

function ProfileProduct({ productAmount }) {
    const { navigateToMarketPage } = useNavigation();

    if (productAmount) {
        return (
            <p>
                가지고 있는 물품 수는{' '}
                <a className={styles.aStyle} onClick={navigateToMarketPage}>
                    {productAmount}
                </a>{' '}
                개 입니다.
            </p>
        );
    } else {
        return (
            <p>
                가지고 있는 물품이 없습니다.{' '}
                <a className={styles.aStyle} onClick={navigateToMarketPage}>
                    백화점 이동
                </a>
            </p>
        );
    }
}

export default ProfileProduct;
