import java.util.*;

public class AlgorithmsApplication {

	public static void main(String[] args) {

		// User input
		Scanner input = new Scanner(System.in);

		System.out.println("Would you like to search or sort a list?");
		System.out.println("(1) Search\n(2) Sort");
		int userOption = input.nextInt();

		// Get values from the user
		System.out.println("Enter the list size: ");
		int size = input.nextInt();
		int[] list = new int[size]; // Uses the inputed number as the array length

		System.out.println("Enter the maximum value of an element in the list: ");
		int max = input.nextInt();

		System.out.println("\nUnsorted List: ");

		// Prints out all numbers in the array from 1 to the maximum input value
		for (int x = 0; x < list.length; x++) {

			list[x] = (int) (Math.random() * max + 1);
			System.out.print(list[x] + " ");

		}

		// Call sortOrSearch method
		sortOrSearch(list, userOption);

	}

	public static void sortOrSearch(int list[], int userOption) {

		Scanner input = new Scanner(System.in);

		// Get start and end variables used for merge sort
		int start = 0;
		int end = list.length - 1;

		// Display search method options
		if (userOption == 1) {

			SortMethods.bubbleSort(list);
			displayList(list);

			int x = SearchMethods.targetElement();

			searchOptions(list, userOption, x);

			// Display sort method options
		} else if (userOption == 2) {

			sortOptions(list, start, end);

		} else {
			System.out.println("You have entered an invalid number");
			sortOrSearch(list, userOption);
		}

	}

	public static void searchOptions(int list[], int size, int search) {

		Scanner input = new Scanner(System.in);

		System.out.println("\n\nWhich searching method would you like to use?");
		System.out.println("(1) Linear Search\n(2) Binary Search\n(3) Exponential Search");
		int answer = input.nextInt();

		if (answer == 1) {
			SearchMethods.linearSearch(list, answer);
			SearchMethods.displaySearchedElement(list, search, answer);

		} else if (answer == 2) {
			SearchMethods.binarySearch(list, answer);
			SearchMethods.displaySearchedElement(list, search, answer);

		} else if (answer == 3) {
			SearchMethods.exponentialSearch(list, answer);
			SearchMethods.displaySearchedElement(list, search, answer);
		} else {
			System.out.println("You have entered an invalid number");
			searchOptions(list, answer, answer);
		}

	}

	public static int sortOptions(int list[], int start, int end) {

		// User input
		Scanner input = new Scanner(System.in);

		// Display sorting options to user
		System.out.println("\nWhich sorting method would you like to use? ");
		System.out.println("(1) Bubble Sort\n(2) Selection Sort\n(3) Insertion Sort\n(4) Counting Sort");
		System.out.print("(5) Bucket Sort\n(6) Radix Sort\n(7) Shell Sort\n(8) Quick Sort\n(9) Merge Sort");

		int answer = input.nextInt(); // Variable to get which sorting method the user would like to use
		int size = list.length; // Variable for the size of the array

		// Get sorting method the user would like to use
		if (answer == 1) {
			SortMethods.bubbleSort(list);
			displayList(list);

		} else if (answer == 2) {
			SortMethods.selectionSort(list);
			displayList(list);

		} else if (answer == 3) {
			SortMethods.insertionSort(list);
			displayList(list);

		} else if (answer == 4) {
			SortMethods.countingSort(list, size);
			displayList(list);

		} else if (answer == 5) {
			SortMethods.bucketSort(list, size);
			displayList(list);

		} else if (answer == 6) {
			SortMethods.radixSort(list, size);
			displayList(list);

		} else if (answer == 7) {
			SortMethods.shellSort(list);
			displayList(list);

		} else if (answer == 8) {
			SortMethods.quickSort(list, start, end);
			displayList(list);

		} else if (answer == 9) {
			SortMethods.mergeSort(list, start, end);
			displayList(list);

		} else {
			System.out.println("You have entered an invalid number");
			sortOptions(list, answer, answer);
		}

		input.next();
		
		// Return the answer to be used when we display the sort results
		return answer;

	}

	// Method to display the sorted list
	public static void displayList(int list[]) {

		// Print the selection sorted array
		System.out.println("\nSorted List: ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}

	}

}