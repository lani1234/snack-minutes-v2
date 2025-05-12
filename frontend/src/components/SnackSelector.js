import { useEffect, useState } from "react";
import { fetchSnacks } from "../services/api";
import styles from './CalculationForm.module.css';

export default function SnackSelector({ value, onChange, className }) {
  const [snacks, setSnacks] = useState([]);

  useEffect(() => {
    fetchSnacks().then(setSnacks);
  }, []);

  return (
    <select
        value={value}
        onChange={(e) => onChange(e.target.value)}
        className={className || styles.select}
    >
      <option value="">Select a Snack</option>
      {snacks.map((snack) => (
        <option key={snack.id} value={snack.id}>
          {snack.name}
        </option>
      ))}
    </select>
  );
}