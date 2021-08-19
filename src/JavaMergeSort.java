
public class JavaMergeSort {

	// Merge two sub arrays left and right into main array
	public static void merge(int arr[], int start, int mid, int end) {

		System.out.println("Start = " + start + " End = " + end + " Mid = " + mid);

		// sizes of left array
		int leftArraySizes = mid - start + 1;
		int rightArraySizes = end - mid;

		System.out.println("Left Array Size = " + leftArraySizes + " Right Array Size = " + rightArraySizes);

		int leftArray[] = new int[leftArraySizes];
		int rightArray[] = new int[rightArraySizes];

		// left sub array
		for (int i = 0; i < leftArraySizes; i++) {
			// the index should be "start + 1". If I choose "i" only then it returns a false
			// array.
			leftArray[i] = arr[start + i];
		}

		// right sub array
		for (int i = 0; i < rightArraySizes; i++) {
			rightArray[i] = arr[mid + i + 1];
		}

		// maintaining the current index of array
		int indexOfLeftArray = 0;
		int indexOfRightArray = 0;
		int indexOfMergedArray = start;

		while (indexOfLeftArray < leftArraySizes && indexOfRightArray < rightArraySizes) {
			if (leftArray[indexOfLeftArray] <= rightArray[indexOfRightArray]) {
				arr[indexOfMergedArray] = leftArray[indexOfLeftArray];
				indexOfLeftArray++;
			} else {
				arr[indexOfMergedArray] = rightArray[indexOfRightArray];
				indexOfRightArray++;
			}
			indexOfMergedArray++;
		}

		// if some elements are remained to be sort on left array
		while (indexOfLeftArray < leftArraySizes) {
			arr[indexOfMergedArray] = leftArray[indexOfLeftArray];
			indexOfMergedArray++;
			indexOfLeftArray++;
		}

		// if some elements are remained to be sort on right array
		while (indexOfRightArray < rightArraySizes) {
			arr[indexOfMergedArray] = rightArray[indexOfRightArray];
			indexOfMergedArray++;
			indexOfRightArray++;
		}
	}

	public static void mergeSort(int arr[], int start, int end) {
		if (start < end) {

			int mid = (start + end) / 2;

			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);

			merge(arr, start, mid, end);
		}
	}

	public static void showArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int unsortedArray[] = { 6, 9, 1, 4, 2, 10, 12 };

		System.out.print("Unsorted Array = ");
		showArray(unsortedArray);

		mergeSort(unsortedArray, 0, unsortedArray.length - 1);
		System.out.print("Sorted array = ");
		showArray(unsortedArray);
	}

}
