# RangeQueries

## Introduction
This project implements a container for efficient range queries in a distributed in-memory database.

## Project Structure
The project is organized into the following components:

- `com.workday.RangeContainerFactory`: Interface for building an immutable container optimized for range queries.
- `com.workday.RangeContainer`: Interface for a specialized container of records optimized for efficient range queries on an attribute of the data.
- `com.workday.Ids`: Interface for an iterator of Ids.
- `com.workday.YourRangeContainerFactory`: Implementation of the `RangeContainerFactory` interface.
- `com.workday.ProcessRangeContainer`: Implementation of the `RangeContainer` interface.
- `com.workday.ProcessedIds`: Implementation of the `Ids` interface.
- `RangeQueryBasicTest`: JUnit test class for basic functionality testing.
- `RangeQueryAdditionalTest`: JUnit test class for additional functionality testing.
- `RangeQueryPerformanceTest`: Class for performance testing with a given dataset(32k instances).

## Getting Started
To run the basic functionality test, execute the following steps:

1. Clone the repository: `git clone https://github.com/grajoria/RangeQueries.git`
2. Open the project in IntelliJ IDEA or your preferred Java IDE.
3. Navigate to `RangeQueryBasicTest` and run the test.

To run the performance benchmark, navigate to `RangeQueryPerformanceTest` and run the test.

## Dependencies
The project uses JUnit for testing. Dependencies are managed using Gradle (or Maven).
