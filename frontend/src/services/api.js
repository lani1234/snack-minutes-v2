const BASE_URL = "http://localhost:8080";

export async function fetchSnacks() {
  const res = await fetch(`${BASE_URL}/snacks`);
  return res.json();
}

export async function fetchActivities() {
  const res = await fetch(`${BASE_URL}/activities`);
  return res.json();
}

export async function calculateMinutes(data) {
  const res = await fetch(`${BASE_URL}/calculate/anonymous`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  return res.json();
}