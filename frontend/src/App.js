import Login from "./pages/Login";
import Signup from "./pages/Signup";
import "bootstrap/dist/css/bootstrap.min.css";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer } from "react-toastify";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Posts from "./pages/Posts";
import UserProvider from "./context/UserProvider";
import FullPostView from "./pages/FullPostView";
import PublicPosts from "./pages/PublicPosts";
import Profile from "./pages/Profile";
import Home from "./pages/Home";
import About from "./pages/About";
import PrivateRoute from "./pages/PrivateRoute";
import EditPost from "./pages/EditPost";

function App() {
  return (
    <UserProvider>
      <div className="App">
        <BrowserRouter>
          <ToastContainer position="bottom-right" />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/home" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/about" element={<About />} />
            <Route path="/posts/:postid" element={<FullPostView />} />
            <Route
              path="/posts/category/:categoryname"
              element={<PublicPosts />}
            />
            <Route path="/user/:username" element={<PrivateRoute />}>
              <Route path="profile" element={<Profile />} />
              <Route path="addpost" element={<Posts />} />
              <Route path="editpost/:postid" element={<EditPost />} />
            </Route>
            <Route path="/*" element={<h1>NOT FOUND</h1>} />
          </Routes>
        </BrowserRouter>
      </div>
    </UserProvider>
  );
}

export default App;
