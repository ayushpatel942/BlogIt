// import React from "react";
// import axios from "axios";

// export const BASEURL = "http://localhost:8080";

// export const myaxios = axios.create({ baseURL: BASEURL });

import axios from "axios";

export const BASEURL = "http://localhost:8080";
export const myaxios = axios.create({ baseURL: BASEURL });
export const POST_IMAGE_SERVE_URL=BASEURL+"/api/images/servepostimage";
export const DEFAULT_POST_IMAGE_NAME="defaultpostimage.jpg";

export const CustomDateFormatterFunc = (date) => {
    const d = new Date(date);
    return `${d.getDate()}-${
      d.getMonth() + 1
    }-${d.getFullYear()} ${d.getHours()}:${d.getMinutes()}`;
};

export function CustomTextColorWrapper(props) {
  return <span style={{color:"#bb2d3b"}}>{props.children}</span>;
}

export const getLoggedInUserDetails = () => {
  if (isLoggedIn()) {
    let result = JSON.parse(localStorage.getItem("loggedinuser"));
    return result;
  } else return null;
};

export const isLoggedIn = () => {
  if (localStorage.getItem("loggedinuser")) return true;
  else return false;
};