import React from 'react';
import './BankContent1.css';

function BankContent1() {
    const transactions = [
        {
            id: 1,
            account: '청구계좌',
            category: '식비',
            amount: 5000,
            balance: 95000,
            date: '2023-09-19',
        },
        {
            id: 1,
            account: '청구계좌',
            category: '식비',
            amount: 5000,
            balance: 95000,
            date: '2023-09-19',
        },
        {
            id: 1,
            account: '청구계좌',
            category: '식비',
            amount: 3000,
            balance: 95000,
            date: '2023-09-19',
        },
        {
            id: 1,
            account: '청구계좌',
            category: '식비',
            amount: 5000,
            balance: 95000,
            date: '2023-09-19',
        },
        {
            id: 1,
            account: '청구계좌',
            category: '식비',
            amount: 5000,
            balance: 95000,
            date: '2023-09-19',
        },
        {
            id: 1,
            account: '청구계좌',
            category: '식비',
            amount: 99000,
            balance: 95000,
            date: '2023-09-19',
        },
    ];

    return (
        <div className="bankContentTableWrapper">
            <table border="1">
                <thead>
                    <tr>
                        <th>입출금처</th>
                        <th>분류</th>
                        <th>입출금금액</th>
                        <th>잔액</th>
                        <th>날짜</th>
                    </tr>
                </thead>
                <tbody>
                    {transactions.map(transaction => (
                        <tr key={transaction.id}>
                            <td>{transaction.account}</td>
                            <td>{transaction.category}</td>
                            <td>{transaction.amount}</td>
                            <td>{transaction.balance}</td>
                            <td>{transaction.date}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default BankContent1;
