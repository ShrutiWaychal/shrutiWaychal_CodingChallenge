import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import PlayerList from "./components/PlayerList";
import AddPlayer from "./components/AddPlayer";
import UpdatePlayer from "./components/UpdatePlayer";
import "bootstrap/dist/css/bootstrap.min.css";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
      <div className="container">
        <a className="navbar-brand fw-bold" href="/">
          Player App
        </a>
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <a className="nav-link" href="/">
                Players
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="/add">
                Add New Player
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}
export default function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<PlayerList />} />
        <Route path="/add" element={<AddPlayer />} />
        <Route path="/update/:id" element={<UpdatePlayer />} />
      </Routes>
    </Router>
  );
}


