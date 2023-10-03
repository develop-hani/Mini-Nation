import React from 'react';
import { useNavigation } from '../../../hooks/useNavigation.jsx';
// import LandingTitle from '../Atoms/LandingTitle.jsx';
// import ButtonLending1 from '../../Common/Atoms/ButtonLending1.jsx';
import StartButton from '../../Common/Atoms/StartButton.jsx';
import styles from '../Pages/Landing.module.css';
import landingImage from '../../../assets/images/landing-image.png';

function LandingLayout() {
    const { navigateToLogin } = useNavigation();

    return (
        <div className={styles.landingLayout}>
            {/* <LandingTitle title="내 손으로 만드는 경제" /> */}
            <img src={landingImage} className={styles.img} alt="landing" />
            <StartButton title="지금 시작하기" onClick={navigateToLogin} />
        </div>
    );
}

export default LandingLayout;
