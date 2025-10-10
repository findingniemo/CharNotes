package ui;

import java.util.Scanner;

import model.Character;
import model.CharacterGroup;

public class CharNotes {
    CharacterGroup mainList;
    Scanner input;
    Character charaEdit;

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
        }
    }

    // EFFECTS: Lists the information about the given character
    private void viewCharacter() {
        if (mainList.getGroup().size() == 0) {
            System.out.println("There are no characters to view");
        } else {
            System.out.println("Enter the position (int) of the character you would like to view");
            int charPosition = input.nextInt();
            if (charPosition >= mainList.getGroup().size()) {
                System.out.println("There is no character in that location");
            } else {
                Character chara = mainList.getGroup().get(charPosition);
                System.out.println("Name:" + chara.getName());
                System.out.println("Age:" + chara.getAge());
                System.out.println("Gender:" + chara.getGender());
                System.out.println("Family:" + chara.listFamilyMembers());
                System.out.println("Biography:" + chara.getBio());
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: edits character information based on user input
    private void editCharacter() {
        if (mainList.getGroup().size() == 0) {
            System.out.println("There are no characters to view");
        } else {
            System.out.println("Which character would you like to edit? (enter position int)");
            int charPosition = input.nextInt();
            if (charPosition >= mainList.getGroup().size()) {
                System.out.println("There is no character in that location");
            } else {
                charaEdit = mainList.getGroup().get(charPosition);
                System.out.println("Which character information would you like to edit? Enter number:");
                System.out.println("1: Name, 2: Age, 3: Gender, 4: Family; 5: Biography");
                int choice = input.nextInt();
                editCharacterHelper(choice);
                System.out.println("Done!");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: edits character info based on the choice made in editCharacter()
    private void editCharacterHelper(int choice) {
        if (choice == 1) {
            System.out.println("Enter new name:");
            charaEdit.setName(input.next());
        } else if (choice == 2) {
            System.out.println("Enter new age:");
            charaEdit.setAge(input.nextInt());
        } else if (choice == 3) {
            System.out.println("Enter new gender:");
            charaEdit.setGender(input.next());
        } else if (choice == 4) {
            System.out.println("Who are they related to? (enter int position)");
            int num = input.nextInt();
            if (num > mainList.getGroup().size()) {
                System.out.println("There is no character in that location");
            } else {
                charaEdit.addFamily(mainList.getGroup().get(num));
            }
        } else if (choice == 5) {
            System.out.println("Enter new biography:");
            charaEdit.setBio(input.next());
        } else {
            System.out.println("Not a valid option");
        }
    }

    // MODIFIES: this
    // EFFECTS: rearranges characters in main group
    private void doRearrange() {
        if (mainList.getGroup().size() <= 1) {
            System.out.println("There are no characters to rearrange");
        } else {
            System.out.print("Enter the current position (int) of the character you want to move");
            int currentPos = input.nextInt();
            System.out.print("Enter where you want to move the character");
            int newPos = input.nextInt();

            if (newPos <= mainList.getGroup().size() - 1 && currentPos <= mainList.getGroup().size() - 1) {
                mainList.rearrange(currentPos, newPos);
            } else {
                System.out.println("At least one of the locations you have entered is not valid");
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: removes character from the general list
    private void delCharacter() {
        if (mainList.getGroup().size() == 0) {
            System.out.println("There are no characters to delete");
        } else {
            System.out.println("Which character would you like to delete? (enter position int)");
            int charPosition = input.nextInt();
            if (charPosition >= mainList.getGroup().size()) {
                System.out.println("There is no character in that location");
            } else {
                mainList.getGroup().remove(charPosition);
                System.out.println("Character successfully deleted");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds new character to the general list
    private void addCharacter() {
        System.out.println("Enter character name");
        String name = input.next();
        Character newChara = new Character(name);
        mainList.addToGroup(newChara);
        int i = 0;
        while (i < 3) {
            System.out.println("...");
            i++;
        }
        System.out.println("Done!");
        System.out.println("You can view your character in the main list.");
    }

    // EFFECTS: displays menu of options and the main character list to user
    private void displayMenu() {
        System.out.println("All Characters:");
        System.out.println(mainList.listMembers());
        System.out.println(mainList.listMemberNumbers());
        System.out.println("\nControls:");
        System.out.println("\tv -> view character info");
        System.out.println("\ta -> add character");
        System.out.println("\te -> edit character");
        System.out.println("\td -> remove character");
        System.out.println("\tr -> rearrange characters");
        System.out.println("\tOTHER OPTIONS TBA!");
        System.out.println("\tq -> quit");
    }

} // This UI heavily references the TellerApp UI
