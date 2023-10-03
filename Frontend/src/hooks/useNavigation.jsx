import { useNavigate } from 'react-router-dom';

export const useNavigation = () => {
    const navigate = useNavigate();

    // Admin
    const navigateToFoundation = () => {
        navigate('/admin/foundation');
    };

    const navigateToOffice = () => {
        navigate('/admin/office');
    };

    const navigateToOfficeFix = () => {
        navigate('/admin/officefix');
    };

    // Bank
    const navigateToBankPage = () => {
        navigate('/bank/bankpage');
    };

    // Home
    const navigateToDashboard = () => {
        navigate('/home/dashboard');
    };

    const navigateToLanding = () => {
        navigate('/');
    };

    // Market
    const navigateToMarketPage = () => {
        navigate('/market/marketpage');
    };

    // Member
    const navigateToLogin = () => {
        navigate('/member/login');
    };

    const navigateToNationality = () => {
        navigate('/member/nationality');
    };

    const navigateToSignup = () => {
        navigate('/member/signup');
    };

    // Production
    const navigateToJobPosting = () => {
        navigate('/production/jobposting');
    };

    // StockExchange
    const navigateToStock = () => {
        navigate('/stockexchange/stock');
    };

    return {
        navigateToFoundation,
        navigateToOffice,
        navigateToOfficeFix,
        navigateToBankPage,
        navigateToDashboard,
        navigateToLanding,
        navigateToMarketPage,
        navigateToLogin,
        navigateToNationality,
        navigateToSignup,
        navigateToJobPosting,
        navigateToStock,
    };
};

export default useNavigation;
