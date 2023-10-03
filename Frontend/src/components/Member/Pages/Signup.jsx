import React from 'react';
import SignupInputForm from '../Molecules/SignupInputForm.jsx';
import styles from './Login.module.css';
import signupImage from '../../../assets/images/signup.png';
import MemberTitle from '../Atoms/MemberTitle';

const Signup = () => {
    return (
        <div className={styles.background}>
            <div>
                <div>
                    <MemberTitle title="회원가입" size={40} />
                </div>
                <div className={styles.container}>
                    <div className={styles.inputContainer}>
                        <SignupInputForm />
                    </div>
                    <div className={styles.imageContainer}>
                        <img
                            className={styles.img}
                            src={signupImage}
                            alt="signup"
                        />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Signup;
