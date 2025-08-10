package Javaprograms;
import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt"; 
        int choice;

        while (true) {
            System.out.println("\n===== Notes App =====");
            System.out.println("1. Add a Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Write your note: ");
                String note = sc.nextLine();
                try (FileWriter fw = new FileWriter(fileName, true)) { 
                    fw.write(note + "\n");
                    System.out.println("Note saved successfully!");
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }

            } else if (choice == 2) {
                System.out.println("\n--- Your Notes ---");
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    boolean hasNotes = false;
                    while ((line = br.readLine()) != null) {
                        System.out.println("- " + line);
                        hasNotes = true;
                    }
                    if (!hasNotes) {
                        System.out.println("(No notes found!)");
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("(No notes yet! File not found.)");
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

    }
}

