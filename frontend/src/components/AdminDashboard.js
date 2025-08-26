import React from 'react';

import UsersTable from './UsersTable';
import TeamsTable from './TeamsTable';

function AdminDashboard() {
  return (
    <div style={{maxWidth:900,margin:'40px auto'}}>
      <h1>Admin Dashboard</h1>
      <UsersTable />
      <div style={{margin:'32px 0'}}></div>
      <TeamsTable />
    </div>
  );
}

export default AdminDashboard;
