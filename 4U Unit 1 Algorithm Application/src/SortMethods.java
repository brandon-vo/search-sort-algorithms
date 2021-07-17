import java.util.ArrayList;

import javax.xml.crypto.Data;

public class SortMethods {

	private static void swap(int[] list, int index1, int index2) {

		int temp = list[index1]; // Temporary storage variable used to put elements when we want to swap them

		list[index1] = list[index2]; // Assigns the first index as the value of the second index

		list[index2] = temp; // Assigns the second index as the temporary storage variable
	}

	// Method used to run the bubble sort algorithm
	public static void bubbleSort(int list[]) {

		// Length of the list - 1 to compare
		for (int i = list.length - 1; i > 0; i--) {

			// Loop to compare all numbers in the array
			for (int j = 0; j < i; j++) {

				// Checks if the number before is greater than the number after
				if (list[j] > list[j + 1]) {
					swap(list, j, j + 1);
				}

			}

		}

	}

	// Method used to run the selection sort algorithm
	public static void selectionSort(int list[]) {

		// Nested for loop
		// Outer loop for the upcoming index
		for (int i = 0; i < list.length - 1; i++) {

			// Variable for the smallest element from the list
			int smallest = i;

			// Inner loop for the following index
			for (int j = i + 1; j < list.length; j++)

				// Checks if the next element is smaller than the current smallest element
				if (list[j] < list[smallest])

					// Sets the element to the smallest element
					smallest = j;

			// Swaps the two indexes
			swap(list, i, smallest);
		}

	}

	// Method used to run the insertion sort algorithm
	public static void insertionSort(int list[]) {

		// Loop through the first index (upcoming index)
		for (int i = 1; i < list.length; i++) {

			// Loop through the second index (following index)
			for (int j = i - 1; j >= 0; j--)

				// Compares the first two elements and adjusts them into ascending order
				if (list[i] < list[j])

					swap(list, i--, j);

				// Used when the first element is greater than the second element
				else
					break;
		}

	}

	// Method used to run the counting sort algorithm
	public static void countingSort(int list[], int size) {

		// Create a count array
		int[] count = new int[size + 1];

		// Adding all occurring elements in the original array to the count array
		for (int x = 0; x < list.length; x++)
			count[list[x]]++;

		// Variable for the array index
		int index = 0;
		
		// Search through the count array
		for (int x = 0; x < count.length; x++) {
			
			// Gets rid of all non-occurring elements
			while (count[x] != 0) {

				// Get the number of occurences into the array
				list[index++] = x; // Sets each element in the list to the variable, used in the count array
				count[x]--; // Count down the count array

			}

		}

	}

	// Method used to run the bucket sort algorithm
	public static void bucketSort(int list[], int size) {

		// Create buckets based on the sqrt of the array size for equal distribution
		int numBuckets = (int) Math.sqrt(size) + 1;

		// Create an ArrayList for the number of buckets used
		ArrayList<Integer>[] bucket = new ArrayList[numBuckets];

		// Create an ArrayList which groups the elements into the buckets
		for (int x = 0; x < numBuckets; x++) {
			bucket[x] = new ArrayList<Integer>();

		}

		// Add array elements into the bucket ArrayList based on the range
		for (int x = 0; x < list.length; x++)
			bucket[list[x] / numBuckets].add(list[x]);

		// Variable to search through the original array indexes
		int index = 0;

		// Go through the buckets to sort through
		for (int x = 0; x < numBuckets; x++) {

			// Check if the bucket array is not empty
			if (bucket[x].size() != 0) {

				// Create a temporary bucket array to store values being moved
				int[] tempBucket = new int[bucket[x].size()];

				// Set bucket values into the temporary bucket array
				for (int y = 0; y < tempBucket.length; y++)
					tempBucket[y] = bucket[x].get(y);

				// Sort the array
				insertionSort(list);

				// Place the sorted array back into the original array
				for (int y = 0; y < tempBucket.length; y++)
					list[index++] = tempBucket[y];
			}			

		}

	}

	// Method used to run the radix sort algorithm
	public static void radixSort(int list[], int size) {

		// Find the most significant figure in the array (place value)
		int msd = (int) (Math.log10(size) + 1);

		// Create an ArrayList for each of the digits
		ArrayList<Integer>[] digit = new ArrayList[10];
 
		for (int x = 0; x < 10; x++)
			digit[x] = new ArrayList<Integer>();

		for (int x = 0; x < msd; x++) {

			for (int y = 0; y < list.length; y++)
				digit[(int) (list[y] / Math.pow(10, x) % 10)].add(list[y]);

			int index = 0;
			for (int y = 0; y < 10; y++)
				while (!digit[y].isEmpty()) {
					list[index++] = digit[y].remove(0);
				}
		}

	}

	// Method used to run the shell sort algorithm
	public static void shellSort(int list[]) {

		for (int gap = list.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < list.length; i++) {

				int key = list[i];
				int j = i;

				while (j >= gap && list[j - gap] > key) {

					list[j] = list[j - gap];

					j -= gap;

				}

				list[j] = key;

			}

		}

	}

	// Method used to run the quick sort algorithm
	public static void quickSort(int list[], int start, int end) {

		int left = start;
		int right = end;

		while (left != right) {

			while (list[right] > list[left])
				right--;

			if (left != right) {

				swap(list, left, right);
				left++;

				while (list[left] < list[right])
					left++;

				if (left != right) {
					swap(list, left, right);
					right--;
				}
			}
		}

		if (left > start)
			quickSort(list, start, left - 1);

		if (right < end)
			quickSort(list, right + 1, end);
	}

	public static void mergeSort(int[] list, int start, int end) {

		if ((end - start) >= 1) {

			int middle = (start + end) / 2;

			mergeSort(list, start, middle);
			mergeSort(list, middle + 1, end);

			merge(list, start, end);
		}

	}

	private static void merge(int[] list, int start, int end) {

		int mergeIndex = 0;

		int middle = (start + end) / 2;

		int leftIndex = start;
		int rightIndex = middle + 1;

		int[] mergedSubArray = new int[end - start + 1];

		while (leftIndex <= middle && rightIndex <= end) {

			if (list[leftIndex] < list[rightIndex]) {
				mergedSubArray[mergeIndex] = list[leftIndex];
				leftIndex++;
			} else {
				mergedSubArray[mergeIndex] = list[rightIndex];
				rightIndex++;
			}

			mergeIndex++;
		}

		if (leftIndex > middle) {

			while (rightIndex <= end) {
				mergedSubArray[mergeIndex] = list[rightIndex];
				mergeIndex++;
				rightIndex++;
			}
		} else {

			while (leftIndex <= middle) {
				mergedSubArray[mergeIndex] = list[leftIndex];
				mergeIndex++;
				leftIndex++;
			}
		}

		for (int index = 0; index < mergedSubArray.length; index++)
			list[start + index] = mergedSubArray[index];

	}

}
