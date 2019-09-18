// Mohammad Malik
import java.util.Scanner;

public class cmsc401{
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int numLines = sc.nextInt();
		for (int q=0;q<numLines;q++){
			int num = sc.nextInt();
			while(num<=4 || num>=1000){
				num = sc.nextInt();
			}
			int[] array = new int[num];
			
			for(int i = 0; i<array.length;i++){
				int n = sc.nextInt();
				while(n<0 || n>1000){
					n = sc.nextInt();
				}
				array[i]= n;
			}
			
			int x = array[num-2];
			int y = array[num-1];	
			
			if (x<1 && y<1){
				array[num-2] = sc.nextInt();
				array[num-1] = sc.nextInt();
				x = array[num-2];
				y = array[num-1];
			}
			else if(x<1){
				array[num-2] = sc.nextInt();
				x = array[num-2];
			}
			else if(y<1){
				array[num-1] = sc.nextInt();
				y = array[num-1];
			}
			
			// code stores last two integers, not sure what the project was asking in that respect
			// also code does not handle if x or y are > n-2
			
			int getX = array[x-1];
			int getY = array[y-1];
			int z = getX*getY;
			
			System.out.println(z);
			
		}
	}
}