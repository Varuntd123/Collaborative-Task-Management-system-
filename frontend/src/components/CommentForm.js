import React, { useState } from 'react';

function CommentForm({ taskId, onCommentAdded }) {
  const [content, setContent] = useState('');
  const [error, setError] = useState(null);
  const [success, setSuccess] = useState(null);

  const handleSubmit = async e => {
    e.preventDefault();
    setError(null);
    setSuccess(null);
    if (!content.trim()) return setError('Comment cannot be empty');
    try {
      const res = await fetch(`/api/comments/task/${taskId}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ content })
      });
      if (!res.ok) throw new Error(await res.text());
      setContent('');
      setSuccess('Comment added!');
      if (onCommentAdded) onCommentAdded();
    } catch (e) {
      setError(e.message);
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{marginTop:8}}>
      <input value={content} onChange={e=>setContent(e.target.value)} placeholder="Add a comment..." style={{width:'80%',padding:8}} />
      <button type="submit" style={{padding:'8px 16px',marginLeft:8,background:'#1976d2',color:'#fff',border:'none',borderRadius:4}}>Add</button>
      {error && <div style={{color:'red'}}>{error}</div>}
      {success && <div style={{color:'green'}}>{success}</div>}
    </form>
  );
}

export default CommentForm;
