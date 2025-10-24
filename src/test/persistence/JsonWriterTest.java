package persistence;

import model.Character;
import model.CharacterGroup;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
class JsonWriterTest extends JsonTest {

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
        Character c1 = new Character("Nat");
        Character c2 = new Character("Alas");
        c1.setAge(24);
        c2.setAge(17);
        c1.setGender("woman");
        c2.setGender("man");
        c1.setBio("a supernatural hunter");
        c2.setBio("annoying child"); 

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
            List<Character> thingies = cg.getGroup();
            assertEquals(2, cg.getGroup().size());
            checkCharacter("Nat", 24, "woman", "a supernatural hunter", cg.getGroup().get(0));
            checkCharacter("Alas", 17, "man", "annoying child", cg.getGroup().get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}