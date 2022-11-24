import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import ApparelTable from "./ApparelTable";
import MakerTable from "./MakerTable";
import PieChart from "./PieChart";

// code formatted with Prettier

function Router() {
  return (
    <div
      style={{
        width: "100%",
        background: "pink",
        textAlign: "center",
      }}
    >
      <h1
        style={{
          color: "whitesmoke",
          background: "black",
          textAlign: "center",
        }}
      >
        TERVE!
      </h1>
      <BrowserRouter>
        <Link to="/">Apparel Table</Link>{" "}
        <Link to="/makertable">Maker Table</Link>{" "}
        <Link to="/piechart">Pie Chart</Link>{" "}
        <Routes>
          <Route exact path="/" element={<ApparelTable />} />
          <Route path="/makertable" element={<MakerTable />} />
          <Route path="/piechart" element={<PieChart />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default Router;
