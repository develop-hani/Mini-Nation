import React, { useState } from 'react';
import { useRecoilState } from 'recoil';
import Swal from 'sweetalert2';
import { identityState } from '../../../recoil/atoms.jsx';
import NavBar from '../../Common/Organisms/NavBar.jsx';
import ProductionTitle from '../Atoms/ProductionTitle.jsx';
import ProductionStudent from '../Organisms/ProductionStudent.jsx';
import ProductionTeacher from '../Organisms/ProductionTeacher.jsx';
import ProductionButton2 from '../Atoms/ProductionButton2.jsx';
import styles from './JobPosting.module.css';

const JobPosting = () => {
    const [identity, setIdentity] = useRecoilState(identityState);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const jobList = [
        {
            name: '은행원',
            desc: '은행원은 고객이 맡긴 돈을 예치하고 고객의 대출을 상담하는 역할을 합니다.  그리고 개인이나 기업으로부터 단기 또는 장기의 자금을 보관하고 위탁합니다.',
            pay: '200',
            recruit_total_count: '4',
            apply_count: '5',
            requirement: '수학 1급 자격증, 책임 우수상',
            employees: ['김하늘', '이예은'],
            status: '0',
        },
        {
            name: '은행원',
            desc: '은행원은 고객이 맡긴...',
            pay: '200',
            recruit_total_count: '4',
            apply_count: '5',
            requirement: '수학 1급 자격증, 책임 우수상',
            employees: ['김하늘', '이예은'],
        },
        {
            name: '은행원',
            desc: '은행원은 고객이 맡긴 돈을 예치하고 고객의 대출을 상담하는 역할을 합니다.  그리고 개인이나 기업으로부터 단기 또는 장기의 자금을 보관하고 위탁합니다.',
            pay: '200',
            recruit_total_count: '4',
            apply_count: '5',
            requirement: '수학 1급 자격증, 책임 우수상',
            employees: ['김하늘', '이예은'],
            status: '0',
        },
        {
            name: '은행원',
            desc: '은행원은 고객이 맡긴...',
            pay: '200',
            recruit_total_count: '4',
            apply_count: '5',
            requirement: '수학 1급 자격증, 책임 우수상',
            employees: ['김하늘', '이예은'],
        },
        {
            name: '은행원',
            desc: '은행원은 고객이 맡긴 돈을 예치하고 고객의 대출을 상담하는 역할을 합니다.  그리고 개인이나 기업으로부터 단기 또는 장기의 자금을 보관하고 위탁합니다.',
            pay: '200',
            recruit_total_count: '4',
            apply_count: '5',
            requirement: '수학 1급 자격증, 책임 우수상',
            employees: ['김하늘', '이예은'],
            status: '0',
        },
        {
            name: '은행원',
            desc: '은행원은 고객이 맡긴...',
            pay: '200',
            recruit_total_count: '4',
            apply_count: '5',
            requirement: '수학 1급 자격증, 책임 우수상',
            employees: ['김하늘', '이예은'],
        },
    ];
    const handleAddClick = () => {
        Swal.fire({
            title: '직업 추가하기',
            html: `
            <hr>
            <div>직업명: <input id="jobName" type="text" style="border-radius: 10px; height: 30px;"></div>
            <br>
            <div>직업 설명: <input id="jobDesc" type="text" style="border-radius: 10px; height: 30px;"></div>
            <br>
            <div>주급: <input id="jobPay" type="number" style="border-radius: 10px; height: 30px;"></div>
            <br>
            <div>모집인원: <input id="jobRecruitCount" type="number" style="border-radius: 10px; height: 30px;"></div>
            <br>
            <div>자격요건: <input id="jobRequirement" type="text" style="border-radius: 10px; height: 30px;"></div>
            <hr>
            <style>
            input {
                border: 1px solid #d8d8d8;
                text-align: center;
                font-size: 20px;
                width: 100px;
            }
            input[type="number"] {
                background-image: url('data:image/svg+xml;utf8,%3Csvg%20version%3D%221.1%22%20viewBox%3D%220%200%2050%2067%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%3Cg%20fill%3D%22none%22%20stroke-width%3D%222%22%3E%3Cline%20x1%3D%221%22%20x2%3D%2250%22%20y1%3D%2233.5%22%20y2%3D%2233.5%22%20stroke%3D%22%23D8D8D8%22%2F%3E%3Cpolyline%20transform%3D%22translate(25%2020)%20rotate(45)%20translate(-25%20-20)%22%20points%3D%2219%2026%2019%2014%2032%2014%22%20stroke%3D%22%23000%22%2F%3E%3Cpolyline%20transform%3D%22translate(25%2045)%20rotate(225)%20translate(-25%20-45)%22%20points%3D%2219%2052%2019%2039%2032%2039%22%20stroke%3D%22%23000%22%2F%3E%3C%2Fg%3E%3C%2Fsvg%3E');
                background-position: center right;
                background-size: contain;
                background-repeat: no-repeat;
                caret-color: transparent;
            }              
            input[type="number"]::-webkit-inner-spin-button {
                -webkit-appearance: none !important;
                opacity: 1 !important;
                background: transparent !important;
                border-width: 0px;
                margin: 0;
                border-left: 1px solid #d8d8d8;
                height: 34px;
                width: 23px;
                cursor: pointer;
              }
            input[type="text"]:focus,
            input[type="number"]:focus {
                caret-color: initial; /* 포커스 시 커서의 기본 색상 사용 */
            }
            </style>
            `,
            showCancelButton: true,
            confirmButtonText: '확인',
            cancelButtonText: '취소',
            preConfirm: () => {
                const jobName = document.getElementById('jobName').value;
                const jobDesc = document.getElementById('jobDesc').value;
                const jobPay = document.getElementById('jobPay').value;
                const jobRecruitCount =
                    document.getElementById('jobRecruitCount').value;
                const jobRequirement =
                    document.getElementById('jobRequirement').value;

                // 주급 필드가 자연수인지 확인
                if (!Number.isInteger(Number(jobPay)) || Number(jobPay) <= 0) {
                    Swal.showValidationMessage('주급은 자연수여야 합니다.');
                    return false;
                }
                // 모집인원 필드가 자연수인지 확인
                if (
                    !Number.isInteger(Number(jobRecruitCount)) ||
                    Number(jobRecruitCount) <= 0
                ) {
                    Swal.showValidationMessage('모집인원은 자연수여야 합니다.');
                    return false;
                }

                // 여기서 API 호출을 수행하고, 성공 또는 실패 여부에 따라 Swal 띄우기
                // 성공 시
                try {
                    // API 호출 및 데이터 저장

                    Swal.fire({
                        icon: 'success',
                        title: '등록 완료',
                        confirmButtonText: '확인',
                    });
                } catch {
                    // 실패 시
                    Swal.fire({
                        icon: 'error',
                        title: '등록 실패',
                        confirmButtonText: '확인',
                    });
                }
            },
        });
    };
    return (
        <div>
            <NavBar username="여우" totalBalance="30000" />
            <div className={styles.container}>
                <div className={styles.title}>
                    <ProductionTitle title="채용 공고" size={25} />
                </div>
                <div className={styles.addButton}>
                    {identity === 'TC' && (
                        <ProductionButton2
                            title="직업 추가하기"
                            onClick={handleAddClick}
                        />
                    )}
                </div>
            </div>
            {/* Conditional rendering based on the identity state */}
            {identity === 'ST' ? (
                <ProductionStudent jobList={jobList} />
            ) : (
                <ProductionTeacher
                    jobList={jobList}
                    isModalOpen={isModalOpen}
                    setIsModalOpen={setIsModalOpen}
                />
            )}
        </div>
    );
};

export default JobPosting;
