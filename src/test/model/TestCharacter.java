package model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCharacter {
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
    void construtorTest() {
        assertEquals("Mike", testChar.getName());
        assertEquals(0, testChar.getAge());
        assertEquals("", testChar.getBio());
        assertEquals("", testChar.getGender());
    }

    
    @Test
    void setterTest() {
        testChar.setName("Bob");
        assertEquals("Bob", testChar.getName());
        testChar.setAge(12);
        assertEquals(12, testChar.getAge());
        testChar.setGender("man");
        assertEquals("man", testChar.getGender());
        testChar.setBio("insert bio");
        assertEquals("insert bio", testChar.getBio());
    }


}
