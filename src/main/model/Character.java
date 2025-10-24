package model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// Represents a character with a name, age, gender, biography and bookmark
// status.
public class Character implements Writable {
    private String name;
    private String gender;
    private String bio;
    private int age;
    private boolean bmark;
    private List<String> family;

    // EFFECTS: the name of the character is set to the name
    // entered. The character has age 0, no biograpy, no gender and
    // they aren't bookmarked and have no family members.
    public Character(String name) {
        this.name = name;
        age = 0;
        bio = "";
        gender = "";
        bmark = false;
        family = new ArrayList<>();
    }

    // EFFECTS: produces a JsonObject for this character
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        JSONArray jsonAr = new JSONArray(family);
        json.put("name", name);
        json.put("age", age);
        json.put("gender", gender);
        json.put("bio", bio);
        json.put("family", jsonAr);
        return json;
    }

    // METHOD DEFINITON COMMENTED OUT BEECUASE IT IS NOT BEING USED
    // // EFFECTS: produces true if two characters are related
    // public boolean isRelated(Character chara) {
    // boolean related = false;
    // for (Character next : family.getGroup()) {
    // if (chara == next) {
    // related = true;
    // }
    // }
    // return related;
    // }

    // EFFECTS: produces all family members as a string
    public String listFamilyMembers() {
        String str = "";

        for (String next : family) {
            str = str + next + " ";
        }

        return str;
    }

    // MODIFIES: this & chara
    // EFFECTS: adds character to family if character isn't already there
    // also adds this character to the other character's family
    public void addFamily(Character chara) {
        String charaName = chara.getName();
        if (!family.contains(charaName)) {
            family.add(charaName);
            List<String> otherSide = chara.getFamily();
            otherSide.add(this.name);
        }
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

    // MODIFIES: this
    // EFFECTS: sets character family to given family
    public void setFamily(List family) {
        this.family = family;
    }

    // MODIFIES: this
    // EFFECTS: sets bookmarked status to true if false, and false if true
    public void changeBmark() {
        bmark = !bmark;
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

    public boolean getBookMark() {
        return bmark;
    }

    public List getFamily() {
        return family;
    }

}
