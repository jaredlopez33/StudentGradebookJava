import java.io.*;
import java.util.*;

// Base class representing a generic person (Demonstrates OOP / Classes)
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name);
    }
}

// Student class inheriting from Person (Demonstrates inheritance)
class Student extends Person {
    private HashMap<String, Double> grades; // Data structure: Java Collection Framework HashMap

    public Student(String name, int id) {
        super(name, id);
        grades = new HashMap<>();
    }

    public void addGrade(String course, double grade) {
        grades.put(course, grade);
    }

    public HashMap<String, Double> getGrades() {
        return grades;
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double g : grades.values()) {
            sum += g;
        }
        return sum / grades.size();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + String.format("%.2f", calculateAverage()));
    }
}

// Main class for the Student Gradebook System
public class StudentGradebook {
    private static ArrayList<Student> studentList = new ArrayList<>(); // Data structure: ArrayList
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "grades_data.txt";

    public static void main(String[] args) {
        loadDataFromFile(); // Load data on startup (File I/O)
        
        int choice = 0;
        // Main menu loop (Demonstrates loops, conditionals, and expressions)
        do {
            showMenu();
            try {
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        addNewStudent();
                        break;
                    case 2:
                        addGradeToStudent();
                        break;
                    case 3:
                        displayAllStudents();
                        break;
                    case 4:
                        saveDataToFile(); // Save data before exit (File I/O)
                        System.out.println("Data saved successfully. Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric option.");
            }
            System.out.println();
        } while (choice != 4);
        
        scanner.close();
    }

    // Function to display the menu interface on screen
    private static void showMenu() {
        System.out.println("=== STUDENT GRADEBOOK SYSTEM ===");
        System.out.println("1. Add New Student");
        System.out.println("2. Add Grade for a Course");
        System.out.println("3. View All Students & Averages");
        System.out.println("4. Save & Exit");
        System.out.print("Select an option: ");
    }

    // Function to create and add a new student object
    private static void addNewStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID (integer): ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            studentList.add(new Student(name, id));
            System.out.println("Student added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format. Student not added.");
        }
    }

    // Function to add a grade to an existing student record
    private static void addGradeToStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }
        System.out.print("Enter student ID to update: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Student found = null;
            for (Student s : studentList) {
                if (s.id == id) {
                    found = s;
                    break;
                }
            }

            if (found != null) {
                System.out.print("Enter course name: ");
                String course = scanner.nextLine();
                System.out.print("Enter grade (0-10): ");
                double grade = Double.parseDouble(scanner.nextLine());
                found.addGrade(course, grade);
                System.out.println("Grade added successfully!");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format.");
        }
    }

    // Function to iterate and display all registered student records
    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }
        System.out.println("--- STUDENT RECORDS ---");
        for (Student s : studentList) {
            s.displayInfo();
            System.out.println("-----------------------");
        }
    }

    // Additional Requirement: Write data to a text file (File I/O)
    private static void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : studentList) {
                writer.write(s.id + "," + s.name);
                for (Map.Entry<String, Double> entry : s.getGrades().entrySet()) {
                    writer.write("," + entry.getKey() + ":" + entry.getValue());
                }
                writer.newLine();
            }
            System.out.println("Data successfully written to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Additional Requirement: Read data from a text file (File I/O)
    private static void loadDataFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    Student student = new Student(name, id);

                    for (int i = 2; i < parts.length; i++) {
                        String[] gradePart = parts[i].split(":");
                        if (gradePart.length == 2) {
                            student.addGrade(gradePart[0], Double.parseDouble(gradePart[1]));
                        }
                    }
                    studentList.add(student);
                }
            }
            System.out.println("Previous records loaded successfully from " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}