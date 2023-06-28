
public class interpolationSearchRecursive {
	interpolationSearchRecursive(int[] array, int key){
		int low = 0;
		int high = array.length - 1;
		return interpolationSearchRecursive(array, low, high, key);
	}
	int interpolationSearchRecursive(int[] array, int low, int high, int key)
	{
	if(low <= high)
	{
	int pos = (key - array[low]) / (array[high] - array[low]);
	int mid = low + ((high - low) * pos);
	if(key == array[mid])
	return mid; //key FOUND and index returned
	else if(key < array[mid])
	return interpolationSearchRecursive(array, low, mid-1, key);
	else if(array[mid] < key)
	return interpolationSearchRecursive(array, mid+1, high, key);
	}
	return -1;
	}//key NOT FOUND and -1 returned
}
