import "./BaseComponent.css";
import React from "react";

function BaseComponent(props) {
  return (
    <>
      <div className="BaseComponent container-fluid p-0 m-0">
        {props.children}
      </div>
    </>
  );
}

export default BaseComponent;