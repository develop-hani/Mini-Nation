import React from 'react';
import './TickerTape.css';

const TickerTape = () => {
    return (
        <div>
            <div class="ticker-tape">
                <div class="ticker">
                    <div class="ticker__item">
                        SAMSUNG 삼성전자
                        <span className="ticker__price">345345</span>
                        <span className="ticker__changesratio">+54%</span>
                    </div>
                    <div class="ticker__item">
                        HYUNDAI 현대자동차
                        <span className="ticker__price">345345</span>
                        <span className="ticker__changesratio">+54%</span>
                    </div>
                    <div class="ticker__item">
                        NEXON 넥슨
                        <span className="ticker__price">345345</span>
                        <span className="ticker__changesratio">+54%</span>
                    </div>
                    <div class="ticker__item">
                        HYBE 하이브
                        <span className="ticker__price">345345</span>
                        <span className="ticker__changesratio">+54%</span>
                    </div>
                    <div class="ticker__item">
                        KAKAO 카카오
                        <span className="ticker__price">345345</span>
                        <span className="ticker__changesratio">+54%</span>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default TickerTape;
