import React, { useRef, useEffect, useState } from 'react';
import { createChart, PriceScaleMode } from 'lightweight-charts';

function BankChartRow({ data }) {
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
        if (chartContainerRef.current && data) {
            chartRef.current = createChart(chartContainerRef.current, {
                width: chartWidth,
                height: 200,
            });

            const lineSeries = chartRef.current.addLineSeries();
            lineSeries.setData(data);

            // 가로축
            const timeScale = chartRef.current.timeScale();
            timeScale.setVisibleRange({
                from: data[0].time,
                to: data[data.length - 1].time,
            });
            timeScale.fitContent();

            // 세로축
            chartRef.current.applyOptions({
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

export default BankChartRow;
