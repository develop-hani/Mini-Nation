import React from 'react';

function TabHeader1({ prop1, prop2 }) {
    const varExample = '예시입니다';
    const one = 1;
    const two = 2;
    const functionExample = (var1, var2) => {
        return var1 + var2;
    };
    return (
        <div>
            {/* variable 사용 예시 */}
            <div>{varExample}</div>
            {/* props 사용 예시 */}
            <div>{prop1}</div>
            <div>{prop2}</div>
            <div>
                {one}+{two}={functionExample(one, two)}
            </div>
        </div>
    );
}

export default TabHeader1;
