import React, { useEffect, useState } from 'react';

function TeamsTable() {
  const [teams, setTeams] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch('/api/teams')
      .then(res => res.json())
      .then(setTeams)
      .catch(e => setError('Failed to load teams'));
  }, []);

  return (
    <div>
      <h2>Teams</h2>
      {error && <div style={{color:'red'}}>{error}</div>}
      <table style={{width:'100%',background:'#fff',borderRadius:8,boxShadow:'0 2px 8px #eee'}}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Members</th>
          </tr>
        </thead>
        <tbody>
          {teams.map(team => (
            <tr key={team.id}>
              <td>{team.id}</td>
              <td>{team.name}</td>
              <td>{team.members ? team.members.length : 0}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TeamsTable;
