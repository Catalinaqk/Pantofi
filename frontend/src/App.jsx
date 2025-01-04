import {HashRouter, Link, Navigate, Route, Routes} from "react-router-dom";
import HomePage from "./pages/HomePage.jsx";
import Register from "./pages/Register.jsx";
import ForgotPassword from "./pages/ForgotPassword.jsx";


/**
 * App component
 * @returns {JSX.Element} The rendered App component.
 * @constructor
 */
function App() {

    return (
        <HashRouter>
            <div className="container-fluid">
                <div className="d-flex justify-content-center">
                    <Link to="/" className="navbar-brand bg-transparent text-dark">
                        <div className="d-flex align-items-center">
                            <h1>Automatizarea Materialelor</h1>
                        </div>
                    </Link>
                </div>
            </div>
            <Routes>
                <Route path="/" element={<Navigate to={"/books"}/>}/>
                <Route path="/material" element={<HomePage/>}/>
                <Route path="/register" element={<Register/>}/>
                <Route path="/forgot-password" element={<ForgotPassword/>}/>
            </Routes>
        </HashRouter>
    );

}

export default App;