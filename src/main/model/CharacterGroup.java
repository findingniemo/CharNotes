package model;

import java.util.ArrayList;
import java.util.List;

// Represents a character group (category/list) with a group name
public class CharacterGroup {
    private List<Character> charGroup;
    private String groupName;

    // EFFECTS: creates an empty character list/group with the given name
    public CharacterGroup(String groupName) {
        this.groupName = groupName;
        charGroup = new ArrayList<Character>();
    }

    // REQUIRES: characterNum >= 0 && newOrder >= 0 && list length >= 2 
    // MODIFIES: this
    // EFFECTS: changes the order of given characters
    public void rearrange(Character char1, Character char2){
        // int i = 0;
        // int posChar1 = charGroup.findChar(char1);

        // while (i <= size.groupName || ) {
            
        // }

        // charGroup.remove(char1);
        // charGroup.remove(char2);

    }

    // MODIFIES: this
    // adds a character to the group
    public void addToGroup(Character chara) {
        charGroup.add(chara);
    }

    // REQUIRES: a non-empty list
    // EFFECT: Finds the place/order number of a character on the list and returns it
    public int findChar(Character chara){
       
     int i = 0;
        
        while (!chara.equals(charGroup.get(i))) {
            i ++;
        }

        return i;
    }

    public List<Character> getGroup(){
        return charGroup;
    }

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    // EFFECTS: Produces a string with all character names 
    public String listMembers() {
        String str = "";

        for(Character next: charGroup){
            str = str + next.getName() + " ";
        }
    
        return str;
    }
}
