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
    // EFFECTS: processes user input for main menu
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
                System.out.println("\nGoodbye!");
            } else {
                processCommand(command);
            }
        }

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
            viewCharacter();
        } else if (command.equals("a")) {
            addCharacter();
        } else if (command.equals("d")) { 
            delCharacter();
        } else if (command.equals("r")) {
            doRearrange();
        } else if (command.equals("e")) {
            editCharacter();
        } else {}
    }

    // EFFECTS: Lists the information about the given character
    private void viewCharacter() {
    
    }

    // MODIFIES: this
    // EFFECTS: edits character information based on user input
    private void editCharacter() {
    }

    // MODIFIES: this
    // EFFECTS: rearranges characters in main group
    private void doRearrange() {
        if (mainList.getGroup().size() <= 1) {
            System.out.println("There are no characters to rearrange"); 
        }
        System.out.print("Enter the current position (int) of the character you want to move");
        int currentPos = input.nextInt();
        System.out.print("Enter where you want to move the character");
        int newPos = input.nextInt();

        if (newPos <= mainList.getGroup().size() - 1) {
            mainList.rearrange(currentPos, newPos);
        } else {
            System.out.println("At least one of the locations you have entered is not valid");
        }
    
    }

    // MODIFIES: this
    // EFFECTS: removes character from the general list
    private void delCharacter() {
    }

    // MODIFIES: this
    // EFFECTS: adds new character to the general list
    private void addCharacter() {
        System.out.println("Enter character name");
    }

    // EFFECTS: displays menu of options and the main character list to user
    private void displayMenu() {
        System.out.println("All Characters:");
        System.out.println(mainList.listMembers());
        System.out.println("\nControls:");
        System.out.println("\tv -> view general list");
        System.out.println("\ta -> add character");
        System.out.println("\te -> edit character");
        System.out.println("\td -> remove character");
        System.out.println("\tr -> rearrange characters");
        System.out.println("\tOTHER OPTIONS TBA!");
        System.out.println("\tq -> quit");
    }

} //The UI was made by heavily referencing the TellerApp UI
