import React from 'react';
import { Routes, Route } from 'react-router-dom';

// Admin
import Foundation from './components/Admin/Pages/Foundation.jsx';
import Office from './components/Admin/Pages/Office.jsx';
import OfficeFix from './components/Admin/Pages/OfficeFix.jsx';

// Bank
import BankPage from './components/Bank/Pages/BankPage.jsx';

// Home
import Dashboard from './components/Home/Pages/Dashboard.jsx';
import Landing from './components/Home/Pages/Landing.jsx';

// Market
import MarketPage from './components/Market/Pages/MarketPage.jsx';

// Member
import Login from './components/Member/Pages/Login.jsx';
import Nationality from './components/Member/Pages/Nationality.jsx';
import Signup from './components/Member/Pages/Signup.jsx';

// Production
import JobPosting from './components/Production/Pages/JobPosting.jsx';

// StockExchange
import Stock from './components/StockExchange/Pages/Stock.jsx';

const App = () => {
    return (
        <div className="App">
            <Routes>
                <Route path="/" element={<Landing />} />
                <Route path="/admin/foundation" element={<Foundation />} />
                <Route path="/admin/office" element={<Office />} />
                <Route path="/admin/officefix" element={<OfficeFix />} />
                <Route path="/bank/bankpage" element={<BankPage />} />
                <Route path="/home/dashboard" element={<Dashboard />} />
                <Route path="/market/marketpage" element={<MarketPage />} />
                <Route path="/member/login" element={<Login />} />
                <Route path="/member/nationality" element={<Nationality />} />
                <Route path="/member/signup" element={<Signup />} />
                <Route path="/production/jobposting" element={<JobPosting />} />
                <Route path="/stockexchange/stock" element={<Stock />} />
            </Routes>
        </div>
    );
};

export default App;
