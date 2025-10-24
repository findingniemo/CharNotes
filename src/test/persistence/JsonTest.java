package persistence;

import model.Character;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class JsonTest {
    protected void checkCharacter(String name, int age, String gender, String bio, List family, Character chara) {
        assertEquals(name, chara.getName());
        assertEquals(age, chara.getAge());
        assertEquals(gender, chara.getGender());
        assertEquals(bio, chara.getBio());
        assertEquals(family, chara.getFamily());
    }
}
