//Mohammad Malik

import java.util.Scanner;

public class cmsc401{

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int numHouses = sc.nextInt();

		int[] array = new int[numHouses];
		
		for (int i = 0; i < numHouses; i++){
			array[i] = sc.nextInt();
		}
		
		int median = (array.length) / 2;

		int upperbound = quickselect(array, 0, array.length - 1, median);
		int lowerbound = quickselect(array, 0, array.length - 1, median-1);

		if (array.length % 2 != 0){
			System.out.println(upperbound);
		}
		else{
			int done = (upperbound + lowerbound) / 2;
			System.out.println(done);

		}
		sc.close();
	}
	
	public static int partition(int[] array, int p, int r){
		int x = array[p];
		swap(array, p, r);
		int i = p;

		for(int j = p; j < r; j++){
			if(array[j]<=x){
				swap(array, i, j);
				i++;
			}
		}
		swap(array, r, i);
		return i;
	}
	
	public static int quickselect(int[] array, int p, int r, int k){
		int x = partition(array, p, r);
		if(k < x){
			return quickselect(array, p, x-1, k);
		}
		else if(k > x){
			return quickselect(array, x+1, r, k);
		}
		else{
			return array[x];
		}
	}

	public static void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}