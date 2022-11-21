import React, { Component } from "react";
import Chart from "react-google-charts";
import axios from "axios";

class PieChart extends Component {
  state = {
    data: [],
    loading: false,
  };

  getAll = async () => {
    this.setState({ loading: true });
    const res = await axios.get("http://localhost:8080/apparels");

    this.setState({ data: res.data[0], loading: false });

    console.log();
  };

  async componentDidMount() {
    this.getAll();
  }

  render() {
    return (
      <div>
        <Chart
          width={"500px"}
          height={"300px"}
          chartType="PieChart"
          loader={<div>Loading Chart</div>}
          data={[
            ["", ""],
            ["Price", this.state.data.price],
            ["Price", this.state.data.price],
            ["Price", this.state.data.price],
          ]}
          options={{
            title: "Data in Percentage",
          }}
        />
      </div>
    );
  }
}

export default PieChart;
