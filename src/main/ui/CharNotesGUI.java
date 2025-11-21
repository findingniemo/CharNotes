package ui;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import model.*;
import model.Character;
import persistence.JsonReader;
import persistence.JsonWriter;

public class CharNotesGUI extends JFrame {
    public static final int MAIN_TAB_INDEX = 0;
    public static final int CHARACTER_PAGE_TAB_INDEX = 1;

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    private CharacterGroup mainGroup;
    private static final String JSON_STORE = "src\\data\\maingroup.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JTextArea textArea;
    private JButton newChar;
    private JButton save;
    private JButton load;

    public CharNotesGUI() throws FileNotFoundException{
        super("CharNotes");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainGroup = new CharacterGroup("General List");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        initButtons();
        add(newChar);

        JPanel buttonRow = formatRow(newChar);
        buttonRow.add(save);
        buttonRow.add(load);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        setVisible(true);
        this.add(buttonRow);
    }

    public void initButtons() {
        newChar = new JButton("Add New Character");
        save = new JButton("Save");
        load = new JButton("Load");
        
        newChar.addActionListener(e -> {
            mainGroup.addToGroup(new Character(""));
            System.out.println("Added character");
        });

        save.addActionListener(e -> {
            saveCharacterGroup();
        });

        load.addActionListener(e -> {
            loadCharacterGroup();
        });
        
    }

    // EFFECTS: saves character group to file
    private void saveCharacterGroup() {
        try {
            jsonWriter.open();
            jsonWriter.write(mainGroup);
            jsonWriter.close();
            System.out.println("Saved " + mainGroup.getGroupName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads character group from file
    private void loadCharacterGroup() {
        try {
            mainGroup = jsonReader.read();
            System.out.println("Loaded " + mainGroup.getGroupName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //EFFECTS: returns the CharacterGroup controlled by this UI
    public CharacterGroup getCharacterGroup() {
        return mainGroup;
    }

    public void listCharacter(Character c) {
        JLabel label = new JLabel(c.getName());
        add(label);
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

}
