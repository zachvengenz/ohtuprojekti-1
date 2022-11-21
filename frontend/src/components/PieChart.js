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
    const res = await axios.get("https://covid-api.mmediagroup.fr/v1/cases");

    this.setState({ data: res.data.Finland.All, loading: false });

    console.log(this.state);
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
            ["Confirmed", this.state.data.confirmed],
            ["Deaths", this.state.data.deaths],
            ["population", this.state.data.population],
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
