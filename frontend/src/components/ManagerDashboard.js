import React from 'react';

import React, { useState } from 'react';
import TaskForm from './TaskForm';
import TasksTable from './TasksTable';

function ManagerDashboard() {
  // For demo, allow teamId selection
  const [teamId, setTeamId] = useState('');
  const [refresh, setRefresh] = useState(false);

  return (
    <div style={{maxWidth:900,margin:'40px auto'}}>
      <h1>Manager Dashboard</h1>
      <div style={{marginBottom:16}}>
        <input value={teamId} onChange={e=>setTeamId(e.target.value)} placeholder="Enter Team ID" style={{padding:8}} />
      </div>
      {teamId && <TaskForm teamId={teamId} onTaskCreated={()=>setRefresh(r=>!r)} />}
      {teamId && <TasksTable teamId={teamId} key={refresh} />}
    </div>
  );
}

export default ManagerDashboard;
