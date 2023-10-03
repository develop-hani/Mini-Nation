import React from 'react';
import MemberTitle from '../Atoms/MemberTitle.jsx';
import RowInput from '../../Admin/Atoms/RowInput.jsx';
import ButtonMiddle1 from '../../Common/Atoms/ButtonMiddle1.jsx';

const NationalityResult = ({ presidentText, onTextChange, onKeyPress }) => {
    const hrStyle = { border: '1px solid grey', marginBottom: '0px' };
    const inputContainer = {
        display: 'flex',
        justifyContent: 'space-between',
        overflow: 'auto',
        flexWrap: 'wrap',
        marginTop: '4%',
    };
    return (
        <div>
            <MemberTitle title="대통령 성함" size="20" />
            <hr style={hrStyle} />
            <div style={inputContainer}>
                <RowInput
                    text={presidentText}
                    onTextChange={onTextChange}
                    onKeyPress={onKeyPress}
                    width={80}
                />
                <ButtonMiddle1
                    title="확인"
                    onClick={onKeyPress}
                    height={40}
                    width={70}
                    style={{ marginTop: '20px' }}
                />
            </div>
        </div>
    );
};

export default NationalityResult;
