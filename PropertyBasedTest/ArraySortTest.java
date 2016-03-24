import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class ArraySortTest {
	private static int NUMTEST = 100;
	private static int Maxrand = 100;
	private static int Minrand = -100;
	private ArrayList<int[]> arrayMatrix = new ArrayList<int[]>();
	/**
	 * Generate 100 random arrays
	 * Each array is of random size from 1-100
	 * Each element in array is random from -100 ~ 100
	 */
	@Before
	public void generateRandomArray() {
		
		Random r = new Random();
		for(int j=0;j<NUMTEST;j++) {
			int rsize = r.nextInt(101);
			int[] rarray = new int[rsize];
			for(int i = 0;i<rsize;i++) {
				rarray[i] = r.nextInt(201)-100;
			}
			arrayMatrix.add(rarray);
		}
	}
	/**
	 * Tests invariant that sorting an array will not change the size
	 */
	
	@Test
	public void testInvariantOutputSameSize() {
		int correct = 0;
		for(int i=0;i<NUMTEST;i++) {
			int[] a = (int[]) arrayMatrix.get(i);
			int prevLength = a.length;
			Arrays.sort(a);
			if (a.length == prevLength)
				correct++;
			else break;
		}
		assertEquals(NUMTEST,correct);
	}
	/**
	 * Tests invariant that sorting an array will always have elements go in ascending order
	 */
	@Test
	public void testValueNeverDecreasing() {
		int correct = 0;
		for(int i=0;i<NUMTEST;i++) {
			int[] a = (int[]) arrayMatrix.get(i);
			Arrays.sort(a);
			int l = a.length;
			int prev = (int)Double.NEGATIVE_INFINITY;
			boolean isCorrect = true;
			for(int j=0;j<l;j++) {
				if(prev > a[j]) {
					isCorrect = false;
					break;
				}
			}
			if(isCorrect) correct++;
			else break;
		}
		assertEquals(NUMTEST,correct);
	}
	/**
	 * Test invariant that sorting a sorted array will not change the order of the array
	 */
	@Test
	public void testIdempotent() {
		int correct = 0;
		for(int i=0;i<NUMTEST;i++) {
			int[] a = (int[]) arrayMatrix.get(i);
			Arrays.sort(a);
			int[] b = a.clone();
			Arrays.sort(b);
			
			int l = a.length;
			
			boolean isCorrect = true;
			for(int j=0;j<l;j++) {
				if(a[j]!=b[j]) {
					isCorrect = false;
					break;
				}
			}
			if(isCorrect) correct++;
			else break;
		}
		assertEquals(NUMTEST,correct);
	}
}
