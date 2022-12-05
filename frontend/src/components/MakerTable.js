import React, { useEffect, useState } from "react";
import { AgGridReact } from "ag-grid-react";
import { Button } from "@mui/material";

import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-material.css";

import AddMaker from "./AddMaker";

export default function MakerTable() {
  const [makers, setMakers] = useState([]);

  const [columnDefs] = useState([
    { field: "name", sortable: true, filter: true },
    { field: "id",
      headerName: '',
      cellRenderer: (params) => (
        <Button
          color="error"
          variant="contained"
          onClick={() => deleteMaker(params.value)}
        >
          
          Delete
        </Button>
      ),
    },
    
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

  const addMaker = (maker) => {
    fetch("http://localhost:8080/makers", {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify(maker),
    })
      .then((response) => {
        if (response.ok) {
          getMakers();
        } else {
          alert("Something went wrong!");
        }
      })
      .catch((err) => console.log(err));
  };

  const deleteMaker = (id) => {
    if (window.confirm("do you want to delete?")) {
      fetch("http://localhost:8080/makers/" + id, {
        method: "DELETE",
      })
        .then((response) => {
          if (response.ok) {
            getMakers();
          } else {
            alert("something went wong!");
          }
        })
        .catch((err) => console.log(err));
    }
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
    <AddMaker addMaker={addMaker} />
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
