import React, { useEffect, useState } from 'react';
import useHomeApi from '../../../api/useHomeApi';
import NationTitle from '../Atoms/NationTitle';

const Nation = () => {
    const [response, setResponse] = useState({});
    const { nationName, flag } = response;

    const nationStyle = {
        display: 'flex',
        justifyContent: 'center',
        flexDirection: 'column',
        alignItems: 'center',
    };
    const imgStyle = {
        width: '100%',
        height: 'auto',
        objectFit: 'cover',
        boxShadow: '0px 4px 10px rgba(0, 0, 0, 0.8)',
        borderRadius: '25px',
    };

    const getInfoApi = async () => {
        const response = await useHomeApi.homeGetInfo();
        if (response.code === 200) {
            setResponse(response.data);
        }
    };

    useEffect(() => {
        getInfoApi();
    }, []);

    return (
        <div style={nationStyle}>
            <NationTitle title={nationName} />
            <img style={imgStyle} src={flag} alt="flag" />
        </div>
    );
};

export default Nation;
