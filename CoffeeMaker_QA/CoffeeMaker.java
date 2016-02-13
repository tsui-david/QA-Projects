import static org.junit.Assert.*;

import java.util.Scanner;
import org.junit.*;
import org.mockito.*;

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
	
	
	

	
	
	public static boolean [] lookForItems (Room currentRoom, boolean [] haveItems) {
		
		//Note that in the haveItems array, 
		//hasCream = haveItems[0], hasCoffee = haveItems[1], and hasSugar = haveItems[2]
	
		Item roomObj = currentRoom.getItem();
		String name = roomObj.getName();
		
		if (name.equals("Nothing")) {
		    	System.out.println("You don't see anything out of the ordinary.");
		}
		
	   	else {
	   	
		    System.out.println("There might be something here...");
		    
		    if (name.equals("Cream"))  {
		    	System.out.println("You found some creamy cream!");
		    	haveItems[0] = true;
		    }
	
		    else if (name.equals("Coffee")) {
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
		
		System.out.println();
		
		while(true) {
		
			Room currentRoom = rooms[room_index];
			
			currentRoom.printRoomInfo(currentRoom);
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
		    	currentRoom.printInventory(haveItems);
		    else if (input.equals("D")) {
		    	currentRoom.drink(haveItems);
		    	System.out.println(currentRoom.getTestStatus());
		    	if (!currentRoom.getTestStatus())
		    		System.exit(0);
		    }
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
