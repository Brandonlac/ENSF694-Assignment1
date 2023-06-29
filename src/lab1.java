import java.util.Arrays;
import java.util.Scanner;
/*
 * @author : Brandon Lac
 * Program that compares interpolation search vs linear for lab 2
 */
public class lab1 {
	public static int interpolationSearchRecursive(int[] array, int low, int high, int key)
	{
		if (low <=high) {
				int pos = (key - array[low])/ (array[high] - array[low]);
				int mid = low + (high - low)* pos;
				if (array[mid] == key) {
					return mid;
				}
				else {
				if (array[mid] > key) {
					
					interpolationSearchRecursive(array,mid+1,high,key);
				}
				else {
					interpolationSearchRecursive(array,low,mid-1,key);
				}
				}
			}
		

	return -1;
	}
	//key NOT FOUND and -1 returned
	public static int interpolationiter(int[] array, int key) {
		int low = 0;
		int pos, mid;
		int high = array.length - 1;
		while(true){
		if (low <= high) {
			pos = (key - array[low])/ (array[high] - array[low]);
			mid = low + (high - low)* pos;
			if (array[mid] == key) {
				return mid;
			}
			else if (array[mid] < key) {
				low = mid +1;
			}
			else {
				high = mid -1;
			}
		}
		else {
			return -1;
		}
		}
	}

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.print("Enter the number of elements in the array:");
		int arraySize = myObj.nextInt();
		int[] myArray = new int[arraySize];
		int i = 0;
		System.out.println("Enter the elements in the array:");
		while (i < arraySize) {
			myArray[i] = myObj.nextInt();
			i++;
		}
		System.out.print("Enter the search key:");
		int searchKey = myObj.nextInt();
		System.out.println("Sample Output:");
		System.out.println("Using Linear Search:");
		boolean found = false;
		int index = 0;
		Arrays.sort(myArray);
		long startTime = System.nanoTime();
		for(int a = 0; a < myArray.length; a++) {
			if (myArray[a] == searchKey) {
				found = true;
				index = a;
				
			}
		}
		long duration = System.nanoTime() - startTime;
		System.out.println("Run Time for Linear was " + String.valueOf(duration));
		if(found) {
			System.out.println("Serach key FOUND at index " + String.valueOf(index));
		}
		else {
			System.out.println("Not Found");
			
		}
		System.out.println("Using Interpolation Search:");
		final long interpolaationTime = System.nanoTime();
		index = interpolationiter(myArray,searchKey);
		final long interpolatationDuration = System.nanoTime() - interpolaationTime;
		System.out.println("Run Time for Interpolation was " + String.valueOf(interpolatationDuration));
		if (index != -1) {
			System.out.println("Serach key FOUND at index " + String.valueOf(index));
		}
		else {
			System.out.println("Not Found");
		}
		/* Question 2: 
		 * Comparing the run times of both linear and the interpolation, linear runs better for 
		 * smaller arrays. This is the reason because the n is small so there are many computations
		 * within interpolation that override the run time benefit.
		 */
		
		/* Question 3:
		 * The improvement that i would make it make it 20% better would be sort the array first.
		 * This would mean that in linear sort, it wouldnt have to go through the entire array. Or I 
		 * would execute the linear search by picking a starting point that is 20% through the assorted
		 * list. Depending on if that value is higher or lower than the key, i would begin the search
		 * to the left or to the right. Also adding a break statement in the if statement makes it so that
		 * the linear sort does not have to go through entire array.
		 */
		startTime = System.nanoTime();
		int startingPoint = myArray.length/5;
		if (myArray[startingPoint] < searchKey) {
			for(int a = startingPoint-1; a >= 0; a--) {
				if (myArray[a] == searchKey) {
					found = true;
					index = a;
					break;
				}
		}
		}
		else {
			for(int a = startingPoint; a < myArray.length; a++) {
				if (myArray[a] == searchKey) {
					found = true;
					index = a;
					break;
					
				}
		}
		}
		duration = System.nanoTime() - startTime;
		System.out.println("Run Time for improved linear was " + String.valueOf(duration));
		
	}
		
	
	}
