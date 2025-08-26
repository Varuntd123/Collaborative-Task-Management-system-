import React, { useEffect, useState } from 'react';

function MemberTasksTable({ userId }) {
  const [tasks, setTasks] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (!userId) return;
    fetch(`/api/tasks/assignee/${userId}`)
      .then(res => res.json())
      .then(setTasks)
      .catch(e => setError('Failed to load tasks'));
  }, [userId]);

  return (
    <div>
      <h2>My Tasks</h2>
      {error && <div style={{color:'red'}}>{error}</div>}
      <table style={{width:'100%',background:'#fff',borderRadius:8,boxShadow:'0 2px 8px #eee'}}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Status</th>
            <th>Due Date</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map(task => (
            <tr key={task.id}>
              <td>{task.id}</td>
              <td>{task.title}</td>
              <td>{task.status}</td>
              <td>{task.dueDate ? new Date(task.dueDate).toLocaleDateString() : '-'}</td>
              <td>
                {/* Status update and comment actions will go here */}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MemberTasksTable;
