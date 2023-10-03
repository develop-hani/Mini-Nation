import React, { useState } from 'react';

function ButtonRadio1({ setData }) {
    const [selectedOption, setSelectedOption] = useState('학생');

    const handleRadioChange = event => {
        setSelectedOption(event.target.value);
    };

    setData(selectedOption);

    return (
        <div>
            <label htmlFor="option1">
                <input
                    type="radio"
                    id="option1"
                    value="학생"
                    checked={selectedOption === '학생'}
                    onChange={handleRadioChange}
                />
                학생
            </label>
            <label htmlFor="option2">
                <input
                    type="radio"
                    id="option2"
                    value="선생님"
                    checked={selectedOption === '선생님'}
                    onChange={handleRadioChange}
                />
                선생님
            </label>
        </div>
    );
}

export default ButtonRadio1;
