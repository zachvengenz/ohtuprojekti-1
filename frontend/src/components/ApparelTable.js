import React, { useState, useEffect } from "react";
import { AgGridReact } from "ag-grid-react";

import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-material.css";
import { Button } from "@mui/material";

export default function ApparelTable() {
  const [apparels, setApparels] = useState([]);

  const [columnDefs] = useState([
    { field: "name", sortable: true, filter: true },
    { field: "type", sortable: true, filter: true },
    { field: "price", sortable: true, filter: true },
    { field: "maker.name", sortable: true, filter: true },
  ]);

  useEffect(() => {
    getApparels();
  }, []);

  const getApparels = () => {
    fetch("http://localhost:8080/apparels")
      .then((response) => response.json())
      .then((data) => {
        setApparels(data);
      });
  };

  console.log(apparels);
  return (
    <div
      className="ag-theme-material"
      style={{ width: "90%", height: 600, margin: "auto" }}
    >
      <AgGridReact
        rowData={apparels}
        columnDefs={columnDefs}
        pagination={true}
        paginationPageSize={10}
      ></AgGridReact>
    </div>
  );
}
