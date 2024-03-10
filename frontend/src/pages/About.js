import React from "react";
import { Link } from "react-router-dom";
import { Card } from "reactstrap";
import BaseComponent from "../components/BaseComponent";
function About() {
  return (
    <BaseComponent>
      <div className="About" style={{ minHeight: "500px" }}>
        <Card
          className="p-3 m-3"
          style={{ backgroundColor: "rgb(255,255,255,0.9)" }}
        >
          <h3
            style={{
              textAlign: "center",
              color: "#BB2D3B",
              fontStyle: "italic",
            }}
          >
            Who Are We ?
          </h3>
          <div className="container text-center" >
            <p style={{textAlign:"justify"}}>
              A blog, short for weblog, is a frequently updated web page used
              for personal commentary or business content. Blogs are often
              interactive and include sections at the bottom of individual blog
              posts where readers can leave comments.
            </p>
            <Link to="/signup" className="btn btn-sm btn-danger mt-2 mb-4">
              SignUp Now
            </Link>
          </div>
        </Card>
      </div>
    </BaseComponent>
  );
}

export default About;