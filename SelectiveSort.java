package sortSelective;

import java.util.Random;

public class SelectiveSort { 

	public static void main(String[] args) {

		Random r = new Random();
		int[] array =new int[10];
		System.out.println("random integers: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(50);
		}
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		
		System.out.println("selectiveSortByRecursion: ");
		
		selectiveSortByRecursion(array,0);
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		
		System.out.println("random integers: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(50);
		}
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
		
		selectiveSortByIteration(array);
		
		System.out.println("selectiveSortByIteration: ");
		
		for(int i = 0; i < array.length; i++) {
			 System.out.println(array[i]);
		}
	}//end main
	
	
	
	
	
	public static void selectiveSortByIteration(int[] array) {
		int indexOfSmallest = 0;
		for(int i = 0; i < array.length; i++) {
			indexOfSmallest = i;
			for(int j = i; j < array.length; j++) {
				if(array[indexOfSmallest] > array[j]) {
					indexOfSmallest = j;
				}
			}//end nested for
			int temp = array[i];
			array[i] = array[indexOfSmallest];
			array[indexOfSmallest] = temp;	
		}//end for
	}//end selectiveSortByIteration
	
	public static void selectiveSortByRecursion(int[] array, int firstUnsorted) {
		if (firstUnsorted < array.length - 1) {
			int temp = 0;
			int index = 0;
			temp = array[firstUnsorted];		
			index = findIndexOfSmallest(array, firstUnsorted);
			array[firstUnsorted] = array[index];
			array[index] = temp;
			selectiveSortByRecursion(array,firstUnsorted + 1);
		}
		
	}//selectiveSortByRecursion
	
	private static int findIndexOfSmallest(int[] array, int checkingElement) {
		if(checkingElement >= array.length - 1) {
			return checkingElement;
		}
		else {
			 int index = findIndexOfSmallest(array, checkingElement + 1);
			 if (array[index] < array[checkingElement]) {
				 return index;
			 }
			 else
				 return checkingElement;
		}	
	}//end findIndexOfSmallest		

}
