//Mohammad Malik

import java.util.Scanner;

public class cmsc401{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int numLines = sc.nextInt();
		int[] array = new int[numLines];
		int n = 0;
		
		for(int i = 0; i < numLines;i++){
			n = sc.nextInt();
			if(n<=1000000000 && n>0){
				array[i] = n;
			}
			else{
				while(n>1000000000 || n<0){
					n = sc.nextInt();
				}
				array[i] = n;
			}
		}
		
		int cme = array[0];
		int counter = 0;
		
		for(int k = 0; k < numLines; k++){
			int x = array[k];
			
			if(counter==0){
				cme = x;
				counter++;
			}
			else{
				if(cme == x){
					counter++;
				}
				else{
					counter--;
				}
			}
		}
		
		int none = -1;
		
		if(counter == 0){
			System.out.println(none);
		}
		
		int count = 0;
		
		for(int m = 0; m < numLines; m++){
			if(cme == array[m]){
				count++;
			}
		}
		if(count > array.length/2){
			System.out.println(cme);
		}
		else{
			System.out.println(none);
		}
	}
}