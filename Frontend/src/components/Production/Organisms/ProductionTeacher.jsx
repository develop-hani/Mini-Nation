/* eslint-disable prettier/prettier */
import React, { useState } from 'react';
import uuid from 'react-uuid';
import swal from 'sweetalert2';
import ProductionRow from '../Molecules/ProductionRow.jsx';
import ProductionTitle from '../Atoms/ProductionTitle.jsx';
import ProductionButton1 from '../Atoms/ProductionButton1.jsx';
import ProductionRequirement from '../Atoms/ProductionRequirement.jsx';
import styles from './ProductionTeacher.module.css';
import ProductionApplicantModal from './ProductionApplicantModal.jsx';
import ProductionCategoryTeacher from "../Molecules/ProductionCatergoryTeacher.jsx";

const ProductionTeacher = ({ jobList }) => {
    // --------------직원 관리하기-------------------
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [applicants, setApplicants] = useState(''); // applicants 상태 추가

    const handleManageClick = name => {
        // api 요청 등 필요한 데이터 처리
        const applicantsData = {
            applicant_count: 2,
            recruit_total_count: 4,
            employee_count: 2,
            recruit_left_count: 2,
            applicant: ['김하늘', '이예은'],
            employee: ['김싸피', '최싸피'],
        };

        // 데이터를 상태로 설정
        setApplicants(applicantsData);
        setIsModalOpen(true);
    };
    // ---------------------------------------------
    const handleDeleteClick = name => {
        swal.fire({
            icon: 'warning',
            title: '삭제하시겠습니까?',
            showCancelButton: true,
            confirmButtonText: '확인',
            cancelButtonText: '취소',
        }).then(result => {
            if (result.isConfirmed) {
                // 삭제 처리 로직을 구현하고, 필요한 API 호출을 수행합니다.
                swal.fire({
                    icon: 'success',
                    title: '삭제하였습니다.',
                    confirmButtonText: '확인',
                });
            }
        });
    };


    const productionRows = jobList.map(job => (
        <ProductionRow
            key={uuid()} // Use a unique identifier (e.g., job.id) as the key
            Comp1={<ProductionTitle title={job.name} />}
            Comp2={<ProductionTitle title={job.desc} />}
            Comp3={<ProductionTitle title={`급여: ${job.pay} 만원`} />}
            Comp4={
                <ProductionTitle
                    title={`채용 인원: ${job.recruit_total_count}명`}
                />
            }
            Comp5={
                <ProductionTitle title={`지원자 수: ${job.apply_count}명`} />
            }
            Comp6={
                <ProductionRequirement
                    title={`자격 요건: ${job.requirement}`}
                />
            }
            Comp7={
                <ProductionButton1
                    title="인원관리"
                    onClick={() => handleManageClick(job.name)}
                    color="#2B788B"
                />
            }
            Comp8={
                <ProductionButton1
                    title="삭제하기"
                    onClick={() => handleDeleteClick(job.name)}
                    color="#2B788B"
                />
            }
            className={styles.container}
        />
    ));

    return (
        <div className={styles.productionTeacher}>
            <ProductionCategoryTeacher />
            {productionRows}
            {isModalOpen && (
                <div className={styles.modalBackground}>                
                <ProductionApplicantModal
                    applicants={applicants} // applicants 전달
                    setIsModalOpen={setIsModalOpen}
                />
            </div>
            )}
        </div>
    );
};

export default ProductionTeacher;
