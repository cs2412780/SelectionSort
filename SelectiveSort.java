package sortSelective;

import java.util.Random;

import lab1.ArrayBag;

public class SelectiveSort { 

	public static void main(String[] args) {

		ArrayBag<Integer> a1 = new ArrayBag<>(1000);
		ArrayBag<Integer> a2 = new ArrayBag<>(1000);

		Random r = new Random();
		int[] array =new int[1000];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1000);
			a1.add(array[i]);
			//System.out.println(array[i]);
		}
		
		System.out.println("selectiveSortByIteration: ");
		selectiveSortByIteration(array);
		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
			//System.out.println(array[i]);
		}
		boolean pass = true;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				System.out.println("*****Failed");
				pass = false;
				break;
			}
		}
		
		if(a1.equals(a2) && pass) {
			System.out.println("Sorted.");
		}
		System.out.println();
		
		a1.clear();
		a2.clear();
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(100);
			a1.add(array[i]);
			//System.out.println(array[i]);
		}
		System.out.println("selectiveSortByRecursion: ");
		selectiveSortByRecursion(array,0);
		for(int i = 0; i < array.length; i++) {
			a2.add(array[i]);
			//System.out.println(array[i]);
		}
		pass = true;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				System.out.println("*****Failed");
				pass = false;
				break;
			}
		}
		if(a1.equals(a2) && pass) {
			System.out.println("Sorted.");
		}
	}//end main
	
	
	
	
	/**
	 * a function that uses iterative selection sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public static void selectiveSortByIteration(int[] array) {
		int indexOfSmallest = 0;
		for(int i = 0; i < array.length; i++) {
			indexOfSmallest = i;
			for(int j = i; j < array.length; j++) {
				if(array[indexOfSmallest] > array[j]) {
					indexOfSmallest = j;
				}
			}//end nested for
			swap(array, i, indexOfSmallest);	
		}//end for
	}//end selectiveSortByIteration
	
	/**
	 * a function that uses recursive selection sort to sort an array.
	 * @param array The array that to be sorted
	 * @param firstUnsorted The index of the first entry in an unsorted part of the array
	 */
	public static void selectiveSortByRecursion(int[] array, int firstUnsorted) {
		if (firstUnsorted < array.length - 1) {
			int indexOfSmallest = 0;
			indexOfSmallest = findIndexOfSmallest(array, firstUnsorted);
			swap(array, firstUnsorted, indexOfSmallest);
			selectiveSortByRecursion(array,firstUnsorted + 1);
		}
		
	}//selectiveSortByRecursion
	
	/**
	 * a function that find the index of the smallest entry in an array
	 * @param array The target array
	 * @param indexOfCheckingElement The starting index
	 * @return Index of the smallest entry
	 */
	private static int findIndexOfSmallest(int[] array, int indexOfCheckingElement) {
		if(indexOfCheckingElement >= array.length - 1) {
			return indexOfCheckingElement;
		}
		else {
			 int index = findIndexOfSmallest(array, indexOfCheckingElement + 1);
			 if (array[index] < array[indexOfCheckingElement]) {
				 return index;
			 }
			 else
				 return indexOfCheckingElement;
		}	
	}//end findIndexOfSmallest		

	
	/**
	 * swap two entries.
	 * @param array the target array
	 * @param first Index of an entry
	 * @param last Index Of another entry
	 */
	private static void swap(int[] array, int first, int last) {
		int temp = array[first];
		array[first] = array[last];
		array[last] = temp;
	}
}
