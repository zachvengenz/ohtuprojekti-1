import React, { useState } from "react";
import AppBar from "@mui/material/AppBar";
import { Tab, Tabs, Typography } from "@mui/material";
import ApparelTable from "./ApparelTable";
import PieChart from "./PieChart";
import MakerTable from "./MakerTable";

function TabBar() {
  const [tabIndex, setTabIndex] = useState(0);

  const handleTabChange = (event, newTabIndex) => {
    setTabIndex(newTabIndex);
  };
  return (
    <div>
      <AppBar position="static">
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          Omppu ja Rane
        </Typography>
        <Tabs
          textColor="secondary"
          indicatorColor="secondary"
          value={tabIndex}
          onChange={handleTabChange}
          centered
        >
          <Tab label="Apparel" />
          <Tab label="Maker" />
          <Tab label="PieChart" />
        </Tabs>
      </AppBar>
      {tabIndex === 0 && <ApparelTable></ApparelTable>}
      {tabIndex === 1 && <MakerTable></MakerTable>}
      {tabIndex === 2 && <PieChart></PieChart>}
    </div>
  );
}

export default TabBar;
