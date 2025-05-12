import styles from './ResultDisplay.module.css';

export default function ResultDisplay({ minutes }) {
  if (minutes == null) return null;

  return (
    <div className={styles.resultContainer}>
      <p className={styles.minutes}>
        <strong>{minutes}</strong> Snack Minutes
      </p>
    </div>
  );
}