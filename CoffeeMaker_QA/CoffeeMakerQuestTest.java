import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayInputStream;
import java.util.*;

import org.junit.*;
import org.mockito.*;

public class CoffeeMakerQuestTest {
	
	//--------------------------------------------Room Tests-----------------------------------------------
	//Test setting and getting decision for room
	@Test
	public void testDescriptionRoom() {
		String s = null;
		Room newRoom = new Room();
		boolean bool = newRoom.setDescription(s);
		assertEquals(false,bool);
		
		bool = newRoom.setDescription("");
		assertEquals(true,bool);
		
		assertEquals("",newRoom.getDescription());
	}
	//Test setting and getting items for room 
	@Test
	public void testItemRoom() {
		String s = null;
		Room newRoom = new Room();
		boolean bool = newRoom.setItem(s);
		assertEquals(false,bool);
		
		bool = newRoom.setItem("");
		assertEquals(true,bool);	
		
		Item testItem = newRoom.getItem();
		assertEquals("",testItem.getName());
	}

	
	//Tests setting and getting furnishing for room
	@Test
	public void testSetFurnishingRoom() {

		String s = null;
		Room newRoom = new Room();
		boolean bool = newRoom.setFurnishing(s);
		assertEquals(false,bool);
		
		assertNull(newRoom.getFurnishing());
		
		bool = newRoom.setFurnishing("");
		assertEquals(true,bool);	
		
		String testFurnish = newRoom.getFurnishing();
		assertEquals("",testFurnish);

	}
	
	//Tests setting and getting boolean array for room
	@Test
	public void testItemsRoom() {
		boolean[] b = {true,true,true};
		Room newRoom = new Room();
		newRoom.setItems(b);
		boolean[] test = {true,true,true};
		assertEquals(test[0],newRoom.getItems()[0]);
		assertEquals(test[1],newRoom.getItems()[1]);	
		assertEquals(test[2],newRoom.getItems()[2]);	
	}
	
	//Test setting and getting north and south room for room
	@Test
	public void testDirectionRoom() {
		
		Room newRoom = new Room();
		
		boolean n = newRoom.setNorth_room(null, null);
		boolean s = newRoom.setSouth_room(null, null);
		
		assertEquals(false,n);
		assertEquals(false,s);
		
		Room south_room = new Room();
		Room north_room = new Room();
		
		String description = "";
		
		//Test setters 
		
		 n = newRoom.setNorth_room(north_room, description);
		 s = newRoom.setSouth_room(south_room, description);
		
		assertEquals(true,n);
		assertEquals(true,s);
		
		 n = newRoom.setNorth_room(north_room, null);
		 s = newRoom.setSouth_room(south_room, null);
		
		assertEquals(false,n);
		assertEquals(false,s);
		
		 n = newRoom.setNorth_room(null, description);
		 s = newRoom.setSouth_room(null, description);
		

		
	}
	//Test moving the room north and south
	@Test
	public void testMoveRoom() {
		Room newRoom = new Room();
		Room northRoom = new Room();
		Room southRoom = new Room();
		
		
		newRoom.setNorth_room(northRoom, "");
		newRoom.setSouth_room(southRoom, "");
		
		Room n = newRoom.moveNorth();
		Room s = newRoom.moveSouth();
		
		assertEquals(northRoom,n);
		assertEquals(southRoom,s);
	}
	//Test getting and setting door description
	@Test 
	public void testDoorDescriptionRoom() {
		Room newRoom = new Room();
	
		assertNull(newRoom.getNorth_room_door_description());
		assertNull(newRoom.getSouth_room_door_description());
		
		String description = "";
		// Test door description getters
		Room north_room = new Room();
		Room south_room = new Room();
		
		boolean n = newRoom.setNorth_room(north_room, description);
		boolean s = newRoom.setSouth_room(south_room, description);
		 
		assertEquals("",newRoom.getNorth_room_door_description().getDescription());
		assertEquals("",newRoom.getSouth_room_door_description().getDescription());
		
		
	}
	//Check if cannot move when no room ahead
	@Test
	public void testNoMove() {
		Room newRoom = new Room();
		Room northRoom = newRoom.moveNorth();
		assertNull(northRoom);
		
		Room southRoom = newRoom.moveSouth();
		assertNull(southRoom);
	}
	
	//Test looking for new items in room
	@Test
	public void testLookForItems() {
		Room newRoom = new Room();
		
		boolean[] noItems = {false,false,false};
		boolean[] hasCream = {true,false,false};
		boolean[] hasCoffee = {false,true,false};
		boolean[] hasSugar = {false,false,true};
		
		//Test null
		Item testItem = null;
		newRoom.item = testItem;
		boolean outcome = newRoom.lookForItems();
		assertEquals(false,outcome);
		
		//Test nothing
		testItem = Mockito.mock(Item.class);
		Mockito.when(testItem.getName()).thenReturn("Nothing");
		
		newRoom.item = testItem;
		newRoom.items = noItems;
		outcome = newRoom.lookForItems();
		assertEquals(false,outcome);
		
		//Test cream
		Mockito.when(testItem.getName()).thenReturn("Cream");	
		newRoom.item = testItem;
		
		newRoom.items = noItems;
		outcome = newRoom.lookForItems();
		assertEquals(true,outcome);
		
		newRoom.items = hasCream;
		outcome = newRoom.lookForItems();
		assertEquals(false,outcome);
		
		newRoom.items = hasCoffee;
		outcome = newRoom.lookForItems();
		assertEquals(true,outcome);
		
		newRoom.items = hasSugar;
		outcome = newRoom.lookForItems();
		assertEquals(true,outcome);
		
		//Test coffee
		Mockito.when(testItem.getName()).thenReturn("Coffee");	
		newRoom.item = testItem;
		
		newRoom.items = noItems;
		outcome = newRoom.lookForItems();
		assertEquals(true,outcome);
		
		newRoom.items = hasCream;
		outcome = newRoom.lookForItems();
		assertEquals(true,outcome);
		
		newRoom.items = hasCoffee;
		outcome = newRoom.lookForItems();
		assertEquals(false,outcome);
		
		newRoom.items = hasSugar;
		outcome = newRoom.lookForItems();
		assertEquals(true,outcome);
		
		//Test sugar
		Mockito.when(testItem.getName()).thenReturn("Sugar");	
		newRoom.item = testItem;
		
		newRoom.items = noItems;
		outcome = newRoom.lookForItems();
		assertEquals(true,outcome);
		
		newRoom.items = hasCream;
		outcome = newRoom.lookForItems();
		assertEquals(true,outcome);
		
		newRoom.items = hasCoffee;
		outcome = newRoom.lookForItems();
		assertEquals(true,outcome);
		
		newRoom.items = hasSugar;
		outcome = newRoom.lookForItems();
		assertEquals(false,outcome);
		
	}
	//-----------------------------------------Item Tests----------------------------------------------
	//Test setting and getting the items
	@Test
	public void testItems() {
		Item p = new Item(null);
		boolean b = p.setName(null);
		assertEquals(false,b);
		
		String s = p.getName();
		assertNull(s);
		
		b = p.setName("");
		assertEquals(true,b);
		
		s = p.getName();
		assertEquals("",s);
		
		
	}
	//-----------------------------------------Furnishing Tests----------------------------------------------
	//Test setting and getting the furnishing
	@Test
	public void testFurnishing() {
		Furnishing p = new Furnishing(null);
		boolean b = p.setName(null);
		assertEquals(false,b);
		
		String s = p.getName();
		assertNull(s);
		
		b = p.setName("");
		assertEquals(true,b);
		
		s = p.getName();
		assertEquals("",s);
	}
	//-----------------------------------------Door Description Tests----------------------------------------------
	//Test setting and getting the door descriptions
	@Test
	public void testDoorDescription() {
		DoorDescription p = new DoorDescription(null);
		boolean b = p.setDescription(null);
		assertEquals(false,b);
		
		String s = p.getDescription();
		assertNull(s);
		
		b = p.setDescription("");
		assertEquals(true,b);
		
		s = p.getDescription();
		assertEquals("",s);
	}
	
	
	//-----------------------------------------Requirement Tests----------------------------------------------
	
	@Test
	public void testFunIteration() {
		CoffeeMaker2 test = new CoffeeMaker2();
		test.setupCoffeeGame();
		System.out.println(test.getCurrentRoom());
		String[] input = {"N","S","I","L","H","D"};
		
		Room[] rooms = test.getRooms();
		for(int j = 0;j<rooms.length;j++) {
			for(String i:input) {
				
				String s = test.acceptCommands(i);
				test.setCurrentRoom(j);
				assertEquals(i,s);
			}
		}
	}
	@Test
	public void testFunUnknownCommand() {
		CoffeeMaker2 test = new CoffeeMaker2();
		test.setupCoffeeGame();
		System.out.println(test.getCurrentRoom());
		String[] input = {" ","-1","","a","A"};
		
		Room[] rooms = test.getRooms();
		for(int j = 0;j<rooms.length;j++) {
			for(String i:input) {
				
				String s = test.acceptCommands(i);
				test.setCurrentRoom(j);
				assertEquals("What?\n",s);
			}
		}
	}
		
	
	/*
	//Test whether the system shall treat inputs as case insensitive
	@Test 
	public void testFunInputCapse() {
		String data = "a";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		//Test lower case
		CoffeeMaker test = new CoffeeMaker();
		String s = test.readInput();
		assertEquals("A",s);
		
		//Test upper case
		data = "A";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		s = test.readInput();
		assertEquals("A",s);

	}
	*/
	//Check for win when the user has collected all items and drinks
	@Test
	public void testFunWin() {
		boolean [] items = {true, true, true};
		
		Room testRoom = new Room();
		
		testRoom.setItems(items);
		boolean win = testRoom.drink();
		assertEquals(win, true);
	}
	
	//Check for lose when the user has not collected all items and drinks
	@Test
	public void testFunLose () {
	
		Room testRoom = new Room();
		
		//Has none of the items
		boolean [] arr0 = new boolean[3];
		testRoom.setItems(arr0);
		assertEquals(testRoom.drink(), false);
		
		//Has only the first item
		boolean [] arr1 = new boolean[3];
		arr1[0] = true;
		testRoom.setItems(arr1);
		assertEquals(testRoom.drink(), false);
		
		//Has only the second item
		boolean [] arr2 = new boolean[3];
		arr2[1] = true;
		testRoom.setItems(arr2);
		assertEquals(testRoom.drink(), false);
		
		//Has only the third item
		boolean [] arr3 = new boolean[3];
		arr3[2] = true;
		testRoom.setItems(arr3);
		assertEquals(testRoom.drink(), false);
		
		//Contains only the first two items
		boolean [] arr4 = new boolean[3];
		arr4[0] = true;
		arr4[1] = true;
		testRoom.setItems(arr4);
		assertEquals(testRoom.drink(), false);
		
		//Contains only the first and third items
		boolean [] arr5 = new boolean[3];
		arr5[0] = true;
		arr5[2] = true;
		testRoom.setItems(arr5);
		assertEquals(testRoom.drink(), false);
		
		//Contains only the second and third items
		boolean [] arr6 = new boolean[3];
		arr6[1] = true;
		arr6[2] = true;
		testRoom.setItems(arr6);
		assertEquals(testRoom.drink(), false);
		
	}
		
}
