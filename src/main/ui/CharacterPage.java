package ui;

import model.Character;
import javax.swing.*;
import java.awt.*;
import java.lang.module.ModuleDescriptor.Requires;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Represents a character page
@ExcludeFromJacocoGeneratedReport
public class CharacterPage extends JPanel {

    private final CharNotesGUI gui;

    Character chara;
    JPanel panel;
    JLabel name;
    JLabel age;
    JLabel gender;
    JLabel bio;
    JLabel rel;
    JTextArea textArea;
    JButton submit;
    boolean closed;

    // EFFECTS: Creates a character page for the given character
    public CharacterPage(CharNotesGUI gui, Character c) {
        this.gui = gui;
        chara = c;
        closed = false;
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));
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
    // EFFECTS: initializes character labels and panel
    private void init(Character c) {
        name = new JLabel("Name: " + c.getName(), JLabel.CENTER);
        age = new JLabel("Age: " + Integer.toString(c.getAge()), JLabel.CENTER);
        gender = new JLabel("Gender: " + c.getGender(), JLabel.CENTER);
        bio = new JLabel("Bio: " + c.getBio(), JLabel.CENTER);
        rel = new JLabel("Family: " + c.listFamilyMembers(), JLabel.CENTER);
        textArea = new JTextArea();
        submit = new JButton("Submit Edit");
        panel.add(closePage());
        panel.add(name);
        panel.add(age);
        panel.add(gender);
        panel.add(bio);
        panel.add(rel);
        panel.add(textArea);
        panel.add(edit());
    }

    // MODIFIES: this
    // EFFECTS: edits character information according to the given command
    public JButton edit() {
        submit.addActionListener(e -> {
            String input = textArea.getText();
            if (input.startsWith("n/")) {
                chara.setName(input.substring(2));
            } else if (input.startsWith("a/")) {
                try {
                    chara.setAge(Integer.parseInt(input.substring(2)));
                } catch (Exception ex)  {
                    System.out.println("The input should be an int");
                }
            } else if (input.startsWith("g/")) {
                chara.setGender(input.substring(2));
            } else if (input.startsWith("b/")) {
                chara.setBio(input.substring(2));
            } 

            textArea.setText("");
            panel.removeAll();
            init(chara);
            gui.addLoad();
        });
        return submit;
    }

    // EFFECTS: returns closed
    public boolean getClosed() {
        return closed;
    }

}
