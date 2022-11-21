import "./App.css";
import React, { useEffect, useState } from "react";
import PieChart from "./components/PieChart";

function App() {
  const [apparels, setApparels] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/apparels")
      .then((response) => response.json())
      .then((data) => {
        setApparels(data);
      });
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Omppu Ja Rane</h1>
      </header>
      <table>
        <tbody>
          <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Price</th>
            <th>Maker</th>
          </tr>
          {apparels.map((apparels) => (
            <tr key={apparels.id}>
              <td>{apparels.name}</td>
              <td>{apparels.type}</td>
              <td>{apparels.price}</td>
              <td>{apparels.maker.name}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <PieChart></PieChart>
    </div>
  );
}

export default App;
