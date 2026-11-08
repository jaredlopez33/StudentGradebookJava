# Student Gradebook System in Java

## Overview
This software is a console-based **Student Gradebook Manager** developed in Java. It allows instructors or students to register new student profiles, add course grades, calculate grade point averages automatically, and maintain persistent records using file input/output operations.

## Features
- **Object-Oriented Design:** Implements inheritance using a base `Person` class and a derived `Student` class.
- **Java Collections Framework:** Utilizes `ArrayList` to manage the collection of students and `HashMap` to store individual course grades.
- **File I/O Persistence:** Automatically saves and loads student records to and from a local text file (`grades_data.txt`).
- **Interactive Console Menu:** Validates user inputs using loops, conditionals, and exception handling.

## Requirements Satisfied
- **Basic Requirements:**
  - Variables & Expressions
  - Conditionals (`if/else`, switch statements)
  - Loops (`do-while`, `for`)
  - Functions (Modular design with helper methods)
  - Classes (`Person`, `Student`, `StudentGradebook`)
  - Collections (`ArrayList`, `HashMap`)
- **Additional Requirement:**
  - Read and write to a file (`BufferedReader` and `BufferedWriter`).

## How to Run
1. Ensure you have the **Java Development Kit (JDK)** installed on your system.
2. Compile the Java files from your terminal:
   ```bash
   javac StudentGradebook.java