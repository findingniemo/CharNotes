package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    private Character testChar;
    private String name;
    private String name1;
    
    @BeforeEach
    void runBefore() {
        testChar = new Character("Mike");
        name = "Bill";
        name1 = "Mike";
    }

    @Test
    void testConstrutor() {
        assertEquals("Mike", testChar.getName());
        testChar.setAge(10);
        testChar.setBio("random");
        testChar.setName(name);
        testChar.setGender("m");
        assertEquals("Bill", testChar.getName());
        assertEquals(10, testChar.getAge());
        assertEquals("random", testChar.getBio());
        assertEquals("m", testChar.getGender());
        assertFalse(testChar.getBookMark());
    }

    @Test
    void testChangeBmark() {
        testChar.changeBmark();
        assertTrue(testChar.getBookMark());
        testChar.changeBmark();
        assertFalse(testChar.getBookMark());
    }

}
