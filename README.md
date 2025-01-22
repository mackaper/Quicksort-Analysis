# Quicksort Analysis

This repository contains an in-depth exploration of sorting algorithms, focusing on implementing and analyzing multiple variations of the Quicksort algorithm alongside insertion sort. The project evaluates their performance under various conditions, providing insights into their efficiency and trade-offs.

## Key Highlights

- **Quicksort Variations:** Implemented four variations of the Quicksort algorithm:
  - Fixed Pivot
  - Random Pivot
  - Fixed Pivot with Insertion Sort for small arrays
  - Random Pivot with Insertion Sort for small arrays
- **Insertion Sort:** Provided an implementation of insertion sort for comparison and as a component of hybrid Quicksort algorithms.
- **Empirical Analysis:** Conducted runtime evaluations of the sorting algorithms using datasets of varying characteristics (random, sorted, reversed, equal values).
- **Comparison to Standard Library:** Benchmarked custom implementations against Java's `Arrays.sort` (dual-pivot Quicksort).
- **Results and Charts:** Detailed performance comparisons and runtime analysis charts are included in the `docs` folder.

## Repository Contents

- `src/IntSorter.java`: Interface for sorting algorithms.
- `src/InsertionSort.java`: Implementation of insertion sort.
- `src/QuicksortFixedPivot.java`: Quicksort with a fixed pivot.
- `src/QuicksortRandomPivot.java`: Quicksort with a randomly selected pivot.
- `src/QuicksortFixedPivotInsertion.java`: Hybrid Quicksort using a fixed pivot and insertion sort for small subarrays.
- `src/QuicksortRandomPivotInsertion.java`: Hybrid Quicksort using a random pivot and insertion sort for small subarrays.
- `src/Data.java`: Utility for generating test datasets.
- `src/Stopwatch.java`: Class for timing algorithm execution.
- `docs/report.md`: A detailed report presenting the results of the analysis, methodology, and findings.
- `docs/submission.txt`: Kattis submission IDs for validating correctness and performance of the implementations.

---

This project was part of a course assignment for the INDA program at KTH, designed to enhance skills in algorithm design, performance analysis, and empirical evaluation.
