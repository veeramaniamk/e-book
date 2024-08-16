import React, { useState } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route,Navigate } from "react-router-dom";
import Usernavbar from './user/Usernavbar';
import Adminnavbar from './admin/Adminnavbar';
import Publishernavnar from './publisher/Publishernavbar';
import Login from './components/login';
import Register from './components/Register';
import Publisherhome from './publisher/publisherhome.jsx';
import Publishebook from './publisher/publishebook.jsx';
import Profile from './components/Profile';
import Adminhome from './admin/adminhome';
import Adminpublishedauthor from './admin/adminpublishedauthor';
import Adminpurchased from './admin/adminpurchased';
import Adminrevived from './admin/adminrevived';
import Adminpublisherbook from './admin/adminpublisherbook';
import Userhome from './user/userhome';
import Userviewbook from './user/userbookview';


function App() {
  const [userRole, setUserRole] = useState(null); // 'admin', 'publisher', 'user', or null if not logged in

  const handleLogin = (role) => {
    setUserRole(role); // Set the user role upon login
  };

  const handleLogout = () => {
    setUserRole(null); // Clear the user role upon logout
  };

  return (
    <Router>
      {/* Conditionally render the navbar based on the user's role */}
      {userRole === 'admin' && <Adminnavbar onLogout={handleLogout} />}
      {userRole === 'publisher' && <Publishernavnar onLogout={handleLogout} />}
      {userRole === 'user' && <Usernavbar onLogout={handleLogout} />}

      <Routes>
        <Route path="/login" element={<Login onLogin={handleLogin} />} />
        <Route path="/register" element={<Register />} />
        <Route path="/profile" element={<Profile />} />

        {/* Admin Routes */}
        {userRole === 'admin' && (
          <>
            <Route path="/adminhome" element={<Adminhome />} />
            <Route path="/adminpublished" element={<Adminpublishedauthor />} />
            <Route path="/adminpurchased" element={<Adminpurchased />} />
            <Route path="/adminrevived" element={<Adminrevived />} />
            <Route path="/adminpublisherbook" element={<Adminpublisherbook />} />
          </>
        )}

        {/* Publisher Routes */}
        {userRole === 'publisher' && (
          <>
            <Route path="/publisherhome" element={<Publisherhome />} />
            <Route path="/publishebook" element={<Publishebook />} />
          </>
        )}

        {/* User Routes */}
        {userRole === 'user' && (
          <>
            <Route path="/userhome" element={<Userhome />} />
            <Route path="/userviewbook" element={<Userviewbook />} />
          </>
        )}

        {/* Redirect to login if no user is logged in */}
        <Route path="*" element={<Navigate to="/login" />} />
      </Routes>
    </Router>
  );
}

export default App;
