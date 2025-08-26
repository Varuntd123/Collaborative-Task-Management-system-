import React, { useState } from 'react';

function TaskForm({ teamId, onTaskCreated }) {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [dueDate, setDueDate] = useState('');
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  const handleSubmit = async e => {
    e.preventDefault();
    setError(null);
    setSuccess(null);
    if (!title) return setError('Title is required');
    try {
      const res = await fetch('/api/tasks', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, description, dueDate, team: { id: teamId } })
      });
      if (!res.ok) throw new Error(await res.text());
      setTitle(''); setDescription(''); setDueDate('');
      setSuccess('Task created!');
      if (onTaskCreated) onTaskCreated();
    } catch (e) {
      setError(e.message);
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{marginBottom:24,background:'#fff',padding:16,borderRadius:8}}>
      <h3>Create Task</h3>
      {error && <div style={{color:'red'}}>{error}</div>}
      {success && <div style={{color:'green'}}>{success}</div>}
      <div style={{marginBottom:8}}>
        <input value={title} onChange={e=>setTitle(e.target.value)} placeholder="Title" style={{width:'100%',padding:8}} />
      </div>
      <div style={{marginBottom:8}}>
        <textarea value={description} onChange={e=>setDescription(e.target.value)} placeholder="Description" style={{width:'100%',padding:8}} />
      </div>
      <div style={{marginBottom:8}}>
        <input type="date" value={dueDate} onChange={e=>setDueDate(e.target.value)} style={{width:'100%',padding:8}} />
      </div>
      <button type="submit" style={{padding:'8px 24px',background:'#1976d2',color:'#fff',border:'none',borderRadius:4}}>Create Task</button>
    </form>
  );
}

export default TaskForm;
