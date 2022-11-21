import React, { useEffect, useState } from "react";

export function ApparelTable() {
    const [makers, setMakers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/makers")
      .then((response) => response.json())
      .then((data) => {
        setMakers(data);
      });
  }, []);

  return (
    <table>
        <tbody>
          <tr>
            <th>Name</th>
          </tr>
          {makers.map((makers) => (
            <tr key={makers.id}>
              <td>{makers.name}</td>
            </tr>
          ))}
        </tbody>
      </table>
  )
}