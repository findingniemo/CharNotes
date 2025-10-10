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
        } 
    }

    private void listCommands(String command) {
        if (command.equals("a")) {
            addCharacter();
        } else if (command.equals("d")) { 
            delCharacter();
        } else if (command.equals("r")) {
            doRearrange();
        }
    }

    private void doRearrange() {
        viewList();
    }

    private void delCharacter() {
        viewList();
    }

    private void addCharacter() {
        viewList();
    }

    // EFFECTS: Displays the names of all characters in the main character group
    private void viewList() {
        System.out.println(mainList.listMembers());
        System.out.println("\ta -> add character");
        System.out.println("\td -> remove character");
        System.out.println("\tr -> rearrange characters");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nControls:");
        System.out.println("\tv -> view general list");
        System.out.println("\tOTHER OPTIONS TBA!");
        System.out.println("\tq -> quit");
    }

} //The UI was made by heavily referencing the TellerApp UI
