
import React, { useState } from 'react';
import MemberTasksTable from './MemberTasksTable';

function MemberDashboard() {
  // For demo, allow userId selection
  const [userId, setUserId] = useState('');

  return (
    <div style={{maxWidth:900,margin:'40px auto'}}>
      <h1>Team Member Dashboard</h1>
      <div style={{marginBottom:16}}>
        <input value={userId} onChange={e=>setUserId(e.target.value)} placeholder="Enter Your User ID" style={{padding:8}} />
      </div>
      {userId && <MemberTasksTable userId={userId} />}
    </div>
  );
}

export default MemberDashboard;
