package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

import model.Character;
import model.CharacterGroup;

// Represents a reader that reads character group from JSON data stored in file
public class JsonReader {

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
    }

    // EFFECTS: reads character group from file and returns it;
    // throws IOException if an error occurs reading data from file
    public CharacterGroup read() throws IOException {
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return null;
    }

    // EFFECTS: parses character group from JSON object and returns it
    private CharacterGroup parseCharacterGroup(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: cg
    // EFFECTS: parses characters from JSON object and adds them to character group
    private void addCharacters(CharacterGroup cg, JSONObject jsonObject) {
    }

    // MODIFIES: cg
    // EFFECTS: parses character from JSON object and adds it to character group
    private void addCharacter(CharacterGroup cg, JSONObject jsonObject) {
    }
}
