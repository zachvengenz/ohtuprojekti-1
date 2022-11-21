import React, { useEffect, useState } from "react";

export function ApparelTable() {
    const [apparels, setApparels] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/apparels")
      .then((response) => response.json())
      .then((data) => {
        setApparels(data);
      });
  }, []);

  return (
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
  )
}