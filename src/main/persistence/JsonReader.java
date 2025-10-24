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
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads character group from file and returns it;
    // throws IOException if an error occurs reading data from file
    public CharacterGroup read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCharacterGroup(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses character group from JSON object and returns it
    private CharacterGroup parseCharacterGroup(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        CharacterGroup cg = new CharacterGroup(name);
        addCharacters(cg, jsonObject);
        return cg;
    }

    // MODIFIES: cg
    // EFFECTS: parses characters from JSON object and adds them to character group
    private void addCharacters(CharacterGroup cg, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("characters");
        for (Object json : jsonArray) {
            JSONObject nextCharacter = (JSONObject) json;
            addCharacter(cg, nextCharacter);
        }
    }

    // MODIFIES: cg
    // EFFECTS: parses character from JSON object and adds it to character group
    private void addCharacter(CharacterGroup cg, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");
        String gender = jsonObject.getString("gender");
        String bio = jsonObject.getString("bio");
        Character chara = new model.Character(name);
        chara.setAge(age);
        chara.setGender(gender);
        chara.setBio(bio);
        cg.addToGroup (chara);
    }
}
