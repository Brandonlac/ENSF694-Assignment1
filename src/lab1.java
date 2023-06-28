import java.util.Arrays;
import java.util.Scanner;
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
				else if (array[mid] < key) {
					interpolationSearchRecursive(array,low,mid-1,key);
				}
				}
			}
		

	return -1;
	}
	//key NOT FOUND and -1 returned

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
		index = interpolationSearchRecursive(myArray,0,arraySize-1,searchKey);
		final long interpolatationDuration = System.nanoTime() - interpolaationTime;
		System.out.println("Run Time for Interpolation was " + String.valueOf(interpolatationDuration));
		if (index != -1) {
			System.out.println("Serach key FOUND at index " + String.valueOf(index));
		}
		else {
			System.out.println("Not Found");
		}
		
		
		
		
	}
}