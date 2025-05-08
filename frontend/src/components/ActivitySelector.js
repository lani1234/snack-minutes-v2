import { useEffect, useState } from "react";
import { fetchActivities } from "../services/api";

export default function ActivitySelector({ value, onChange }) {
  const [activities, setActivities] = useState([]);

  useEffect(() => {
    fetchActivities().then(setActivities);
  }, []);

  return (
    <select value={value} onChange={(e) => onChange(e.target.value)}>
      <option value="">Select an activity</option>
      {activities.map((activity) => (
        <option key={activity.id} value={activity.id}>
          {activity.name}
        </option>
      ))}
    </select>
  );
}