package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        testChar.setAge(10);
        testChar.setBio("random");
        testChar.setName(name);
        testChar.setGender("m");
        assertEquals("Bill", testChar.getName());
        assertEquals(10, testChar.getAge());
        assertEquals("random", testChar.getBio());
        assertEquals("m", testChar.getGender());
    }

}
