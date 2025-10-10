package model;

// Represents a character with a name, age, gender, biography and bookmark
// status.
public class Character {
    private String name;
    private String gender;
    private String bio;
    private int age;
    private boolean bmark;

    // EFFECTS: the name of the character is set to the name
    // entered. The character has age 0, no biograpy, no gender and
    // they aren't bookmarked.
    public Character(String name) {
        this.name = name;
        age = 0;
        bio = "";
        gender = "";
        bmark = false;
    }

    // MODIFIES: this
    // EFFECTS: sets character name to entered name
    public void setName(String name) {
        this.name = name;
    }

    // REQUIRES: entered age >= 0
    // MODIFIES: this
    // EFFECTS: sets character age to entered age
    public void setAge(int age) {
        this.age = age;
    }

    // MODIFIES: this
    // EFFECTS: sets character bio to entered bio
    public void setBio(String bio) {
        this.bio = bio;
    }

    // MODIFIES: this
    // EFFECTS: sets character gender to entered gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBio() {
        return bio;
    }

    public String getGender() {
        return gender;
    }

}
