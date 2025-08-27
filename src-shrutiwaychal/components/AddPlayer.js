import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function AddPlayer() {
  const navigate = useNavigate();
  const [player, setPlayer] = useState({
    name: "",
    jerseyNumber: "",
    role: "",
    totalMatches: "",
    teamName: "",
    stateName: "",
    description: "",
  });

  const roles = ["Batsman", "Bowler", "Keeper", "All Rounder"];

  const handleChange = (e) => {
    const { name, value } = e.target;
    setPlayer({ ...player, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8080/api/players/add", player);
      navigate("/");
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="d-flex justify-content-center mt-5">
      <div style={{ width: "450px" }}>
        <div className="card shadow p-4">
          <h3 className="text-center mb-4" style={{ color: "#0d6efd" }}>
            Add New Player
          </h3>
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <input
                type="text"
                name="name"
                value={player.name}
                placeholder="Player Name"
                onChange={handleChange}
                className="form-control"
                required
              />
            </div>

            <div className="mb-3">
              <input
                type="number"
                name="jerseyNumber"
                value={player.jerseyNumber}
                placeholder="Jersey Number"
                onChange={handleChange}
                className="form-control"
                required
              />
            </div>

            <div className="mb-3">
              <select
                name="role"
                value={player.role}
                onChange={handleChange}
                className="form-control"
                required
              >
                <option value="">Select Role</option>
                {roles.map((r) => (
                  <option key={r} value={r}>
                    {r}
                  </option>
                ))}
              </select>
            </div>

            <div className="mb-3">
              <input
                type="number"
                name="totalMatches"
                value={player.totalMatches}
                placeholder="Total Matches"
                onChange={handleChange}
                className="form-control"
                required
              />
            </div>

            <div className="mb-3">
              <input
                type="text"
                name="teamName"
                value={player.teamName}
                placeholder="Team Name"
                onChange={handleChange}
                className="form-control"
                required
              />
            </div>

            <div className="mb-3">
              <input
                type="text"
                name="state"
                value={player.state}
                placeholder="State Name"
                onChange={handleChange}
                className="form-control"
                required
              />
            </div>

            <div className="mb-3">
              <textarea
                name="description"
                value={player.description}
                placeholder="Description"
                onChange={handleChange}
                className="form-control"
                rows="3"
              />
            </div>

            <button
              type="submit"
              className="btn btn-primary w-100"
              style={{ fontWeight: "bold" }}
            >
              Add Player
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
