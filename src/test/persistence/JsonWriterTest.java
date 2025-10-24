package persistence;

import model.Character;
import model.CharacterGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
class JsonWriterTest extends JsonTest {

    private Character c1;
    private Character c2;
    private List<String> fam;
    private List<String> fam1;

    @BeforeEach
    void runBefore() {
        c1 = new Character("Nat");
        c2 = new Character("Alas");
        fam = new ArrayList<String>();
        fam1 = new ArrayList<String>();
        fam.add("Alas");
        fam1.add("Nat");
        c1.setAge(24);
        c2.setAge(17);
        c1.setGender("woman");
        c2.setGender("man");
        c1.setBio("a supernatural hunter");
        c2.setBio("annoying child"); 
        c1.setFamily(fam);
        c2.setFamily(fam1);
    }
    
    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCharacterGroup() {
        try {
            CharacterGroup cg = new CharacterGroup("characters");
            JsonWriter writer = new JsonWriter("src\\data\\testWriterEmptyCharacterGroup.json");
            writer.open();
            writer.write(cg);
            writer.close();

            JsonReader reader = new JsonReader("src\\data\\testWriterEmptyCharacterGroup.json");
            cg = reader.read();
            assertEquals("characters", cg.getGroupName());
            assertEquals(0, cg.getGroup().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralCharacterGroup() {

        try {
            CharacterGroup cg = new CharacterGroup("General");
            cg.addToGroup(c1);
            cg.addToGroup(c2);
            JsonWriter writer = new JsonWriter("src\\data\\testWriterGeneralCharacterGroup.json");
            writer.open();
            writer.write(cg);
            writer.close();

            JsonReader reader = new JsonReader("src\\data\\testWriterGeneralCharacterGroup.json");
            cg = reader.read();
            assertEquals("General", cg.getGroupName());
            List<Character> group = cg.getGroup();
            assertEquals(2, group.size());
            checkCharacter("Nat", 24, "woman", "a supernatural hunter", fam,  cg.getGroup().get(0));
            checkCharacter("Alas", 17, "man", "annoying child", fam1, cg.getGroup().get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}