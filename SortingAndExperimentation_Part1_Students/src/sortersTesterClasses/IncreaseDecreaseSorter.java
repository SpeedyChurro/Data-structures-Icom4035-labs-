package sortersTesterClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import sorterClasses.BubbleSortSorter;
import sorterClasses.InsertionSortSorter;
import sorterClasses.SelectionSortSorter;
import interfaces.Sorter;


public class IncreaseDecreaseSorter { 

	private static ArrayList<Sorter<Integer>> sortersList = new ArrayList<>(); 
	private static Integer[] array = {5, 9, 20, 22, 20, 5, 4, 13, 17, 8, 22, 1, 3, 7, 11, 9, 10};
	
	
	public static void main(String[] args) { 
		sortersList.add(new BubbleSortSorter<Integer>()); 
		sortersList.add(new SelectionSortSorter<Integer>()); 
		sortersList.add(new InsertionSortSorter<Integer>()); 
		
		
		test("Bubble Sort: Increasing and Decreasing:", new IntegerComparator1(), new IntegerComparator2()); 
		test("Selection Sort: Increasing and Decreasing:", new IntegerComparator1(), new IntegerComparator2()); 
		test("Insertion Sort: Increasing and Decreasing:",  new IntegerComparator1(), new IntegerComparator2()); 
	
	}
	
	
	private static void test(String msg, Comparator<Integer> cmp1, Comparator<Integer> cmp2) { 
		

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");
		Integer[] arr;
		System.out.println();
		showArray("The array is: ", array);
		System.out.println();
		System.out.println("----------------------------------------------------");
		
		for (int s=0; s<sortersList.size(); s++) {
			Sorter<Integer> sorter = sortersList.get(s); 
			arr = array.clone();
			
			System.out.println();

			sorter.sort(arr, cmp1);
			showArray("The array goes in increasing order when for " + sorter.getName() + " it's: ", arr);
			System.out.println();
			
			sorter.sort(arr, cmp2);
			showArray("The array goes in decreasing order when for " + sorter.getName() + " it's: ", arr);
			System.out.println();
			
			System.out.println("----------------------------------------------------");
		}
	}
	
	
	
	
	
	
	
	private static void showArray(String msg, Integer[] a) {
		System.out.print(msg); 
		System.out.print("{");
		for (int i=0; i<a.length; i++) 
			System.out.print(" " + a[i]); 
		System.out.print("}");
		System.out.println();
	}
	
	
	
}
