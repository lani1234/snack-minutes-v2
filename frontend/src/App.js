import { useState } from "react";
import CalculationForm from "./components/CalculationForm";
import ResultDisplay from "./components/ResultDisplay";

function App() {
  const [result, setResult] = useState(null);

  return (
    <div className="App">
      <h1>Snack Minutes Calculator</h1>
      <CalculationForm onResult={(res) => setResult(res.minutes)} />
      {result !== null && <ResultDisplay minutes={result} />}
    </div>
  );
}

export default App;

//import logo from './logo.svg';
//import './App.css';
//
//function App() {
//  return (
//    <div className="App">
//      <header className="App-header">
//        <img src={logo} className="App-logo" alt="logo" />
//        <p>
//          Edit <code>src/App.js</code> and save to reload.
//        </p>
//        <a
//          className="App-link"
//          href="https://reactjs.org"
//          target="_blank"
//          rel="noopener noreferrer"
//        >
//          Learn React
//        </a>
//      </header>
//    </div>
//  );
//}
//
//export default App;
