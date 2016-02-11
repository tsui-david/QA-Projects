import java.util.Scanner;

public class CoffeeMaker {
	
	public static void main(String[] args) {
	
		String [] north_door_description = {"Magenta", "Beige", "Dead", "Vivacious", "Purple"};
		String [] south_door_description = {"Massive", "Smart", "Slim", "Sandy", "Minimalist"};
		String [] room_items = {"Cream", "Nothing", "Coffee", "Nothing", "Nothing", "Sugar"};
		String [] furnishing = {"Quaint Sofa", "Sad record player", "Tight pizza", "Flat energy drink",
				"Beautiful bag of money", "Perfect air hockey table"
		};
		String [] room_description = {"Small","Funny","Refinanced","Dumb","Bloodthirsty","Rough"};
		Room [] rooms = new Room[room_description.length];
		
		setup(rooms, north_door_description, south_door_description, room_items, furnishing, room_description);
		
		playGame(rooms);
				
	}
	
	
	
	private static void printInstructions() {
		System.out.println("\nINSTRUCTIONS (N,S,L,I,D,H)>");
	}
	
	public static String readInput() {
		Scanner sc = new Scanner(System.in);
		return sc.next().toUpperCase();
	}
	
	public static void printRoomInfo(Room currentRoomentRoom) {
	
		System.out.println("You see a " + currentRoomentRoom.description + " room.");
		System.out.println("It has a " + currentRoomentRoom.furnishing + ".");
			
		if (currentRoomentRoom.getNorth_room() != null) 
			System.out.println("A "+ currentRoomentRoom.getNorth_room_door_description() + " door leads North.");
		if (currentRoomentRoom.getSouth_room() != null) 
			System.out.println("A "+ currentRoomentRoom.getSouth_room_door_description() + " door leads South.");
	}
	
	public static int moveNorth(Room currentRoom, int room_index) {
		
		if (currentRoom.getNorth_room() == null) {
			System.out.println("There is no door leading north.\n");
			return room_index;
		}
		else 
			return room_index + 1;
	}
	
	public static int moveSouth(Room currentRoom, int room_index) {
		
		if (currentRoom.getSouth_room() == null) {
			System.out.println("There is no door leading south.\n");
			return room_index;
		}
		else 
			return room_index - 1;
	}
	
	public static void drink(boolean [] haveItems) {
		
		printInventory(haveItems);
		
		boolean hasCream = haveItems[0];
		boolean hasCoffee = haveItems[1];
		boolean hasSugar = haveItems[2];
		
		if (hasCream && hasCoffee && hasSugar) {
		    System.out.println("You drink the beverage and are ready to study!");
			System.out.println("You win!");
		}
		else if (hasCream && hasSugar) {
		    System.out.println("You drink the sweetened cream, but without caffeine, you cannot study.");
		    System.out.println("You lose!");
		}
		else if (hasCoffee && hasSugar) {
		    System.out.println("Without cream, you get an ulcer and cannot study.");
			System.out.println("You lose!");
		}
		else if (hasCream && hasCoffee) {
		    System.out.println("Without sugar, the coffee is too bitter. You cannot study.");
			System.out.println("You lose!");
		}
		else if (hasCream) {
		    System.out.println("You drink the cream, but without caffeine, you cannot study.");
			System.out.println("You lose!");
		}
		else if (hasCoffee) {
		    System.out.println("Without cream, you get an ulcer and cannot study.");
			System.out.println("You lose!");
		}
		else if (hasSugar) {
		    System.out.println("You eat the sugar, but without caffeine, you cannot study!");
			System.out.println("You lose!");
		}
		else {
		    System.out.println("You drink the air, as you have no coffee, sugar, or cream.");
		    System.out.println("The air is invigorating, but not invigorating enough. You cannot study.");
		    System.out.println("You lose!");
		}
		    
		System.exit(0);
	}
	
	public static void printInventory(boolean [] haveItems) {
	
		boolean hasCream = haveItems[0];
		boolean hasCoffee = haveItems[1];
		boolean hasSugar = haveItems[2];
		
		if (hasCoffee) 
			System.out.println("You have a cup of delicious coffee.");
		else 
			System.out.println("YOU HAVE NO COFFEE!");
	
		if (hasCream) 
			System.out.println("You have some fresh cream.");
		else 
			System.out.println("YOU HAVE NO CREAM!");
		    	
		if (hasSugar) 
			System.out.println("You have some tasty sugar.");
		else 
			System.out.println("YOU HAVE NO SUGAR!");
			
		System.out.println();
	}
	
	public static boolean [] lookForItems (Room currentRoom, boolean [] haveItems) {
		
		//Note that in the haveItems array, 
		//hasCream = haveItems[0], hasCoffee = haveItems[1], and hasSugar = haveItems[2]
	
		if (currentRoom.getItem().equals("Nothing")) {
		    	System.out.println("You don't see anything out of the ordinary.");
		}
		
	   	else {
	   	
		    System.out.println("There might be something here...");
		    
		    if (currentRoom.getItem().equals("Cream"))  {
		    	System.out.println("You found some creamy cream!");
		    	haveItems[0] = true;
		    }
	
		    else if (currentRoom.getItem().equals("Coffee")) {
		    	System.out.println("You found some caffeinated coffee.");
		    	haveItems[1] = true;
		    }
		    
		    else { 
		    	System.out.println("You found some sweet sugar!");
		    	haveItems[2] = true;
		    }
		}
		
		System.out.println();
		
		return haveItems;
	}
	
	public static void printHelpMenu() {
	
		System.out.println("Commands to play the game (case-insensitive): ");
		System.out.println("---------------------------");
		System.out.println("Enter \"N\" to go north.");
		System.out.println("Enter \"S\" to go south.");
		System.out.println("Enter \"L\" to look for items in the room.");
		System.out.println("Enter \"I\" to check your inventory.");
		System.out.println("Enter \"H\" to see the help menu again.");
		System.out.println("Enter \"D\" to drink.");
		System.out.println();
	}
	
	private static void playGame(Room [] rooms) {
		
		int room_index = 0;
		
		boolean hasCream = false;
		boolean hasCoffee = false; 
		boolean hasSugar = false;
		boolean [] haveItems = {hasCream, hasCoffee, hasSugar};
		
		String [] items = {"Coffee", "Cream", "Sugar"};
		System.out.println();
		
		while(true) {
		
			Room currentRoom = rooms[room_index];
			
			printRoomInfo(currentRoom);
			printInstructions();
			String input = readInput();
			System.out.println();
		    
		    if (input.equals("N")) 
		    	room_index = moveNorth(currentRoom, room_index);
		    else if (input.equals("S")) 
		    	room_index = moveSouth(currentRoom, room_index);
		    else if (input.equals("L")) 
		    	haveItems = lookForItems(currentRoom, haveItems);
		    else if (input.equals("H")) 
		    	printHelpMenu();
		    else if (input.equals("I")) 
		    	printInventory(haveItems);
		    else if (input.equals("D")) 
		    	drink(haveItems);
		    else 
		    	System.out.println("What?\n");
		
		}
	}
	
	private static void setup (Room [] rooms, String [] north_door_description, 
	String [] south_door_description, String [] room_items, String [] furnishing, String [] room_description) {
		
		//Initialize rooms
		for(int i=0; i<rooms.length; i++) {
			rooms[i] = new Room();
		}
		
		//Set rooms with data
		for(int i=0; i<rooms.length; i++) {
		
			rooms[i].setDescription(room_description[i]);
			rooms[i].setFurnishing(furnishing[i]);
			rooms[i].setItem(room_items[i]);
			
			//Set south room
			if (i > 0) 
				rooms[i].setSouth_room(rooms[i-1], south_door_description[i-1]);
				
			//Set north room
			if (i < rooms.length-1) 
				rooms[i].setNorth_room(rooms[i+1], north_door_description[i]);
			
		}	
	}
}
