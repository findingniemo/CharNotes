package persistence;

import model.Character;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Reference: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

@ExcludeFromJacocoGeneratedReport
public class JsonTest {
    protected void checkCharacter(String name, Character chara) {
        assertEquals(name, chara.getName());
        assertEquals(name, chara.toString());
    }
}
