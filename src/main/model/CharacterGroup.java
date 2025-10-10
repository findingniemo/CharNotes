package model;

import java.util.ArrayList;
import java.util.List;

// Represents a character group (category/list) with a group name
public class CharacterGroup {
    private ArrayList<Character> charGroup;
    private String groupName;

    // EFFECTS: creates an empty character list/group with the given name
    public CharacterGroup(String groupName) {
        this.groupName = groupName;
        charGroup = new ArrayList<Character>();
    }

    // REQUIRES: characterNum >= 0 && newOrder >= 0 && list length >= 2 
    // MODIFIES: this
    // EFFECTS: changes the order of given characters
    public void rearrange(int charNum, int newOrder){
        int i = 0;
        Character char1 = charGroup.get(charNum);
        Character char2 = charGroup.get(newOrder);

        while (i <= charGroup.size()) {
            if (charNum < newOrder) {
                
            } else if (charNum > newOrder) {

            } else {}

            i ++;
        }

        charGroup.remove(char1);
        charGroup.remove(char2);

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
