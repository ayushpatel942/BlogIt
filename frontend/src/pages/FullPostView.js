import React, { useState } from "react";
import { useParams } from "react-router-dom";
import {
  Card,
  CardBody,
  CardText,
  Container,
  FormGroup,
  Form,
  Input,
  Button,
} from "reactstrap";
import BaseComponent from "../components/BaseComponent";

import { toast } from "react-toastify";
import defaultpostimage from "../images/defaultpostimage.jpg"

function FullPostView() {
  const [comment, setComment] = useState({ comment: "" });

  function handleCommentChange(event) {
    setComment({ comment: event.target.value });
  }

  function handleCommentSubmit(event) {
    event.preventDefault();
    if (comment.comment === "") {
      toast.error("Comment Cannot Be Empty!!");
      return;
    }
  }

  return (
    <BaseComponent>
      <div className="container">
        <Card className="mt-4 mb-2">
              <CardBody>
                <h2>Title : Demo Title</h2>
                <h6>CATEGORY : Sports</h6>
                <div className="container text-center">
                    <img
                      src={defaultpostimage}
                      alt="defaultimage"
                      height={"350px"}
                      width={"350px"}
                    />
                </div>
                <CardText>
                    Demo Content<br/>.<br/>.<br/>.
                </CardText>
              </CardBody>
        </Card>
        <Card className="mt-4 mb-2">
              <CardBody>
                <h3>Comments</h3>
                <Container>
                    <Form onSubmit={handleCommentSubmit}>
                      <FormGroup>
                        <Input
                          id="comment"
                          name="comment"
                          type="textarea"
                          placeholder="Enter Comment"
                          value={comment.comment}
                          onChange={handleCommentChange}
                        />
                      </FormGroup>
                      <Button color="danger" size="sm">
                        Add Comment
                      </Button>
                    </Form>
                  <Container className="mt-3">
                    Demo Comment
                  </Container>
                </Container>
              </CardBody>
        </Card>
      </div>
    </BaseComponent>
  );
}

export default FullPostView;