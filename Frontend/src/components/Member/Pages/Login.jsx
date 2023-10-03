import styles from './Login.module.css';
import LoginInputForm from '../Molecules/LoginInputForm.jsx';
import loginImage from '../../../assets/images/login.png';
import MemberTitle from '../Atoms/MemberTitle.jsx';

const Login = () => {
    return (
        <div className={styles.background}>
            <div>
                <div>
                    <MemberTitle title="로그인" size={40} />
                </div>
                <div className={styles.container}>
                    <div className={styles.inputContainer}>
                        <LoginInputForm />
                    </div>
                    <div className={styles.imageContainer}>
                        <img
                            className={styles.img}
                            src={loginImage}
                            alt="login"
                        />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Login;
