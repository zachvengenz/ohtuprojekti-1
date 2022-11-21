import "./App.css";
import React from "react";
import PieChart from "./components/PieChart";
import { ApparelTable } from "./components/ApparelTable";

function App() {
  
  return (
    <div className="App">
      <header className="App-header">
        <h1>Omppu Ja Rane</h1>
      </header>
      <ApparelTable></ApparelTable>
      <PieChart></PieChart>
    </div>
  );
}

export default App;
