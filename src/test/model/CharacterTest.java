package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    private Character testChar;
    private Character extra;
    private String name;
    
    @BeforeEach
    void runBefore() {
        testChar = new Character("Mike");
        extra = new Character("Bob");
        name = "Bill";
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

    @Test
    void testAddFamily() {
        testChar.addFamily(extra);
        assertEquals(extra, testChar.getFamily().getGroup().get(0));
    }

    @Test
    void testIsRelated() {
        testChar.addFamily(extra);
        assertTrue(testChar.isRelated(extra));
        assertFalse(testChar.isRelated(new Character("Billy")));
    }

    @Test
    void testListFamilyMembers() {
        testChar.addFamily(extra);
        assertEquals("Bob ", testChar.listFamilyMembers());
    }

}
