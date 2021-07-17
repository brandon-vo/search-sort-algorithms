import java.util.Arrays;
import java.util.Scanner;

public class SearchMethods {

	public static int targetElement() {

		Scanner input = new Scanner(System.in);

		System.out.println("\n\nEnter the element being searched: ");
		int search = input.nextInt(); // Get element being searched from user
		return search;

	}

	// Method used to run the linear search algorithm
	public static int linearSearch(int[] list, int search) {

		// Searches through the whole array list
		for (int x = 0; x < list.length; x++)

			// Checks if the value in the index is equal to the element being searched
			if (list[x] == search)
				return x;

		return -1;

	}

	// Method used to run the binary search algorithm
	public static int binarySearch(int[] list, int target) {

		int leftSide = 0; // Variable for the first element of the array
		int rightSide = list.length - 1; // Variable for the last element of the array

		// Ensure the left pointer does not pass the right pointer or vice versa
		while (leftSide <= rightSide) {

			// Get the midpoint of the array list
			int midpoint = (leftSide + rightSide) / 2;

			// Checks if the midpoint is the target element
			if (list[midpoint] == target)
				return midpoint;

			// If the target is larger than the midpoint, it is located on the right
			else if (target > list[midpoint])
				leftSide = midpoint + 1; // Move the left pointer 1 index right from the midpoint
			// If the target is not larger than the midpoint, it is located on the left
			else
				rightSide = midpoint - 1; // Move the right pointer 1 index left from the midpoint
		}

		return -1;

	}

	// Method used to run the exponential search algorithm
	public static int exponentialSearch(int[] list, int target) {

		// Compares the first index to the target
		if (list[0] == target)
			return 0; // Returns the position if this is true

		// Starts from the next position in the array
		int i = 1;

		// Determine the range
		while (i < list.length && list[i] <= target)
			i *= 2; // Increase the position value by multiplying by 2 after each check (exponential)

		// Uses binary search for the range
		return Arrays.binarySearch(list, i / 2, Math.min(i, list.length), target);

	}

	public static void displaySearchedElement(int[] list, int search, int answer) {

		if (answer == 1) {
			System.out.println(
					"Linear: The element " + search + " is found at position " + (linearSearch(list, search) + 1));
		} else if (answer == 2) {
			System.out.println(
					"\nBinary: The element " + search + " is found at position " + (binarySearch(list, search) + 1));
		} else if (answer == 3) {
			System.out.println("Exponential: The element " + search + " is found at position "
					+ (exponentialSearch(list, search) + 1));
		}

	}

}