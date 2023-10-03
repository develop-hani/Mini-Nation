import React, { useState } from 'react';
import { useNavigation } from '../../../hooks/useNavigation.jsx';
import NavBar from '../../Common/Organisms/NavBar.jsx';
import styles from './OfficeFix.module.css';
import AdminTitle from '../Atoms/AdminTitle.jsx';
import backgroundImage from '../../../assets/images/office.png';
import InfoRow from '../Molecules/InfoRow.jsx';
import ButtonMiddle1 from '../../Common/Atoms/ButtonMiddle1.jsx';
import RowInput from '../Atoms/RowInput.jsx';
import RowDescription from '../Atoms/RowDescription.jsx';
import DropDown2 from '../../Common/Atoms/DropDown2.jsx'; // DropDown2 컴포넌트 추가

const OfficeFix = () => {
    const { navigateToOffice } = useNavigation();
    const [inputText, setInputText] = useState('');
    const [currencyName, setCurrencyName] = useState('');
    const [selectedDay, setSelectedDay] = useState('월요일');
    const [selectedIncomeTax, setSelectedIncomeTax] = useState(10);
    const [selectedVAT, setSelectedVAT] = useState(5);

    const [dropdownStates, setDropdownStates] = useState({
        dropdown1: false,
        dropdown2: false,
        dropdown3: false,
    });

    const closeOtherDropdowns = currentDropdown => {
        const updatedDropdownStates = {};
        // eslint-disable-next-line no-restricted-syntax
        for (const key of Object.keys(dropdownStates)) {
            if (key === currentDropdown) {
                updatedDropdownStates[key] = true;
            } else {
                updatedDropdownStates[key] = false;
            }
        }
        setDropdownStates(updatedDropdownStates);
    };

    const handleInputTextChange = value => {
        setInputText(value);
    };

    const handleCurrencyNameChange = value => {
        setCurrencyName(value);
    };

    const handleDayChange = value => {
        setSelectedDay(value);
    };

    const handleIncomeTaxChange = value => {
        setSelectedIncomeTax(value);
    };

    const handleVATChange = value => {
        setSelectedVAT(value);
    };

    return (
        <div>
            <NavBar username="준혁" totalBalance="30000" />
            <div
                className={styles.background}
                style={{ backgroundImage: `url(${backgroundImage})` }}
            >
                <div
                    style={{
                        paddingTop: '2%',
                        paddingBottom: '1%',
                        textAlign: 'center',
                    }}
                >
                    <AdminTitle title="집무실" size="40" />
                </div>
                <div className={styles.info}>
                    <div className={styles.content}>
                        <AdminTitle title="국가정보" size={30} />
                        <hr style={{ border: '1px solid black' }} />
                        <InfoRow
                            title="국가명"
                            secondComp={
                                <RowInput
                                    text={inputText}
                                    onTextChange={handleInputTextChange}
                                    width={120}
                                />
                            }
                            thirdComp={
                                <RowDescription text="한글 기준 8자 이내" />
                            }
                        />
                        <InfoRow
                            title="화폐명"
                            secondComp={
                                <RowInput
                                    text={currencyName}
                                    onTextChange={handleCurrencyNameChange}
                                    width={120}
                                />
                            }
                            thirdComp={<RowDescription text="한글 2자 이내" />}
                        />
                        {/* 주급 수령일 드롭다운 추가 */}
                        <InfoRow
                            title="주급 수령일"
                            secondComp={
                                <DropDown2
                                    options={[
                                        '월요일',
                                        '화요일',
                                        '수요일',
                                        '목요일',
                                        '금요일',
                                        '토요일',
                                        '일요일',
                                    ]}
                                    selectedValue={selectedDay}
                                    onValueChange={handleDayChange}
                                    isOpen={dropdownStates.dropdown1}
                                    closeOtherDropdowns={() =>
                                        closeOtherDropdowns('dropdown1')
                                    }
                                />
                            }
                            thirdComp={<RowDescription text="" />}
                        />
                        <InfoRow
                            title="소득세"
                            secondComp={
                                <DropDown2
                                    options={Array.from(
                                        { length: 101 },
                                        (_, i) => `${i}`,
                                    )} // 0%부터 100%까지 배열 생성
                                    selectedValue={`${selectedIncomeTax}%`}
                                    onValueChange={handleIncomeTaxChange}
                                    isOpen={dropdownStates.dropdown2}
                                    closeOtherDropdowns={() =>
                                        closeOtherDropdowns('dropdown2')
                                    }
                                />
                            }
                            thirdComp={<RowDescription text="" />}
                        />
                        <InfoRow
                            title="부가가치세"
                            secondComp={
                                <DropDown2
                                    options={Array.from(
                                        { length: 101 },
                                        (_, i) => `${i}`,
                                    )}
                                    selectedValue={`${selectedVAT}%`}
                                    onValueChange={handleVATChange}
                                    isOpen={dropdownStates.dropdown3}
                                    closeOtherDropdowns={() =>
                                        closeOtherDropdowns('dropdown3')
                                    }
                                />
                            }
                            thirdComp={<RowDescription text="" />}
                        />
                        <div style={{ display: 'flex', justifyContent: 'end' }}>
                            <ButtonMiddle1
                                title="완료"
                                onClick={navigateToOffice}
                                style={{ marginLeft: 'auto' }}
                            />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default OfficeFix;
