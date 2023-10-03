import React from 'react';
import './BankContent1.css';
import BankButtonSmall from '../Atoms/BankButtonSmall.jsx';

function BankContent3() {
    const transactions = [
        {
            id: 1,
            account: '청구계좌',
            category: '식비',
            date: '2023-09-19',
            rate: '40%',
            balance: 95000,
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
                        <th>이자율</th>
                        <th>금액</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    {transactions.map(transaction => (
                        <tr key={transaction.id}>
                            <td>{transaction.account}</td>
                            <td>{transaction.category}</td>
                            <td>{transaction.date}</td>
                            <td>{transaction.rate}</td>
                            <td>{transaction.balance}</td>
                            <td>{transaction.button}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default BankContent3;
