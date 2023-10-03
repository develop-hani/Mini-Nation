import React, { useState } from 'react';
import Swal from 'sweetalert2';
import styles from './ProductionApplicantModal.module.css'; // CSS 모듈 가져오기
import ProductionTitle from '../Atoms/ProductionTitle.jsx';
import ProductionButton1 from '../Atoms/ProductionButton1.jsx';
import ProductionSemiTitle from '../Molecules/ProductionSemiTitle.jsx';

const ProductionApplicantModal = ({ applicants, setIsModalOpen }) => {
    const handleCloseClick = () => {
        setIsModalOpen(false); // Close the modal
    };

    const handleApprove = applicantName => {
        Swal.fire({
            icon: 'question',
            title: '승인하시겠습니까?',
            showCancelButton: true,
            confirmButtonText: '확인',
            cancelButtonText: '취소',
        }).then(result => {
            if (result.isConfirmed) {
                // 승인 처리 로직을 구현하고, 필요한 API 호출을 수행합니다.
                // 승인 처리가 완료되면 다음 모달 창을 띄웁니다.
                Swal.fire({
                    icon: 'success',
                    title: '승인하였습니다.',
                    confirmButtonText: '확인',
                });
            }
        });
    };

    const handleReject = applicantName => {
        Swal.fire({
            icon: 'warning',
            title: '거절하시겠습니까?',
            showCancelButton: true,
            confirmButtonText: '확인',
            cancelButtonText: '취소',
        }).then(result => {
            if (result.isConfirmed) {
                // 거절 처리 로직을 구현하고, 필요한 API 호출을 수행합니다.
                // 거절 처리가 완료되면 다음 모달 창을 띄웁니다.
                Swal.fire({
                    icon: 'success',
                    title: '거절하였습니다.',
                    confirmButtonText: '확인',
                });
            }
        });
    };

    const handleFire = employeeName => {
        Swal.fire({
            icon: 'error',
            title: '해고하시겠습니까?',
            showCancelButton: true,
            confirmButtonText: '확인',
            cancelButtonText: '취소',
        }).then(result => {
            if (result.isConfirmed) {
                // 해고 처리 로직을 구현하고, 필요한 API 호출을 수행합니다.
                // 해고 처리가 완료되면 다음 모달 창을 띄웁니다.
                Swal.fire({
                    icon: 'success',
                    title: '해고하였습니다.',
                    confirmButtonText: '확인',
                });
            }
        });
    };

    const applicantRows = applicants.applicant.map(applicantName => (
        <div key={applicantName}>
            <hr />
            <div className={styles.modalRow}>
                <div className={styles.modalRowName}>
                    <p>{applicantName}</p>
                </div>
                <div className={styles.modalRowButtons}>
                    <ProductionButton1
                        title="승인"
                        onClick={() => handleApprove(applicantName)}
                        color="#2B788B"
                    />
                    <ProductionButton1
                        title="거절"
                        onClick={() => handleReject(applicantName)}
                        color="#2B788B"
                    />
                </div>
            </div>
        </div>
    ));

    const employeeRows = applicants.employee.map(employeeName => (
        <div key={employeeName}>
            <hr />
            <div className={styles.modalRow}>
                <div className={styles.modalRowName}>
                    <p>{employeeName}</p>
                </div>
                <div className={styles.modalRowButtons}>
                    <ProductionButton1
                        title="해고"
                        onClick={() => handleFire(employeeName)}
                        color="#8B3C2B"
                    />
                </div>
            </div>
        </div>
    ));

    const semiTitle = `인원수: 신청 ${applicants.applicant_count} 모집 ${applicants.recruit_total_count} 근로 ${applicants.employee_count} 잔여 ${applicants.recruit_left_count}`;

    return (
        <div className={styles.wrapper}>
            <div className={styles.closeButtonWrapper}>
                <button
                    className={styles.closeButton}
                    onClick={handleCloseClick}
                    type="button"
                >
                    X
                </button>
            </div>
            <div className={styles.modalCard}>
                <div className={styles.modalTitle} />
                <ProductionTitle title="신청자명단" size={30} />
                <ProductionSemiTitle title={semiTitle} />
                <div>{applicantRows}</div>
                <div style={{ height: '40px' }} />
                <ProductionTitle title="직원명단" size={30} />
                <br />
                <div>{employeeRows}</div>
            </div>
        </div>
    );
};

export default ProductionApplicantModal;
