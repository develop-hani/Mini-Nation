import React from 'react';
import './BankContent1.css';
import BankButtonSmall from '../Atoms/BankButtonSmall.jsx';

function BankContent2() {
    const transactions = [
        {
            id: 1,
            account: '정기 적금',
            category: '적금',
            date: '2023-09-19',
            amount: 5000,
            estimated: 95000,
            button: <BankButtonSmall />,
        },
        {
            id: 2,
            account: '정기 예금',
            category: '예금',
            date: '2023-09-20',
            amount: 500,
            estimated: 9000,
            button: <BankButtonSmall />,
        },
    ];

    return (
        <div className="bankContentTableWrapper">
            <table border="1">
                <thead>
                    <tr>
                        <th>상품이름</th>
                        <th>분류</th>
                        <th>기간</th>
                        <th>원금</th>
                        <th>수령예상금</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    {transactions.map(transaction => (
                        <tr key={transaction.id}>
                            <td>{transaction.account}</td>
                            <td>{transaction.category}</td>
                            <td>{transaction.date}</td>
                            <td>{transaction.amount}</td>
                            <td>{transaction.estimated}</td>
                            <td>{transaction.button}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default BankContent2;
