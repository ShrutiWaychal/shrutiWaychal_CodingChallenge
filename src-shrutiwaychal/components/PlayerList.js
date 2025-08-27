import React, { useEffect, useState } from "react";
import playerService from "../services/playerService";
import { Link } from "react-router-dom";

export default function PlayerList() {
  const [players, setPlayers] = useState([]);
  const [searchName, setSearchName] = useState("");

  const loadPlayers = async () => {
    try {
      const res = await playerService.getAllPlayers();
      setPlayers(res.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    loadPlayers();
  }, []);

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure to delete this player?")) {
      try {
        await playerService.deletePlayer(id);
        loadPlayers();
      } catch (error) {
        console.log(error);
      }
    }
  };

  const handleSearch = async () => {
    if (searchName.trim() === "") {
      loadPlayers();
      return;
    }
    try {
      const res = await playerService.getPlayersWithMoreMatches(searchName);
      setPlayers(res.data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="container mt-5">

      <div className="card shadow-sm p-4">
                  <h3 className="text-center mb-4" style={{ color: "#0d6efd" }}>
         All Players
          </h3>
        <div className="mb-4 text-center">
          <label className="form-label fw-bold mb-2">
            Find Players With More Matches Than:
          </label>
          <div className="d-flex justify-content-center mb-1">
            <input
              type="text"
              placeholder="Enter player name"
              className="form-control w-25 me-2"
              value={searchName}
              onChange={(e) => setSearchName(e.target.value)}
            />
            <button className="btn btn-primary me-2" onClick={handleSearch}>
              Search
            </button>
            <button className="btn btn-secondary" onClick={loadPlayers}>
              Reset
            </button>
          </div>
        </div>

        <div className="table-responsive">
          <table className="table table-hover table-bordered align-middle">
            <thead className="table-primary">
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Jersey</th>
                <th>Role</th>
                <th>Matches</th>
                <th>Team</th>
                <th>State</th>
                <th>Description</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {players.length === 0 ? (
                <tr>
                  <td colSpan="9" className="text-center">No players found</td>
                </tr>
              ) : (
                players.map((p) => (
                  <tr key={p.id}>
                    <td>{p.id}</td>
                    <td>{p.name}</td>
                    <td>{p.jerseyNumber}</td>
                    <td>
                      {p.role}
                    </td>
                    <td>{p.totalMatches}</td>
                    <td>{p.teamName}</td>
                    <td>{p.state}</td>
                    <td>{p.description}</td>
                    <td>
                      <Link
                        className="btn btn-sm btn-primary me-1"
                        to={`/update/${p.id}`}
                      >
                        Update
                      </Link>
                      <button
                        onClick={() => handleDelete(p.id)}
                        className="btn btn-sm btn-danger"
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}
