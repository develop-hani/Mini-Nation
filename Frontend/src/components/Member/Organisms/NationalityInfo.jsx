import React, { useState } from 'react';
import { useNavigation } from '../../../hooks/useNavigation.jsx';
import NationalitySearchForm from '../Molecules/NationalitySearchForm.jsx';
import NationalityResult from '../Molecules/NationalityResult.jsx';
import NationalityError from '../Molecules/NationalityError.jsx';
import ButtonMiddle1 from '../../Common/Atoms/ButtonMiddle1.jsx';
import styles from './NationalityInfo.module.css';

const NationalityInfo = () => {
    const { navigateToDashboard } = useNavigation();
    const [searchText, setSearchText] = useState('개발의민족');
    const [presidentText, setPresidentText] = useState('김영석');
    const [searchResult, setSearchResult] = useState(null);
    const [presidentName, setPresidentName] = useState('김영석');
    const [showPresidentInput, setShowPresidentInput] = useState(false);
    const [errorMsg, setErrorMsg] = useState('');
    // 실제 api 연결시 수정
    const handleSelectButtonClick = () => {
        setShowPresidentInput(true);
        setPresidentName('김영석');
    };

    const handleChange = event => {
        setSearchText(event.target.value);
    };

    const handleConfirmButtonClick = () => {
        setErrorMsg('');
        if (presidentName === presidentText) {
            // eslint-disable-next-line no-alert
            alert(`'${searchResult}' 국가에 가입되셨습니다.`);
            navigateToDashboard();
        } else {
            setErrorMsg('대통령 이름이 일치하지 않습니다.');
        }
    };
    const handleClick = async () => {
        try {
            // 실제 API 요청을 보내는 부분
            const response = await fetch(`API_URL?query=${searchText}`);
            const data = await response.json();

            if (data && data.results.length > 0) {
                const countryName = data.results[0].name;
                setSearchResult(countryName);
            } else {
                setSearchResult('');
            }
        } catch (error) {
            // eslint-disable-next-line no-console
            console.error('API 요청 에러:', error);
            setSearchResult('');
        }

        if (searchText === '개발의민족') {
            setSearchResult('개발의민족');
        } else {
            setSearchResult('');
        }
        setShowPresidentInput(false);
    };
    return (
        <div className={styles.info}>
            <div className={styles.infoContent}>
                <NationalitySearchForm
                    text={searchText}
                    onChange={handleChange}
                    onClick={handleClick}
                    className={styles.search}
                />
                {searchResult === '' && (
                    <p>해당 이름의 국가가 존재하지 않습니다.</p>
                )}
                {searchResult !== null && searchResult !== '' && (
                    <div className={styles.resultSplitter}>
                        <div className={styles.resultContainer}>
                            <div>{searchResult}</div>
                            <ButtonMiddle1
                                title="선택"
                                onClick={handleSelectButtonClick}
                                height={40}
                                width={70}
                            />
                        </div>
                        {showPresidentInput && (
                            <>
                                <NationalityResult
                                    presidentText={presidentText}
                                    onTextChange={setPresidentText}
                                    onKeyPress={handleConfirmButtonClick}
                                />
                                {errorMsg && (
                                    <NationalityError errorMsg={errorMsg} />
                                )}
                            </>
                        )}
                    </div>
                )}
            </div>
        </div>
    );
};

export default NationalityInfo;
