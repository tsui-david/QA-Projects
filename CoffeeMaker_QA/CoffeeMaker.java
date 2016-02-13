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
	
	public static String readInput() {
		Scanner sc = new Scanner(System.in);
		return sc.next().toUpperCase();
	}
		
	private static void playGame(Room [] rooms) {
		
		Room currentRoom = rooms[0];
		
		System.out.println();
		
		while(true) {
		
			currentRoom.printRoomInfo();
			Room.printInstructions();
			String input = readInput();
			
			
		    if (input.equals("N")) 
		    	if (currentRoom.moveNorth() != null)  {
		    		//System.out.println(55);
		    		currentRoom = currentRoom.moveNorth();  
		    	}
		    	else 
		    		System.out.println(44);
		    else if (input.equals("S")) 
		    	if (currentRoom.moveSouth() != null) {
		    		//System.out.println(33);
		    		currentRoom = currentRoom.moveSouth();
		    		
		    	}
		    	else {
		    		//System.out.println(22);
		    	}
		    else if (input.equals("L")) 
		    	currentRoom.lookForItems();
		    else if (input.equals("H")) 
		    	Room.printHelpMenu();
		    else if (input.equals("I")) {
		    	currentRoom.printInventory();
		    }
		    else if (input.equals("D")) {
		    	currentRoom.drink();
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
