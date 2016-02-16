import java.util.Scanner;

public class CoffeeMaker2 {
	
	private String [] north_door_description = {"Magenta", "Beige", "Dead", "Vivacious", "Purple"};
	private String [] south_door_description = {"Massive", "Smart", "Slim", "Sandy", "Minimalist"};
	private String [] room_items = {"Cream", "Nothing", "Coffee", "Nothing", "Nothing", "Sugar"};
	private String [] furnishing = {"Quaint Sofa", "Sad record player", "Tight pizza", "Flat energy drink",
			"Beautiful bag of money", "Perfect air hockey table"
	};
	private String [] room_description = {"Small","Funny","Refinanced","Dumb","Bloodthirsty","Rough"};
	private Room [] rooms = new Room[room_description.length];
	
	private Room currentRoom;
	public static void main(String[] args) {
	
		CoffeeMaker2 game = new CoffeeMaker2();
		if(game.setupCoffeeGame()){
			;
		}
		else {
			System.exit(0);
		}
	
		boolean gameState = true;
		
		while(gameState) {
		
			game.getCurrentRoom().printRoomInfo();
			String input = game.readInput();
			
			game.acceptCommands(input);
		}
		System.exit(0);
	}
	
	private boolean setupCoffeeGame() {
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
		currentRoom = rooms[0];
		return true;
	}
	public  String readInput() {
		Scanner sc = new Scanner(System.in);
		return sc.next().toUpperCase();
	}
	public Room getCurrentRoom() {
		return currentRoom;
	}
	//Accept commands N, S, L, H, I, D
	public boolean acceptCommands(String command) {
		if(currentRoom!=null) {
			if (command.equals("N")) {
				if(currentRoom.moveNorth() != null)
					currentRoom = currentRoom.moveNorth();
				return true;
			}
			
			else if (command.equals("S")) {
				if(currentRoom.moveSouth() != null)
					currentRoom = currentRoom.moveNorth();
				return true;
			}
			
			else if (command.equals("L")) {
				currentRoom.lookForItems();
				return true;
			}
			
			else if (command.equals("H")) {
				Room.printHelpMenu();
				return true;
			}
			
			else if (command.equals("I")) {
				currentRoom.printInventory();
				return true;
			}
			
			else if (command.equals("D")) {
				currentRoom.drink();
				return false;
			}
			
			else {
				System.out.println("What?\n");
				return true;
			}
			
		}
		return false;
	}
	
}