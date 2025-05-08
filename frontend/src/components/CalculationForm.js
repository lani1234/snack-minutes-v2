import { useState } from "react";
import SnackSelector from "./SnackSelector";
import ActivitySelector from "./ActivitySelector";
import { calculateMinutes } from "../services/api";

export default function CalculationForm({ onResult }) {
  const [weight, setWeight] = useState(0);
  const [snackId, setSnackId] = useState("");
  const [servings, setServings] = useState(1);
  const [activityId, setActivityId] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const data = {
      weightLbs: Number(weight),
      snackId: Number(snackId),
      numberOfServings: Number(servings),
      activityId: Number(activityId),
    };
    const result = await calculateMinutes(data);
    onResult(result);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Weight (lbs):</label>
        <input
          type="number"
          value={weight}
          onChange={(e) => setWeight(e.target.value)}
          required
        />
      </div>
      <div>
        <SnackSelector value={snackId} onChange={setSnackId} />
      </div>
      <div>
        <label>Servings:</label>
        <input
          type="number"
          value={servings}
          onChange={(e) => setServings(e.target.value)}
          min={1}
          required
        />
      </div>
      <div>
        <ActivitySelector value={activityId} onChange={setActivityId} />
      </div>
      <button type="submit">Calculate</button>
    </form>
  );
}