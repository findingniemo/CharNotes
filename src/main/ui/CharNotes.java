package ui;

import java.util.Scanner;

import model.CharacterGroup;

public class CharNotes {
    CharacterGroup mainList;
    Scanner input;

    
    // EFFECTS: runs the teller application
    public CharNotes() {
        runChar();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runChar() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes main character list
    private void init() {
        mainList = new CharacterGroup("General List");
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("v")) {
            viewList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: Displays the names of all characters in the main character group
    private void viewList() {
        // TODO Auto-generated method stub
        System.out.println(mainList.listMembers());
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nControls:");
        System.out.println("\tv -> view all");
        System.out.println("\tother options tba!");
        System.out.println("\tq -> quit");
    }

} //The UI was made by heavily referencing the TellerApp UI
