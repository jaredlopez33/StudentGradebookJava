# Overview

As a software engineer continuously expanding my technical skill set, my goal with this project was to gain hands-on mastery of Java's core syntax, object-oriented architecture, and standard libraries by building a practical, data-persistent application from scratch.

This software is a console-based **Student Gradebook Manager** developed in Java. It allows users to register student profiles, assign grades across multiple courses, automatically calculate grade point averages, and persist all records locally using text-based file input/output operations.

My purpose for writing this software was to practice structuring a modular Java program using inheritance (`Person` and `Student` classes), leveraging dynamic data structures from the Java Collection Framework (`ArrayList` and `HashMap`), and implementing reliable file persistence (`BufferedReader` and `BufferedWriter`) with proper exception handling.

[Software Demo Video](https://drive.google.com/file/d/1OO_bz_X0hPszeiJ2WGAbo90TT4lJUphU/view?usp=sharing)

# Development Environment

- **IDE & Editor:** Visual Studio Code with the Extension Pack for Java
- **Compiler & Runtime:** Java Development Kit (JDK) and Java Virtual Machine (JVM)
- **Version Control:** Git and GitHub

This project was written in **Java** using standard built-in libraries from the Java SE API:
- `java.util.ArrayList` and `java.util.HashMap` (Java Collection Framework) for managing student lists and course-grade mappings.
- `java.util.Scanner` for reading and validating console input.
- `java.io.BufferedReader`, `java.io.BufferedWriter`, `java.io.FileReader`, `java.io.FileWriter`, and `java.io.IOException` for persistent file storage.

# Useful Websites

- [Oracle Java SE Documentation](https://docs.oracle.com/en/java/)
- [W3Schools Java Tutorial](https://www.w3schools.com/java/)
- [GeeksforGeeks Java Collections Framework](https://www.geeksforgeeks.org/collections-in-java-2/)

# Future Work

- Add input validation to prevent duplicate student IDs and enforce strict numeric grade boundaries (0 to 20).
- Implement options to edit or delete existing student records and individual course grades.
- Upgrade data persistence from plain text (`grades_data.txt`) to JSON or a relational SQL database for better scalability.