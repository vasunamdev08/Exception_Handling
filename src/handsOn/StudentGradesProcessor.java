package handsOn;

import java.io.*;
import java.util.*;

public class StudentGradesProcessor {

    static class Student {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Enter the path to the grades file: ");
        String filePath = consoleScanner.nextLine();

        List<Student> validStudents = new ArrayList<>();
        List<String> failingStudents = new ArrayList<>();
        int totalGrades = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int validCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length != 2) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                String name = parts[0];
                String gradeStr = parts[1];

                try {
                    int grade = Integer.parseInt(gradeStr);

                    if (grade < 0 || grade > 100) {
                        throw new InvalidGradeException("Grade out of range for " + name + ": " + grade);
                    }

                    Student student = new Student(name, grade);
                    validStudents.add(student);
                    totalGrades += grade;
                    validCount++;

                    if (grade < 40) {
                        failingStudents.add(name);
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format for grade: " + gradeStr + " (line: " + line + ")");
                } catch (InvalidGradeException e) {
                    System.err.println("Invalid grade: " + e.getMessage());
                }
            }

            // Output results
            System.out.println("\nValid Students:");
            for (Student s : validStudents) {
                System.out.println(s.name + ": " + s.grade);
            }

            System.out.println("\nFailing Students:");
            if (failingStudents.isEmpty()) {
                System.out.println("None");
            } else {
                for (String name : failingStudents) {
                    System.out.println(name);
                }
            }

            if (validCount > 0) {
                double average = (double) totalGrades / validCount;
                System.out.printf("\nAverage Grade: %.2f\n", average);
            } else {
                System.out.println("\nNo valid grades found.");
            }

            // Optional: Write to output file
            writeResultsToFile("src/handsOn/results.txt", validStudents, failingStudents, validCount > 0 ? (double) totalGrades / validCount : null);

        } catch (FileNotFoundException e) {
            System.err.println("The file was not found: " + filePath);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file.");
        } finally {
            consoleScanner.close();
        }
    }

    private static void writeResultsToFile(String outputPath, List<Student> validStudents, List<String> failingStudents, Double averageGrade) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            writer.println("Valid Students:");
            for (Student s : validStudents) {
                writer.println(s.name + ": " + s.grade);
            }

            writer.println("\nFailing Students:");
            if (failingStudents.isEmpty()) {
                writer.println("None");
            } else {
                for (String name : failingStudents) {
                    writer.println(name);
                }
            }

            if (averageGrade != null) {
                writer.printf("\nAverage Grade: %.2f\n", averageGrade);
            } else {
                writer.println("\nNo valid grades found.");
            }

            System.out.println("\nResults written to " + outputPath);
        } catch (IOException e) {
            System.err.println("Error writing to results file.");
        }
    }
}

