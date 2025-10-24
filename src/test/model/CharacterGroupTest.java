package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

public class CharacterGroupTest {

    private CharacterGroup testGroup;
    private Character mike;
    private Character bob;
    private Character bill;
    private ArrayList<Character> expectedList;

    @BeforeEach
    void runBefore() {
        testGroup = new CharacterGroup("general");
        mike = new Character("Mike");
        bob = new Character("Bob");
        bill = new Character("Bill");
        expectedList = new ArrayList<>();
    }

    @Test
    void testConstrutor() {
        assertEquals("general", testGroup.getGroupName());
        testGroup.setGroupName("Burgers");
        assertEquals("Burgers", testGroup.getGroupName());
        assertEquals(expectedList, testGroup.getGroup());
        ;
    }

    @Test
    void testRearrangeTwoPeople() {
        testGroup.addToGroup(mike);
        testGroup.addToGroup(bob);
        testGroup.rearrange(0, 1);
        List<Character> a = testGroup.getGroup();
        assertEquals(mike, a.get(1));
        assertEquals(bob, a.get(0));
    }

    @Test
    void testRearrangeMorePeople() {
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
    void testRearrangeSamePeople() {
        testGroup.addToGroup(mike);
        testGroup.addToGroup(bob);
        testGroup.rearrange(0, 0);
        List<Character> a = testGroup.getGroup();
        assertEquals(mike, a.get(0));
        assertEquals(bob, a.get(1));
    }

    @Test
    void testRearrangePeopleGreaterCharNum() {
        testGroup.addToGroup(mike);
        testGroup.addToGroup(bob);
        testGroup.addToGroup(bill);
        testGroup.rearrange(1, 0);
        List<Character> a = testGroup.getGroup();
        assertEquals(mike, a.get(1));
        assertEquals(bob, a.get(0));
        assertEquals(bill, a.get(2));
    }

    @Test
    void testListMembers() {
        testGroup.addToGroup(bill);
        testGroup.addToGroup(bob);
        testGroup.addToGroup(mike);
        assertEquals("Bill Bob Mike ", testGroup.listMembers());

    }

    @Test
    void testFindChar() {
        testGroup.addToGroup(bill);
        testGroup.addToGroup(bob);
        testGroup.addToGroup(mike);
        assertEquals(0, testGroup.findChar(bill));
        assertEquals(1, testGroup.findChar(bob));
        assertEquals(2, testGroup.findChar(mike));
    }

    @Test
    void ListMemberNumbers() {
        testGroup.addToGroup(bill);
        testGroup.addToGroup(bob);
        testGroup.addToGroup(mike);
        assertEquals("0    1   2    ", testGroup.listMemberNumbers());
    }
}
