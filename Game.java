/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.10
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room bedroom, stairs1, stairs2, stairs3, stairs4, stairs5, topfloor1, topfloor2, topfloor3, topfloor4,
        fourthfloor1, fourthfloor2, fourthfloor3, fourthfloor4, thirdfloor1, thirdfloor2, thirdfloor3, thirdfloor4,
        secondfloor1, secondfloor2, secondfloor3, secondfloor4, firstfloor1, firstfloor2, firstfloor3, firstfloor4,
        lobby1, lobby2, lobby3, lobby4, outside;
      
        // create the rooms
        topfloor1 = new Room("description");
        topfloor2 = new Room("description");
        topfloor3 = new Room("description");
        topfloor4 = new Room("description");
        
        bedroom = new Room("You wake up in an unfamiliar bedroom");
        
        stairs1 = new Room("in a stairwell");
        stairs2 = new Room("in a stairwell");
        stairs3 = new Room("in a stairwell");
        stairs4 = new Room("in a stairwell");
        stairs5 = new Room("in a stairwell");
        
        fourthfloor1 = new Room("description");
        fourthfloor2 = new Room("description");
        fourthfloor3 = new Room("description");
        fourthfloor4 = new Room("description");
        
        thirdfloor1 = new Room("description");
        thirdfloor2 = new Room("description");
        thirdfloor3 = new Room("description");
        thirdfloor4 = new Room("description");
        
        secondfloor1 = new Room("description");
        secondfloor2 = new Room("description");
        secondfloor3 = new Room("description");
        secondfloor4 = new Room("description");
        
        firstfloor1 = new Room("description");
        firstfloor2 = new Room("description");
        firstfloor3 = new Room("description");
        firstfloor4 = new Room("description");
        
        lobby1 = new Room("description");
        lobby2 = new Room("description");
        lobby3 = new Room("description");
        lobby4 = new Room("description");
        
        outside = new Room("description");
        
        // initialise room exits
        bedroom.setExit("south", topfloor1);
        
        topfloor1.setExit("south", topfloor2);
        topfloor1.setExit("east", topfloor4);
        topfloor1.setExit("north", bedroom);
        
        topfloor2.setExit("north", topfloor1);
        topfloor2.setExit("east", topfloor3);
        
        topfloor3.setExit("north", topfloor4);
        topfloor3.setExit("west", topfloor2);
        
        topfloor4.setExit("south", topfloor3);
        topfloor4.setExit("west", topfloor1);
        topfloor4.setExit("north", stairs1);
        
        stairs1.setExit("down", fourthfloor1);
        stairs1.setExit("up", topfloor4);
        
        fourthfloor1.setExit("south", fourthfloor2);
        fourthfloor1.setExit("east", fourthfloor4);
        fourthfloor1.setExit("north", stairs1);
        
        fourthfloor2.setExit("north", fourthfloor1);
        fourthfloor2.setExit("east", fourthfloor3);
        
        fourthfloor3.setExit("north", fourthfloor4);
        fourthfloor3.setExit("west", fourthfloor2);
        
        fourthfloor4.setExit("south", fourthfloor3);
        fourthfloor4.setExit("west", fourthfloor1);
        fourthfloor4.setExit("north", stairs2);
        
        stairs2.setExit("down", thirdfloor1);
        stairs2.setExit("up", fourthfloor4);

        thirdfloor1.setExit("south", thirdfloor2);
        thirdfloor1.setExit("east", thirdfloor4);
        thirdfloor1.setExit("north", stairs2);
        
        thirdfloor2.setExit("north", thirdfloor1);
        thirdfloor2.setExit("east", thirdfloor3);
        
        thirdfloor3.setExit("north", thirdfloor4);
        thirdfloor3.setExit("west", thirdfloor2);
        
        thirdfloor4.setExit("south", thirdfloor3);
        thirdfloor4.setExit("west", thirdfloor1);
        thirdfloor4.setExit("north", stairs3);
        
        stairs3.setExit("down", secondfloor1);
        stairs3.setExit("up", thirdfloor4);
        
        secondfloor1.setExit("south", secondfloor2);
        secondfloor1.setExit("east", secondfloor4);
        secondfloor1.setExit("north", stairs3);
        
        secondfloor2.setExit("north", secondfloor1);
        secondfloor2.setExit("east", secondfloor3);
        
        secondfloor3.setExit("north", secondfloor4);
        secondfloor3.setExit("west", secondfloor2);
        
        secondfloor4.setExit("south", secondfloor3);
        secondfloor4.setExit("west", secondfloor1);
        secondfloor4.setExit("north", stairs4);
        
        stairs4.setExit("down", firstfloor1);
        stairs4.setExit("up", secondfloor4);
        
        firstfloor1.setExit("south", firstfloor2);
        firstfloor1.setExit("east", firstfloor4);
        firstfloor1.setExit("north", stairs4);
        
        firstfloor2.setExit("north", firstfloor1);
        firstfloor2.setExit("east", firstfloor3);
        
        firstfloor3.setExit("north", firstfloor4);
        firstfloor3.setExit("west", firstfloor2);
        
        firstfloor4.setExit("south", firstfloor3);
        firstfloor4.setExit("west", firstfloor1);
        firstfloor4.setExit("north", stairs5);
        
        stairs5.setExit("down", lobby1);
        stairs5.setExit("up", firstfloor4);

        lobby1.setExit("south", lobby2);
        lobby1.setExit("east", lobby4);
        lobby1.setExit("north", stairs5);
        
        lobby2.setExit("north", lobby1);
        lobby2.setExit("east", lobby3);
        
        lobby3.setExit("north", lobby4);
        lobby3.setExit("west", lobby2);
        
        lobby4.setExit("south", lobby3);
        lobby4.setExit("west", lobby1);
        lobby4.setExit("north", outside);
        
        currentRoom = bedroom;  // start game bedroom
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
