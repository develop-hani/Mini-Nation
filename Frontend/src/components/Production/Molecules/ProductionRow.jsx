import React from 'react';
import styles from './ProductionRow.module.css';

const ProductionRow = ({
    Comp1,
    Comp2,
    Comp3,
    Comp4,
    Comp5,
    Comp6,
    Comp7,
    Comp8,
}) => {
    return (
        <div className={styles.container}>
            <div className={styles.Comp1}>{Comp1}</div>
            <div className={styles.Comp2}>{Comp2}</div>
            <div className={styles.Comp3}>{Comp3}</div>
            <div className={styles.Comp4}>{Comp4}</div>
            <div className={styles.Comp5}>{Comp5}</div>
            <div className={styles.Comp6}>{Comp6}</div>
            <div className={styles.Comp7}>{Comp7}</div>
            <div className={styles.Comp8}>{Comp8}</div>
        </div>
    );
};

export default ProductionRow;
