package cs1632;

import java.util.Scanner;

public class CoffeeMaker {
	
	public static void main(String[] args) {
		//Room setup--------------------------------------
		//Setup all rooms and data
		String[] North_door_description = {"Magenta", "Beige", "Dead", "Vivacious", "Purple"};
		String[] South_door_description = {"Massive", "Smart", "Slim", "Sandy", "Minimalist"};
		String[] Room_items = {"Cream", "Nothing", "Coffee", "Nothing", "Nothing", "Sugar"};
		String[] Furnishing = {"Quaint Sofa", "Sad record player", "Tight pizza", "Flat energy drink",
				"Beautiful bag of money", "Perfect air hockey table"
		};
		String[] Room_description = {"Small","Funny","Refinanced","Dumb","Bloodthirsty","Rough"};
		//Make all the rooms
		Room[] rooms = new Room[Room_description.length];
		
		//Initalize rooms
		for(int i=0;i<rooms.length;i++) {
			rooms[i] = new Room();
		}
		//Set rooms with data
		for(int i=0;i<rooms.length;i++) {
			rooms[i].setDescription(Room_description[i]);
			rooms[i].setFurnishing(Furnishing[i]);
			rooms[i].setItem(Room_items[i]);
			//Set south room
			if (i>0) rooms[i].setSouth_room(rooms[i-1], South_door_description[i-1]);
			//Set north room
			if (i<rooms.length-1) rooms[i].setNorth_room(rooms[i+1], North_door_description[i]);
			
		}
		
		//Game setup--------------------------------------------
		Boolean hasCream = false;
		Boolean hasCoffee = false;
		Boolean hasSugar = false;
		int room_index = 0;
		//Begin game--------------------------------------------
		while(true) {
			Room curr = rooms[room_index];
			//STDOUT
			System.out.println("");
			
			System.out.println("You see a "+curr.description+" room");
			System.out.println("It has a "+curr.furnishing);
			
			
			if(curr.getNorth_room()!=null) System.out.println("A "+curr.getNorth_room_door_description()+" door leads North");
			if(curr.getSouth_room()!=null) System.out.println("A "+curr.getSouth_room_door_description()+" door leads South");
			
			System.out.println("\nINSTRUCTIONS (N,S,L,I,D,H)>");
			//Inputs
			Scanner sc = new Scanner(System.in);
		    String s = sc.next();
		    
		    if (s.equals("N") && curr.getNorth_room()!=null){
		    	System.out.println("N");
		    	room_index++;
		    }
		    else if(s.equals("S") && curr.getSouth_room()!=null){
		    	System.out.println("S");
		    	room_index--;
		    }
		    else if(s.equals("L") && curr.getItem().equals("Nothing")){
		    	System.out.println("L");
		    	System.out.println("You don't see anything ordinary");
		    }
		    else if(s.equals("L")) {
		    	System.out.println("L");
		    	System.out.println("There might be something here...");
		    	System.out.println("You found some"+curr.getItem()+"!");
		    	if (curr.getItem().equals("Coffee")) hasCoffee = true;
		    	else if(curr.getItem().equals("Cream")) hasCream = true;
		    	else hasSugar = true;
		    }
		    else if(s.equals("I")) {
		    	System.out.println("I");
		    	if(hasCream) System.out.println("You have some fresh cream");
		    	else System.out.println("YOU HAVE NO CREAM");
		    	
		    	if(hasCoffee) System.out.println("You have a cup of delicous coffee");
		    	else System.out.println("YOU HAVE NO COFFEE");
		    	
		    	if(hasSugar) System.out.println("You have some tasty sugar");
		    	else System.out.println("YOU HAVE NO SUGAR");
		    }
		    else if(s.equals("D")) {
		    	System.out.println("D");
		    	//printInventory();
		    	if(hasCream) System.out.println("You have some fresh cream");
		    	else System.out.println("YOU HAVE NO CREAM");
		    	
		    	if(hasCoffee) System.out.println("You have a cup of delicous coffee");
		    	else System.out.println("YOU HAVE NO COFFEE");
		    	
		    	if(hasSugar) System.out.println("You have some tasty sugar");
		    	else System.out.println("YOU HAVE NO SUGAR");
		    	
		    	if (hasCream && hasCoffee && hasSugar)
		    		System.out.println("You drink the beverage and are ready to study!\n You win!");
		    	else if (hasCream && hasSugar) 
		    		System.out.println("You drink the sweetned cream, but without caffeine, you cannot study.\nYou lose!");
		    	else if (hasCoffee && hasSugar) 
		    		System.out.println("Without cream, you get an ulcer and cannot study.\nYou lose!");
		    	else if (hasCream && hasCoffee)
		    		System.out.println("Without sugar, the coffee is too bitter. You cannot study.\nYou lose!");
		    	else if (hasCream)
		    		System.out.println("You drink the cream, but without caffeine, you cannot study.\nYou lose!");
		    	else if (hasCoffee)
		    		System.out.println("Without cream, you get an ulcer and cannot study.\nYou lose!");
		    	else if (hasSugar)
		    		System.out.println("You eat the sugar, but without caffeine, you cannot study!\nYou lose!");
		    	else {
		    		System.out.println("You drink the air, as you have no coffee, sugar, or cream.");
		    		System.out.println("The air is invigorating, but not invigorating enough. You cannot study.");
		    		System.out.println("You lose!");
		    	}
		    }
		    else {
		    	System.out.println("What?");
		    }
		}
		
		
	}
}
