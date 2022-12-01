import React, { useEffect, useState } from "react";
import { AgGridReact } from "ag-grid-react";

import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-material.css";

export default function ApparelTable() {
  const [makers, setMakers] = useState([]);

  const [columnDefs] = useState([
    { field: "name", sortable: true, filter: true }
    
  ]);

  useEffect(() => {
    getMakers();
  }, []);


  const getMakers = () => {
    fetch("http://localhost:8080/makers")
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        setMakers(data);
      });
  };
/*
  useEffect(() => {
    fetch("http://localhost:8080/makers")
      .then((response) => response.json())
      .then((data) => {
        setMakers(data);
      });
  }, []); */
/*
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
    {/* </table>  } */

  return (
    <>
      <div
        className="ag-theme-material"
        style={{ width: "90%", height: 600, margin: "auto" }}
      >
        <AgGridReact
          rowData={makers}
          columnDefs={columnDefs}
          pagination={true}
          paginationPageSize={10}
        ></AgGridReact>
      </div>
    </>
  );
}
