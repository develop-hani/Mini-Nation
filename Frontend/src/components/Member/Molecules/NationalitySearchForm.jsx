import React from 'react';
import MemberTitle from '../Atoms/MemberTitle.jsx';
import InputSearch1 from '../../Common/Atoms/InputSearch1.jsx';

const NationalitySearchForm = ({ text, onChange, onClick, className }) => {
    const containerStyle = {
        display: 'flex',
        justifyContent: 'space-between',
    };
    return (
        <div>
            <MemberTitle title="국가명 검색 (개발의민족)" size="20" />
            <hr style={{ border: '1px solid grey' }} />
            <InputSearch1
                text={text}
                onChange={onChange}
                onClick={onClick}
                className={className}
                style={containerStyle}
            />
        </div>
    );
};

export default NationalitySearchForm;
