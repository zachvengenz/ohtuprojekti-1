import './App.css';
import React, {useEffect, useState} from 'react';

function App() {

  const [apparels, setApparels] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/apparels")
    .then(response => response.json())
    .then(data => {
      setApparels(data)
    });
  },[])
  console.log(apparels)

  return (
    <div className="App">
      <header className="App-header">
        <h1>Omppu Ja Rane</h1>
      </header>
     


    </div>
  );
}

export default App;
