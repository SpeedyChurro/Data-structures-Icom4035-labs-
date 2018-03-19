package sortersTesterClasses;

import java.util.Comparator;
import java.util.Random;
import java.util.ArrayList;




public class Entero {
	private int value; 
    public Entero(int v) { value = v; }
    public int getValue() { return value; } 
    public String toString() { return value + ""; }
   
    private static Random rnd; 
    private static ArrayList<Sorter<Integer>> sortersList = new ArrayList<>(); 
    
    
    
    public interface Sorter<E> {
    	void sort(Entero[] arr, Comparator<Entero> cmp); 
    	String getName(); 
    }

    
    private static Entero[] randomValues(int i) {
		
		Entero[] e = new Entero[i];
		for (int j=0; j<i; j++) 
			{
			e[j] = new Entero(rnd.nextInt(100));
		    
			}
		return e;
	}
    private static void showArray(String msg, Entero[] a) {
		System.out.print(msg); 
		for (int i=0; i<a.length; i++) 
			System.out.print("\t" + a[i]); 
		System.out.println();
	}
    
    private static void test(String msg, Comparator<Entero> cmp) { 
		

		System.out.println("\n\n*******************************************************");
		System.out.println("*** " + msg + "  ***");
		System.out.println("*******************************************************");
		
		Entero[] original, arr; 
		// generate random arrays is size i and test...
		for (int i=1; i<=20; i += 5) { 
			original = randomValues(i);
			showArray("\n ---Original array of size " + i + " to sort:", original); 
			
			for (int s=0; s<sortersList.size(); s++) {
				Sorter<Integer> sorter = sortersList.get(s); 
			    arr = original.clone(); 
			    sorter.sort(arr, cmp);
			    showArray(sorter.getName() + ": ", arr); 
			}
	
	
	
}
		}
    }
