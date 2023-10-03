import React, { useState } from 'react';
import styles from './HomeCard.module.css';

function Card({ title, content, contentStyle, gif }) {
    const [isHovered, setIsHovered] = useState(false);

    return (
        <div
            className={styles.card}
            onMouseEnter={() => setIsHovered(true)}
            onMouseLeave={() => setIsHovered(false)}
        >
            <div className={`${styles.title} ${isHovered && styles.imgHover}`}>
                <img className={styles.img} src={gif} alt="image" />
                {title}
            </div>
            <div
                className={`${styles.content} ${
                    contentStyle && styles[contentStyle]
                }`}
            >
                {content}
            </div>
        </div>
    );
}

export default Card;
