package persistence;

import model.Character;
import model.CharacterGroup;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            CharacterGroup cg = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCharacterGroup() {
        JsonReader reader = new JsonReader("src\\data\\testReaderEmptyCharacterGroup.json");
        try {
            CharacterGroup cg = reader.read();
            assertEquals("My Characters", cg.getGroupName());
            assertEquals(0, cg.getGroup().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCharacterGroup() {
        JsonReader reader = new JsonReader("src\\data\\testReaderGeneralCharacterGroup.json");
        try {
            CharacterGroup cg = reader.read();
            assertEquals("General", cg.getGroupName());
            List<Character> group = cg.getGroup();
            assertEquals(2, group.size());
            checkCharacter("Nat", 24, "woman", "a supernatural hunter", group.get(0));
            checkCharacter("Alas", 17, "man", "annoying child", group.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}