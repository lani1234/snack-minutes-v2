import { useState } from "react";
import SnackSelector from "./SnackSelector";
import ActivitySelector from "./ActivitySelector";
import { calculateMinutes } from "../services/api";
import styles from './CalculationForm.module.css';

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
      activityId: Number(activityId),
      numberOfServings,
    };
    const result = await calculateMinutes(data);
    onResult(result);
  };

  return (
    <form onSubmit={handleSubmit} className={styles.formContainer}>

      <div className={styles.inputGroup}>
        <label className={styles.label}>My Weight (lbs):</label>
        <input
          type="number"
          value={weight}
          onChange={(e) => setWeight(e.target.value)}
          className={styles.input}
          required
        />
      </div>

      <div className={styles.inputGroup}>
        <SnackSelector value={snackId} onChange={setSnackId}  className={styles.input} />
      </div>

      <div className={styles.inputGroup}>
        <ActivitySelector value={activityId} onChange={setActivityId}  className={styles.input} />
      </div>

      {/* Optional hidden input if you want it to appear in the form DOM */}
      <input type="hidden" name="numberOfServings" value={numberOfServings} />

      <button type="submit" className={styles.button}>Calculate</button>
    </form>
  );
}
