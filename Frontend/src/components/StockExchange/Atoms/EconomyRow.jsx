/* eslint-disable import/no-extraneous-dependencies */
import React, { useRef, useEffect, useState } from 'react';
import { createChart, PriceScaleMode } from 'lightweight-charts';

function EconomyRow({ data }) {
    const chartContainerRef = useRef();
    const chartRef = useRef(null);
    const [chartWidth, setChartWidth] = useState(0);

    useEffect(() => {
        const handleResize = () => {
            if (chartContainerRef.current) {
                const width = chartContainerRef.current.offsetWidth;
                if (width !== chartWidth) {
                    setChartWidth(width);
                }
            }
        };

        window.addEventListener('resize', handleResize);

        return () => {
            window.removeEventListener('resize', handleResize);
        };
    }, [chartWidth]);

    useEffect(() => {
        if (chartContainerRef.current && data && !chartRef.current) {
            chartRef.current = createChart(chartContainerRef.current, {
                width: chartWidth,
                height: 300,
            });

            const lineSeries = chartRef.current.addLineSeries();
            lineSeries.setData(data);

            // Configure the time scale
            const timeScale = chartRef.current.timeScale();
            timeScale.setVisibleRange({
                from: data[0].time,
                to: data[data.length - 1].time,
            });
            timeScale.fitContent();

            // Configure price scale
            chartRef.current.applyOptions({
                layout: {
                    backgroundColor: '#262E3A',
                    textColor: '#191919',
                },
                rightPriceScale: {
                    scaleMargins: {
                        top: 0.3,
                        bottom: 0.25,
                    },
                    mode: PriceScaleMode.Logarithmic,
                },
            });
        }

        return () => {
            if (chartRef.current) {
                chartRef.current.remove();
                chartRef.current = null;
            }
        };
    }, [chartWidth, data]);

    return <div ref={chartContainerRef} />;
}

export default EconomyRow;
