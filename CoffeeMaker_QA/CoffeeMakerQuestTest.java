import static org.junit.Assert.assertEquals;
import java.util.*;

import org.junit.*;
import org.mockito.*;

public class CoffeeMakerQuestTest {
	//************************************************************************
	//------------------------------Method Test Cases-------------------------
	//************************************************************************
	
	//----------------------------CoffeeMakerPublicMethods--------------------
	//These test cases test the public methods of CoffeeMaker.java
	
	//Asserts whether the scanned input capitalizes the string
	@Test
	public void assertCapitalization() {
		assertEquals("A","a".toUpperCase());
	}
	
	//Check for win when the user
		//has collected all the items.
		@Test
		public void winTheGame() {
			boolean [] items = {true, true, true};
			
			Room testRoom = new Room();
			
			boolean win = testRoom.drink(items);
			assertEquals(win, true);
		}
		//Check for items in all cases in 
		//which the user has not collected
		//all the items.
		@Test
		public void loseTheGame () {
			ArrayList <boolean []> cases = new ArrayList <boolean []> ();
			
			//Has none of the items
			boolean [] arr0 = new boolean[3];
			cases.add(arr0);
			
			//Has only the first item
			boolean [] arr1 = new boolean[3];
			arr1[0] = true;
			cases.add(arr1);
			
			//Has only the second item
			boolean [] arr2 = new boolean[3];
			arr2[1] = true;
			cases.add(arr2);
			
			//Has only the third item
			boolean [] arr3 = new boolean[3];
			arr3[2] = true;
			cases.add(arr3);
			
			//Contains only the first two items
			boolean [] arr4 = new boolean[3];
			arr4[0] = true;
			arr4[1] = true;
			cases.add(arr4);
			
			//Contains only the first and third items
			boolean [] arr5 = new boolean[3];
			arr5[0] = true;
			arr5[2] = true;
			cases.add(arr5);
			
			//Contains only the second and third items
			boolean [] arr6 = new boolean[3];
			arr6[1] = true;
			arr6[2] = true;
			cases.add(arr6);
			
			Room testRoom = new Room();
		
			for (boolean [] arr: cases) {
				assertEquals(testRoom.drink(arr), false);
			}
		}
			
	
	//----------------------------DoorDescriptionPublicMethods-----------------
	//Stubs for public methods of DoorDescription
	
	//----------------------------Furnishing-----------------------------------
	//Stubs for public methods of Furnishing
	
	//----------------------------Item-----------------------------------------
	//Stubs for public methods of Item
	
	//----------------------------Room-----------------------------------------
	//Stubs for public methods of Room
	
	//************************************************************************
	//------------------------------Requirement Test Cases--------------------
	//************************************************************************
	
	
}
	
