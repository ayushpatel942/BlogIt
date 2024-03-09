import "./BaseComponent.css";
import React from "react";
import MyNavbar from "./MyNavbar";

function BaseComponent(props) {
  return (
    <>
      <div className="BaseComponent container-fluid p-0 m-0">
        <MyNavbar/>
        {props.children}
      </div>
    </>
  );
}

export default BaseComponent;