import useAxiosInstance from './useAxiosInstance.jsx';

const shopPostUse = async product => {
    try {
        const jwt = sessionStorage.getItem('accessToken');
        const response = await useAxiosInstance
            .authApiClient(jwt)
            .post(`/shop/use`, { product });
        return response.data;
    } catch (e) {
        if (e.response.data.status === 404) {
            console.log('404에러');
            return e.response.data;
        }
        if (e.response.data.status === 403) {
            console.log('403에러');
            return e.response.data;
        }
    }
    return null;
};

const shopPostBuy = async (product, amount) => {
    try {
        const jwt = sessionStorage.getItem('accessToken');
        const response = await useAxiosInstance
            .authApiClient(jwt)
            .post(`/shop/buy`, { product, amount });
        return response.data;
    } catch (e) {
        if (e.response.data.status === 404) {
            console.log('404에러');
            return e.response.data;
        }
        if (e.response.data.status === 403) {
            console.log('403에러');
            return e.response.data;
        }
    }
    return null;
};

const shopDeleteShop = async product => {
    try {
        const jwt = sessionStorage.getItem('accessToken');
        const response = await useAxiosInstance
            .authApiClient(jwt)
            .delete(`/shop`, { data: product });
        console.log('삭제 잘됨', response.data);
        return response.data;
    } catch (e) {
        if (e.response.data.status === 404) {
            console.log('404에러');
            return e.response.data;
        }
        if (e.response.data.status === 403) {
            console.log('403에러');
            return e.response.data;
        }
    }
    console.log('삭제 안됨');
    return null;
};

const shopPutShop = async (product, desc, price) => {
    try {
        const jwt = sessionStorage.getItem('accessToken');
        const response = await useAxiosInstance
            .authApiClient(jwt)
            .put(`/shop`, { product, desc, price });
        return response.data;
    } catch (e) {
        if (e.response.data.status === 404) {
            console.log('404에러');
            return e.response.data;
        }
        if (e.response.data.status === 403) {
            console.log('403에러');
            return e.response.data;
        }
    }
    return null;
};

const shopGetList = async () => {
    try {
        const jwt = sessionStorage.getItem('accessToken');
        const response = await useAxiosInstance.authApiClient(jwt).get(`/shop`);
        return response.data;
    } catch (e) {
        if (e.response.data.code === 404) {
            console.log('404에러 api에서');
            return e.response.data;
        }
        if (e.response.data.code === 403) {
            console.log('403에러 api에서');
            return e.response.data;
        }
    }
    return null;
};

const shopGetPurchase = async () => {
    try {
        const jwt = sessionStorage.getItem('accessToken');
        const response = await useAxiosInstance
            .authApiClient(jwt)
            .get(`/shop/my`);
        return response.data;
    } catch (e) {
        if (e.response.data.code === 404) {
            console.log('404에러 api에서');
            return e.response.data;
        }
        if (e.response.data.code === 403) {
            console.log('403에러 api에서');
            return e.response.data;
        }
    }
    return null;
};

export default {
    shopPostUse,
    shopPostBuy,
    shopDeleteShop,
    shopPutShop,
    shopGetList,
    shopGetPurchase,
};
