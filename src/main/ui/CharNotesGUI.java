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
    private JPanel characters;
    private JTextArea textField;
    private JButton newChar;
    private JButton save;
    private JButton load;

    // EFFECTS: runs the CharNotes GUI
    public CharNotesGUI() throws FileNotFoundException{
        super("CharNotes");
        setSize(WIDTH, HEIGHT);
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        setContentPane(p);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainGroup = new CharacterGroup("General List");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        initButtons();
        add(newChar);

        JPanel buttonRow = formatRow(newChar);
        buttonRow.add(textField);
        buttonRow.add(save);
        buttonRow.add(load);
        buttonRow.setSize(WIDTH, HEIGHT / 6);
        characters = new JPanel();
        characters.setLayout(new BoxLayout(characters, BoxLayout.Y_AXIS));

        p.add(buttonRow);
        p.add(characters);
        setVisible(true);
    }

    // EFFECTS: initializes buttons and text box
    public void initButtons() {
        newChar = new JButton("Add New Character");
        save = new JButton("Save");
        load = new JButton("Load");
        textField = new JTextArea(1, 15);
        
        newChar.addActionListener(e -> {
            listCharacter(textField.getText());
            System.out.println("Added character: " + textField.getText());
            textField.setText("");
        });

        save.addActionListener(e -> {
            saveCharacterGroup();
        });

        load.addActionListener(e -> {
            loadCharacterGroup();
            addLoad();
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

    // MODIFIES: this
    // EFFECTS: adds the loaded characters to the gui
    private void addLoad() {
        characters.removeAll();
        for(Character c : mainGroup.getGroup()) {
        JPanel p = new JPanel();
        JLabel label = new JLabel();
        JLabel image = new JLabel(loadImage());

        p.setLayout(new FlowLayout());
        label.setText(c.getName());
        p.add(image);
        p.add(label);
        p.add(deleteCharacter(p, c));
        characters.add(p);
        }
        this.revalidate();
    }

    // EFFECTS: returns the CharacterGroup controlled by this UI
    public CharacterGroup getCharacterGroup() {
        return mainGroup;
    }

    // MODIFIES: this
    // EFFECTS: creates new Character and a panel for it
    public void listCharacter(String name) {
        Character c = new Character(name);
        JPanel p = new JPanel();
        JLabel label = new JLabel();
        JLabel image = new JLabel(loadImage());

        p.setLayout(new FlowLayout());
        label.setText(name);
        p.add(image);
        p.add(label);
        p.add(deleteCharacter(p, c));
        mainGroup.addToGroup(c);
        characters.add(p);

        p.revalidate();
    }

    // EFFECTS: creates a delete button for Character c and returns it
    public JButton deleteCharacter(JPanel p, Character c) {
        JButton del = new JButton("X");

        del.addActionListener(e -> {
            characters.remove(p);
            mainGroup.getGroup().remove(c);
            System.out.println("Removed: " + c.getName());
            revalidate();
        });

        return del;
    }

    // EFFECTS: creates and returns row with button included
    public JPanel formatRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    // EFFECTS: loads image from lib and returns it
    private ImageIcon loadImage() {
		String sep = System.getProperty("file.separator");
		return new ImageIcon(System.getProperty("user.dir") + sep + "lib" + sep + "icon.png");
	}

}
