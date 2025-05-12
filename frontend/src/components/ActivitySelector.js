import { useEffect, useState } from "react";
import { fetchActivities } from "../services/api";
import styles from './CalculationForm.module.css';

export default function ActivitySelector({ value, onChange, className }) {
  const [activities, setActivities] = useState([]);

  useEffect(() => {
    fetchActivities().then(setActivities);
  }, []);

  return (
    <select
        value={value}
        onChange={(e) => onChange(e.target.value)}
        className={className || styles.select}
    >
      <option value="">Select an Activity</option>
      {activities.map((activity) => (
        <option key={activity.id} value={activity.id}>
          {activity.name}
        </option>
      ))}
    </select>
  );
}