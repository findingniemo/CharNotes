package ui;

import model.Character;
import javax.swing.*;
import java.awt.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Represents a character page
@ExcludeFromJacocoGeneratedReport
public class CharacterPage extends JPanel {

    private final CharNotesGUI gui;

    JPanel panel;
    JLabel name;
    JLabel age;
    JLabel gender;
    JLabel bio;
    JLabel rel;
    JTextArea textArea;
    boolean closed;

    // EFFECTS: Creates a character page for the given character
    public CharacterPage(CharNotesGUI gui, Character c) {
        this.gui = gui;
        closed = false;
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        this.add(panel);
        init(c);
        setVisible(true);
    }

    // EFFECTS: creates a button to close the character profile
    public JButton closePage() {
        JButton ret = new JButton("Close Character Info");

        ret.addActionListener(e -> {
            setVisible(false);
            closed = true;
        });

        return ret;
    }

    // MODIFIES: this
    // EFFECTS: initializes character labels
    public void init(Character c) {

        name = new JLabel("Name: " + c.getName(), JLabel.CENTER);
        age = new JLabel("Age: " + Integer.toString(c.getAge()), JLabel.CENTER);
        gender = new JLabel("Gender: " + c.getGender(), JLabel.CENTER);
        bio = new JLabel("Bio: " + c.getBio(), JLabel.CENTER);
        rel = new JLabel("Family: " + c.listFamilyMembers(), JLabel.CENTER);
        panel.add(name);
        panel.add(age);
        panel.add(gender);
        panel.add(bio);
        panel.add(rel);
        panel.add(closePage());
    }

    public boolean getClosed() {
        return closed;
    }

}
