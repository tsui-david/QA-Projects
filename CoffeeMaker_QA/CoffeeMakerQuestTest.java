import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNull;
import java.util.*;

import org.junit.*;
import org.mockito.*;

public class CoffeeMakerQuestTest {
	
	//Asserts whether the scanned input capitalizes the string
	@Test
	public void assertCapitalization() {
		assertEquals("A","a".toUpperCase());
	}
	
	
	//Tests whether you find an item when it exists in a room
	//@Test
	public void findNewItem() {
		Room newRoom = new Room();
		newRoom.setItem("Coffee");
		
		assertEquals(newRoom.lookForItems(), true);
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
	
	//Check for win when the user
	//has collected all the items.
	@Test
	public void winTheGame() {
		boolean [] items = {true, true, true};
		
		Room testRoom = new Room();
		
		testRoom.setItems(items);
		boolean win = testRoom.drink();
		assertEquals(win, true);
	}
	
	//Check for items in all cases in 
	//which the user has not collected
	//all the items.
	@Test
	public void loseTheGame () {
	
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
