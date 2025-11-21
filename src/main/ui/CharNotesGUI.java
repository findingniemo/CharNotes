package ui;

import java.awt.*;
import javax.swing.*;

import model.*;
import model.Character;

public class CharNotesGUI extends JFrame {
    public static final int MAIN_TAB_INDEX = 0;
    public static final int CHARACTER_PAGE_TAB_INDEX = 1;

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    private CharacterGroup mainGroup;

    CharNotesGUI() {
        super("CharNotes");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainGroup = new CharacterGroup("General List");
        JButton newChar = new JButton("Add New Character");
        JButton save = new JButton("Save");
        JButton load = new JButton("Load");

        add(newChar);
        add(save);
        add(load);

        setVisible(true);
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
    public JPanel formatButtonRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

}
