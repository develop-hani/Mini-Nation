import React from 'react';
import styles from './ProductionCategoryTeacher.module.css';

const ProductionCategoryTeacher = () => {
    return (
        <div className={styles.container}>
            <div className={styles.ProductionTitle1}>직업명</div>
            <div className={styles.ProductionTitle2}>직업설명</div>
            <div className={styles.ProductionTitle3}>주급</div>
            <div className={styles.ProductionTitle4}>모집인원</div>
            <div className={styles.ProductionTitle5}>신청인원</div>
            <div className={styles.ProductionTitle6}>자격요건</div>
            <div className={styles.ProductionTitle7}>인원관리</div>
            <div className={styles.ProductionTitle8}>삭제하기</div>
        </div>
    );
};

export default ProductionCategoryTeacher;
