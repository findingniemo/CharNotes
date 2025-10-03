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

    // REQUIRES: characterNum >= 0 && newOrder >= 0
    // MODIFIES: this
    // EFFECTS: changes the order of the character in the given position
    // to the new position.
    public void rearrange(int charNum, int newOrder){
        //stub
    }

    // REQUIRES: a non-empty list
    
    public int findChar(Character chara){
        return 0;
    }
}
