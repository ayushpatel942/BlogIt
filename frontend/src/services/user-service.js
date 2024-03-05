// import { myaxios } from "./helper";

// export const LoginFunc = (userdata) => {
//   return myaxios.post("/api/login", userdata);
// };

// export const SignUpFunc = (userdata) => {
//   return myaxios.post("/api/users", userdata);
// };
import { myaxios } from "./helper";

export const LoginFunc = (userdata) => {
  return myaxios.post("/api/login", userdata);
};

export const SignUpFunc = (userdata) => {
  return myaxios.post("/api/users", userdata);
};
