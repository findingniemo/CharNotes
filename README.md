# CharNotes

## An application with everything you need to keep track of your characters and the universe their story is set in

CharNotes is here to keep track of all your characters and their details. In CharNotes, you will be able to categorize characters based on the universe/story they are in, create relationship and family trees for them and add silly icons for them using the built-in character creator.

This application is for authors, storywriters or anyone who likes to write character stories and is looking for a noting app specifically designed for it. 

I wanted to work on this project because I occasionally like to write character stories and as someone who has *a lot* of them, having an application specifically desgined to organize them would make it a lot easier for me. 

Of course, you might ask: "Why not use a regular noting app?". Regular note apps do not provide features specifically made for character relationships and worlbuilding details. I wanted to provide features which make it easier for authors to compile all information needed for their story. Plus, this application will have some fun features! 

## User Stories
### The 4 (technically 5) for Phase 1:
- I want to be able to add a character to my list of characters and specify their name and later add their age, gender, ethnicity etc. (all necessary character details) and their biography.
- I want to be able to select a character and view their details.
- I want to be able to see the names of all characters in the general character list (displayed on the main scren)
- I want to be able to make changes to character details.
- I want to be able to change the order of my characters in the characters list, based on which character I am prioritizing at the time.

### Phase 2:
- I want to be able to manually save all my characters to file.
- I want to be able to reload all my characters from file.


### Plans For The Near Future:
- I want to be able to categorize my characters based on the story they are in or based on character tags I add myself.
- I want to be able to bookmark characters of my choosing and have a shortcut to them.
- I want to be able to remove characters and revive the ones I accidentally deleted (from some sort of recycle bin) **SEMI-IMPLEMENTED**

### Future Future Plans
- When I cannot come up with a name, I want to be able to randomize character names based on ethnicity/genre.
- I want to be able to draw simple relationship trees for my characters.
- I want to be able to make small character icons for my characters.

## Instructions for End User
- You can view the panel that displays the characters by simply launching the app. The characters will appear on the main screen as you add them
- You can add characters to the general character list found on the main page by typing their name in the text box and clicking "Add New Character"
- You can remove a character from the general character list found on the main page by clicking the "X" button next to the character you would like to remove
- You can view the details of a character in the main list by clicking the "View" button next to their name. 
- You can edit a character's information by using the text field on their character page with these commandsd and pressing "Submit Edit":
  - n/"new name*
  - a/*new age*
  - g/*new gender*
  - b/*new bio*

  IMPORTANT: Don't add any spaces after the commands. The command format is eg. n/Mike. Also, the a/ command only accepts integers.
- You can locate the visual component once you add a new character. A placeholder character icon will appear next to the character's name.
- You can save the state of the application by pressing the "Save" button
- You can reload the state of the application by pressing the "Load" button. 

## "Phase 4: Task 2"
- Welcome to CharNotes!
- Fri Nov 28 00:18:24 PST 2025
Added new character: Jim
- Fri Nov 28 00:18:32 PST 2025
Changed Jim's name to: Bob
- Fri Nov 28 00:18:35 PST 2025
Changed Bob's age to: 7
- Fri Nov 28 00:18:39 PST 2025
Changed Bob's gender to m
- Fri Nov 28 00:18:50 PST 2025
Changed Bob's bio to placeholder
- Fri Nov 28 00:18:55 PST 2025
Added new character: Mike
- Fri Nov 28 00:18:59 PST 2025
Added new character: Jill
- Fri Nov 28 00:19:01 PST 2025
Removed character Mike
- Fri Nov 28 00:19:04 PST 2025
Removed character Bob
- Fri Nov 28 00:19:05 PST 2025
Removed character Jill

## "Phase 4: Task 3"
- The first thing that comes to my mind is a really simple one: changing the character age field in model.Character class from int to String. There are multiple instances where we print/edit this variable and I have to convert Strings into ints and vice-versa. I also have to control the case when a a user DOES enter a String. The app currenly does not have a function that makes use of age values, and I'm not sure if it will ever have one, so keeping the age as a String makes programming easier. I suppose it also increases the readability and let's users have more freedom (eg. age : "infinitely old").
- I can change the charGroup field in model.CharacterGroup class into a Map instead of an array list and overwrite equals and hashcode. All characters having their own ids might help me implement future methods for cases where there are multiple characters with the same name. 
- Based on the UML diagram, there are way too many dependencies/associations. I would try to decrease that. If I change one thing in one class, I will have to change that thing in all the other classes, which is tedious and unefficient.
  - I am not creating multiple instances of CharacterGroup in the current version of my app, therefore I can also change CharacterGroup so that it implements Iterable<Character>. That way, there will be less dependency/association with CharacterGroup. I can also use for loops directly on ChracterGroup that way.
- If I decide to add different kinds of character groups (eg. recycle bin, categorized character groups), I can turn the CharacterGroup class into an abstract class. That would decrease method repetition in classes which extend it. 