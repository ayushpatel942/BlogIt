
import { myaxios } from "./helper";

export const LoginFunc = (userdata) => {
  return myaxios.post("/api/login", userdata);
};

export const SignUpFunc = (userdata) => {
  return myaxios.post("/api/users", userdata);
};

export const FetchUserDetailsFunc=(username)=>{
  return myaxios.get(`/api/users/${username}`);
};