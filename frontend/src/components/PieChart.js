import React, { useState, useEffect } from "react";
import Chart from "react-google-charts";

export default function PieChart() {
  const [chart, setChart] = useState([]);

  const getChart = () => {
    fetch("http://localhost:8080/apparels")
      .then((response) => response.json())
      .then((data) => {
        setChart(data);
      });
  };

  useEffect(() => {
    getChart();
  }, []);

  const mapped = chart.map((d) => [d.name, d.price]);
  const data = [["Task", "Hours per Day"], ...mapped];

  console.log(data);

  return (
    <div>
      <Chart
        width={"500px"}
        height={"300px"}
        chartType="PieChart"
        loader={<div>Loading Chart</div>}
        data={data}
        options={{
          title: "Data in Percentage",
        }}
      />

      <ul>
        {chart.map((data, index) => {
          return <li key={index}>price: {data.price}</li>;
        })}
      </ul>
    </div>
  );
}
