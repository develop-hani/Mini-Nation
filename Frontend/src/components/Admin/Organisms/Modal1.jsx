/* eslint-disable no-unused-vars */
/* eslint-disable jsx-a11y/no-static-element-interactions */
/* eslint-disable jsx-a11y/click-events-have-key-events */
/* eslint-disable react/no-unstable-nested-components */
/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { useState } from 'react';
import styles from './Modal1.module.css'; // CSS 모듈 가져오기
import AdminTitle from '../Atoms/AdminTitle.jsx';
import { ReactComponent as Flag1 } from '../../../assets/icons/Foundation/Flag1.svg';
import { ReactComponent as Flag2 } from '../../../assets/icons/Foundation/Flag2.svg';
import { ReactComponent as Flag3 } from '../../../assets/icons/Foundation/Flag3.svg';
import { ReactComponent as Flag4 } from '../../../assets/icons/Foundation/Flag4.svg';
import { ReactComponent as Flag5 } from '../../../assets/icons/Foundation/Flag5.svg';
import { ReactComponent as Flag6 } from '../../../assets/icons/Foundation/Flag6.svg';
import { ReactComponent as Flag7 } from '../../../assets/icons/Foundation/Flag7.svg';
import { ReactComponent as Flag8 } from '../../../assets/icons/Foundation/Flag8.svg';
import { ReactComponent as Flag9 } from '../../../assets/icons/Foundation/Flag9.svg';
import { ReactComponent as Flag10 } from '../../../assets/icons/Foundation/Flag10.svg';
import { ReactComponent as Checked1 } from '../../../assets/icons/Foundation/Checked1.svg';
import { ReactComponent as Checked2 } from '../../../assets/icons/Foundation/Checked2.svg';
import { ReactComponent as Checked3 } from '../../../assets/icons/Foundation/Checked3.svg';
import { ReactComponent as Checked4 } from '../../../assets/icons/Foundation/Checked4.svg';
import { ReactComponent as Checked5 } from '../../../assets/icons/Foundation/Checked5.svg';
import { ReactComponent as Checked6 } from '../../../assets/icons/Foundation/Checked6.svg';
import { ReactComponent as Checked7 } from '../../../assets/icons/Foundation/Checked7.svg';
import { ReactComponent as Checked8 } from '../../../assets/icons/Foundation/Checked8.svg';
import { ReactComponent as Checked9 } from '../../../assets/icons/Foundation/Checked9.svg';
import { ReactComponent as Checked10 } from '../../../assets/icons/Foundation/Checked10.svg';

const Modal1 = ({
    handleClick,
    selectedDay,
    selectedIncomeTax,
    selectedVAT,
    inputText,
    currencyInputText,
    setIsModalOpen,
}) => {
    const [selectedFlag, setSelectedFlag] = useState(null);

    const handleFlagClick = flagNumber => {
        if (selectedFlag === flagNumber) {
            setSelectedFlag(null);
        } else {
            setSelectedFlag(flagNumber);
        }
    };

    const handleAcceptClick = () => {
        if (selectedFlag === null) {
            alert('국기를 선택하세요.');
            return;
        }
        handleClick();
    };

    const handleCloseClick = () => {
        setIsModalOpen(false); // Close the modal
    };
    const FlagWithCheck = ({ flagNumber, selected, onClick }) => {
        // Define an array to map flag numbers to Flag components
        const FlagComponents = [
            null, // The first element is null to align with flag numbers
            Flag1,
            Flag2,
            Flag3,
            Flag4,
            Flag5,
            Flag6,
            Flag7,
            Flag8,
            Flag9,
            Flag10,
        ];
        const CheckedComponents = [
            null, // The first element is null to align with flag numbers
            Checked1,
            Checked2,
            Checked3,
            Checked4,
            Checked5,
            Checked6,
            Checked7,
            Checked8,
            Checked9,
            Checked10,
        ];

        const FlagComponent = FlagComponents[flagNumber];
        const isChecked = selectedFlag === flagNumber;
        const CheckedComponent = CheckedComponents[flagNumber];
        return (
            <div
                className={`${styles.flag} ${
                    isChecked ? styles.selectedFlag : ''
                }`}
                onClick={() => onClick(flagNumber)}
            >
                {isChecked ? (
                    <CheckedComponent className={styles.flag} />
                ) : (
                    <FlagComponent className={styles.flag} />
                )}
            </div>
        );
    };

    return (
        <div className={styles.wrapper}>
            <div className={styles.modalCard}>
                <button
                    className={styles.closeButton}
                    onClick={handleCloseClick}
                    type="button"
                >
                    X
                </button>
                <AdminTitle title="국기 선택" className={styles.modalTitle} />
                <div className={styles.modalCards1}>
                    <FlagWithCheck
                        flagNumber={1}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                    <FlagWithCheck
                        flagNumber={2}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                    <FlagWithCheck
                        flagNumber={3}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                    <FlagWithCheck
                        flagNumber={4}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                    <FlagWithCheck
                        flagNumber={5}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                </div>
                <div className={styles.modalCards2}>
                    <FlagWithCheck
                        flagNumber={6}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                    <FlagWithCheck
                        flagNumber={7}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                    <FlagWithCheck
                        flagNumber={8}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                    <FlagWithCheck
                        flagNumber={9}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                    <FlagWithCheck
                        flagNumber={10}
                        selectedFlag={selectedFlag}
                        onClick={handleFlagClick}
                    />
                </div>
                <button
                    className={styles.modalButton}
                    onClick={handleAcceptClick}
                    type="button"
                >
                    확인
                </button>
                <div>
                    API로 넘겨줄 정보: <br /> 국가명 : {inputText}, 화폐명 :{' '}
                    {currencyInputText}, 수령일 : {selectedDay}, 소득세 :{' '}
                    {selectedIncomeTax}, 부가가치세 : {selectedVAT}, 선택한 국기
                    번호 : {selectedFlag}
                </div>
            </div>
        </div>
    );
};

export default Modal1;
