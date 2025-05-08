import { useEffect, useState } from "react";
import { fetchSnacks } from "../services/api";

export default function SnackSelector({ value, onChange }) {
  const [snacks, setSnacks] = useState([]);

  useEffect(() => {
    fetchSnacks().then(setSnacks);
  }, []);

  return (
    <select value={value} onChange={(e) => onChange(e.target.value)}>
      <option value="">Select a snack</option>
      {snacks.map((snack) => (
        <option key={snack.id} value={snack.id}>
          {snack.name}
        </option>
      ))}
    </select>
  );
}