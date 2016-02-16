public class Room {
	public Furnishing furnishing;
	public String description;
	public Room south_room;
	public Room north_room;
	public DoorDescription north_room_door_description;
	public DoorDescription south_room_door_description;
	public Item item;
	public static boolean [] items = new boolean[3];
	public Room () {
		
	}
	
	public String getFurnishing() {
		if (this.furnishing != null)
			return this.furnishing.getName();
		return null;
	}
	
	public boolean [] getItems() {
		return items;
	}
	
	public void setItems(boolean [] inputItems) {
		items = inputItems;
	}
	
	
	public void setFurnishing(Furnishing f) {
		
		this.furnishing = f;
	
	}

	public String getDescription() {
		return description;
	}
	public boolean setDescription(String description) {
		if (description == null) return false;
		this.description = description;
		return true;
	}
	public Room getSouth_room() {
		return south_room;
	}
	public boolean setSouth_room(Room south_room, DoorDescription south_room_description) {
		
		if (south_room == null || south_room_description == null) return false;
		
		this.south_room = south_room;
		DoorDescription newDescription = south_room_description;
		this.south_room_door_description = newDescription;
		
		return true;
	}
	
	public Room getNorth_room() {
		return north_room;
	}
	public boolean setNorth_room(Room north_room, DoorDescription north_room_description) {
		
		if (north_room == null || north_room_description == null) return false;
		
		this.north_room = north_room;
		DoorDescription newDescription = north_room_description;
		this.north_room_door_description = newDescription;
		return true;
	}
	public DoorDescription getNorth_room_door_description() {
		if (moveNorth() == null) return null;
		return north_room_door_description;
	}
	public DoorDescription getSouth_room_door_description() {
		return south_room_door_description;
	}

	public Item getItem() {
		return item;
	}
	public void setItem(Item i) {
		item = i;
	}
	
	public void printRoomInfo() {
		
		System.out.println("You see a " + description + " room.");
		System.out.println("It has a " + getFurnishing() + ".");
			
		if (getNorth_room() != null) 
			System.out.println("A "+ getNorth_room_door_description().description + " door leads North.");
		if (getSouth_room() != null) 
			System.out.println("A "+ getSouth_room_door_description().description + " door leads South.");
	}
	
	public boolean drink() {
		
		printInventory();
		
		boolean hasCream = items[0];
		boolean hasCoffee = items[1];
		boolean hasSugar = items[2];
		
		if (hasCream && hasCoffee && hasSugar) {
		    System.out.println("You drink the beverage and are ready to study!");
			System.out.println("You win!");
			return true;
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
		   
		return false;
		
	}
	
	public Room moveNorth() {
		
		if (getNorth_room() == null) {
			System.out.println("There is no door leading north.\n");
			return null;
		}
		else {
			return north_room;
		}
	}
	
	public Room moveSouth() {
		
		if (getSouth_room() == null) {
			System.out.println("There is no door leading south.\n");
			return null;
		}
		else {
			return south_room;
		}
	}
	
	public void printInventory() {
		
		boolean hasCream = items[0];
		boolean hasCoffee = items[1];
		boolean hasSugar = items[2];
		
		
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
	
	//Returns true if returns new item
	public boolean lookForItems () {
		
		//Note that in the haveItems array, 
		//hasCream = haveItems[0], hasCoffee = haveItems[1], and hasSugar = haveItems[2]
	
		Item roomObj = getItem();
		if (roomObj == null) return false;
		String name = roomObj.getName();
		boolean outcome = false;
		
		if (name.equals("Nothing")) {
		    	System.out.println("You don't see anything out of the ordinary.");
		    	outcome = false;
		}
		
	   	else {
	   	
		    System.out.println("There might be something here...");
		    
		    if (name.equals("Cream"))  {
		    	
		    	//Didn't have cream before, now we found it
		    	if (items[0] == false) {
		    		outcome = true;
		    	}
		    	System.out.println("You found some creamy cream!");
		    	items[0] = true;
		    }
	
		    else if (name.equals("Coffee")) {
		    	//Didn't have coffee before, now we found it
		    	if (items[1] == false) {
		    		outcome = true;
		    	}
		    	System.out.println("You found some caffeinated coffee.");
		    	items[1] = true;
		    }
		    
		    else { 
		    	//Didn't have sugar before, now we found it
		    	if (items[2] == false) {
		    		outcome = true;
		    	}
		    	System.out.println("You found some sweet sugar!");
		    	items[2] = true;
		    }
		}
		
		System.out.println();
		
		return outcome;
	}
	
	public static void printInstructions() {
		System.out.println("\nINSTRUCTIONS (N,S,L,I,D,H)>");
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
	
}
