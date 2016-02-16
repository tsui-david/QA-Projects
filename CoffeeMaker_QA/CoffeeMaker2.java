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
	
		String gameState = "";
		
		while(gameState!=null) {
		
			game.getCurrentRoom().printRoomInfo();
			game.getCurrentRoom().printInstructions();
			String input = game.readInput();
			
			gameState = game.acceptCommands(input);
		}
		System.exit(0);
	}

	public Room[] getRooms() {
		return rooms;
	}
	public boolean setupCoffeeGame() {
		//Initialize rooms
		for(int i=0; i<rooms.length; i++) {
			rooms[i] = new Room();
		}
		
		//Set rooms with data
		for(int i=0; i<rooms.length; i++) {
		
			rooms[i].setDescription(room_description[i]);
			Item it = new Item(room_items[i]);
			Furnishing fu = new Furnishing(furnishing[i]);
			
			rooms[i].setFurnishing(fu);
			rooms[i].setItem(it);
			
			//Set south room
			if (i > 0) {
				DoorDescription southDD = new DoorDescription(south_door_description[i-1]);
				rooms[i].setSouth_room(rooms[i-1], southDD);
			}
			//Set north room
			if (i < rooms.length-1) {
				DoorDescription northDD = new DoorDescription(north_door_description[i]);
				rooms[i].setNorth_room(rooms[i+1], northDD);
			}
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
	public String acceptCommands(String command) {

			if (command.equals("N")) {
				if(currentRoom.moveNorth() != null)
					currentRoom = currentRoom.moveNorth();
				return "N";
			}
			
			else if (command.equals("S")) {
				if(currentRoom.moveSouth() != null)
					currentRoom = currentRoom.moveNorth();
				return "S";
			}
			
			else if (command.equals("L")) {
				currentRoom.lookForItems();
				return "L";
			}
			
			else if (command.equals("H")) {
				Room.printHelpMenu();
				return "H";
			}
			
			else if (command.equals("I")) {
				currentRoom.printInventory();
				return "I";
			}
			
			else if (command.equals("D")) {
				currentRoom.drink();
				return "D";
			}
			
			else {
				System.out.println("What?\n");
				return "What?\n";
			}
			
	
	}

	public void setCurrentRoom(Room mockRoom) {
		currentRoom = mockRoom;
		// TODO Auto-generated method stub
		
	}
}
