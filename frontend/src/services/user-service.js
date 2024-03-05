import { myaxios } from "./helper";

export const LoginFunc = (userdata) => {
  return myaxios.post("/api/login", userdata);
};