package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCharacterGroup {

    private CharacterGroup testGroup;
    private Character mike;
    private Character bob;
    private Character bill;
    
    @BeforeEach
    void runBefore() {
        testGroup = new CharacterGroup("general");
        mike = new Character("Mike");
        bob = new Character("Bob");
        bill = new Character("Bill");
    }

    @Test
    void construtorTest() {
        assertEquals("general", testGroup.getGroupName());
    }

    @Test
    void setGroupNameTest() {
        testGroup.setGroupName("Burgers");
        assertEquals("Burgers", testGroup.getGroupName());
    }

    @Test
    void rearrangeTwoPeopleTest() {
        testGroup.addToGroup(mike);
        testGroup.addToGroup(bob);
        testGroup.rearrange(0, 1);
        List<Character> a = testGroup.getGroup();
        assertEquals(mike, a.get(1));
        assertEquals(bob, a.get(0));
    }

    @Test
    void rearrangeMorePeopleTest() {
        testGroup.addToGroup(mike);
        testGroup.addToGroup(bob);
        testGroup.addToGroup(bill);
        testGroup.rearrange(0, 1);
        List<Character> a = testGroup.getGroup();
        assertEquals(mike, a.get(1));
        assertEquals(bob, a.get(0));
        assertEquals(bill, a.get(2));
        testGroup.rearrange(0, 2);
        List<Character> b = testGroup.getGroup();
        assertEquals(mike, b.get(0));
        assertEquals(bob, b.get(2));
        assertEquals(bill, b.get(1));
    }

    @Test
    void findCharTest() {
        testGroup.addToGroup(bill);
        testGroup.addToGroup(bob);
        testGroup.addToGroup(mike);
        assertEquals(0, testGroup.findChar(bill));
        assertEquals(1, testGroup.findChar(bob));
        assertEquals(2, testGroup.findChar(mike));
    }
}
