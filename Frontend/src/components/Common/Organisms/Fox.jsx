import React from 'react';
import './Fox.css';
import foxlogo from '../../../assets/images/fox-logo.png';

function Fox({ comments }) {
    return (
        <div className="fox-box">
            <div className="fox-title">
                <div className="logo-container">
                    <img src={foxlogo} alt="로고" className="logo" />
                    <p>경제여우쌤의 꿀팁</p>
                </div>
                <div className="fox-text">
                    <p>{comments}</p>
                </div>
            </div>
        </div>
    );
}

export default Fox;
