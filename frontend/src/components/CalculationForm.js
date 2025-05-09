import { useState } from "react";
import SnackSelector from "./SnackSelector";
import ActivitySelector from "./ActivitySelector";
import { calculateMinutes } from "../services/api";

export default function CalculationForm({ onResult }) {
  const [weight, setWeight] = useState(0);
  const [snackId, setSnackId] = useState("");
  const [activityId, setActivityId] = useState("");
  const numberOfServings = 1; // hardcoded value for now

  const handleSubmit = async (e) => {
    e.preventDefault();
    const data = {
      weightLbs: Number(weight),
      snackId: Number(snackId),
      numberOfServings,
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
        <ActivitySelector value={activityId} onChange={setActivityId} />
      </div>

      {/* Optional hidden input if you want it to appear in the form DOM */}
      <input type="hidden" name="numberOfServings" value={numberOfServings} />

      <button type="submit">Calculate</button>
    </form>
  );
}
