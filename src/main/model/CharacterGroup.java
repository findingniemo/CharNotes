package model;

import java.util.ArrayList;
import java.util.List;

// Represents a character group (category/list) with a group name
public class CharacterGroup {
    private List<Character> charGroup;
    private String groupName;

    // EFFECTS: creates an empty character list/group
    public CharacterGroup(String groupName) {
        this.groupName = groupName;
        charGroup = new ArrayList<Character>();
    }

    // REQUIRES: characterNum >= 0 && newOrder >= 0 && list length >= 2 
    // MODIFIES: this
    // EFFECTS: changes the order of the character in the given position
    // to the new position.
    public void rearrange(int charNum, int newOrder){
        //stub
    }

    // MODIFIES: this
    // adds a character to the group
    public void addToGroup(Character chara) {
        // stub
    }

    // REQUIRES: a non-empty list
    // EFFECT: Finds the place/order number of a character on the list and returns it
    public int findChar(Character chara){
        return 0;
    }

    public ArrayList<Character> getGroup() {
        return null;
    }

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }
}
