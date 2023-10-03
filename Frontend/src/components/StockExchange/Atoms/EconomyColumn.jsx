import React from 'react';
import styles from './EconomyColumn.css';

function Card({ title, content, alignItems }) {
    let contentStyle = styles.content;
    if (alignItems) {
        contentStyle += ` ${styles[alignItems]}`;
    }

    return (
        <div className={styles.card}>
            <div className={styles.title}>{title}</div>
            <div className={contentStyle}>{content}</div>
        </div>
    );
}

export default Card;
