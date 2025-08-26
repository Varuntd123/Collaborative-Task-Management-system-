import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import AdminDashboard from './components/AdminDashboard';
import ManagerDashboard from './components/ManagerDashboard';
import MemberDashboard from './components/MemberDashboard';
import Login from './components/Login';
import './App.css';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/login" />} />
      <Route path="/login" element={<Login />} />
      <Route path="/admin/*" element={<AdminDashboard />} />
      <Route path="/manager/*" element={<ManagerDashboard />} />
      <Route path="/member/*" element={<MemberDashboard />} />
    </Routes>
  );
}

export default App;
