import React, { useEffect, useState } from 'react';

function TasksTable({ teamId }) {
  const [tasks, setTasks] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (!teamId) return;
    fetch(`/api/tasks/team/${teamId}`)
      .then(res => res.json())
      .then(setTasks)
      .catch(e => setError('Failed to load tasks'));
  }, [teamId]);

  return (
    <div>
      <h2>Team Tasks</h2>
      {error && <div style={{color:'red'}}>{error}</div>}
      <table style={{width:'100%',background:'#fff',borderRadius:8,boxShadow:'0 2px 8px #eee'}}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Assignee</th>
            <th>Status</th>
            <th>Due Date</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map(task => (
            <tr key={task.id}>
              <td>{task.id}</td>
              <td>{task.title}</td>
              <td>{task.assignee ? task.assignee.username : '-'}</td>
              <td>{task.status}</td>
              <td>{task.dueDate ? new Date(task.dueDate).toLocaleDateString() : '-'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TasksTable;
