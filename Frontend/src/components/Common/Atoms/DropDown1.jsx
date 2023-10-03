import React, { useState } from 'react';

function DropDown1({ label = 'Choose an option:', options = [] }) {
    const [selectedValue, setSelectedValue] = useState('');

    const handleDropDownChange = event => {
        setSelectedValue(event.target.value);
    };

    return (
        <div>
            <label htmlFor="dropdown1">
                {label}
                <select
                    id="dropdown1"
                    value={selectedValue}
                    onChange={handleDropDownChange}
                >
                    <option value=""> </option>
                    {options.map(option => (
                        <option key={option.value} value={option.value}>
                            {option.label}
                        </option>
                    ))}
                </select>
            </label>

            <p>선택된 값: {selectedValue}</p>
        </div>
    );
}

export default DropDown1;
