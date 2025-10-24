package ui;

import java.io.FileNotFoundException;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// References: https://github.students.cs.ubc.ca/CPSC210/TellerApp
//             https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

@ExcludeFromJacocoGeneratedReport
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to CharNotes!");
        try {
            new CharNotes();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}