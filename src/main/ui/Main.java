package ui;

import java.io.FileNotFoundException;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// References: https://github.students.cs.ubc.ca/CPSC210/TellerApp
//             https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
//             https://github.students.cs.ubc.ca/CPSC210/LongFormProblemStarters
//             https://github.students.cs.ubc.ca/CPSC210/C3-LectureLabStarter
//             https://stackoverflow.com/questions/6578205/swing-jlabel-text-change-on-the-running-application

@ExcludeFromJacocoGeneratedReport
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to CharNotes!");
        try {
            new CharNotesGUI();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}