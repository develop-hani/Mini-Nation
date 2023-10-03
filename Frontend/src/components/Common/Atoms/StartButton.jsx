import React from 'react';
import './StartButton.css';

function StartButton({ title, onClick }) {
    return (
        <div>
            <button type="button" className="start-button" onClick={onClick}>
                <span>{title}</span>
            </button>
        </div>
    );
}

export default StartButton;
