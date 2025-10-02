package model;

// Represents a character with a name, age, gender, biography.
public class Character {
    private String name;
    private String gender;
    private String bio;
    private int age;

    // EFFECTS: the name of the character is set to the name
    // entered. The character has no age (represented with -1),
    // no biograpy and no gender.
    public Character(String name) {
        this.name = name;
        age = -1;
        bio = "";
        gender = "";
    }

    // MODIFIES: this
    // EFFECTS: sets character name to entered name
    public void setName(String name){
         //stub
    }

    // MODIFIES: this
    // EFFECTS: sets character age to entered age
    public void setAge(int age){
         //stub
    }

    // MODIFIES: this
    // EFFECTS: sets character bio to entered bio
    public void setBio(String bio){
         //stub
    }

    // MODIFIES: this
    // EFFECTS: sets character gender to entered gender
    public void setGender(String gender){
         //stub
    }

    public String getName(){
        return null; //stub
    }

    public int getAge(){
        return 0; //stub
    }

    public String getBio(){
        return null; //stub
    }

    public String getGender(){
        return null; //stub
    }

}
