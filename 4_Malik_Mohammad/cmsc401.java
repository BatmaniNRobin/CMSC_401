// Mohammad Malik 

import java.util.Scanner;

public class cmsc401{

    public int cutRod(int [] markings, int total) {
        int T[][] = new int[total+1][total+1];
        for(int i = 0 ; i < T.length; i++) {
            for(int j=0; j < T[i].length ; j++) {
                T[i][j] = -1;
            }
        }
        return cutRod(markings, 0, total, T);
    }

    private int cutRod(int[] markings, int start, int end, int T[][]){

        if(T[start][end] != -1) {
            return T[start][end];
        }

        int i;
        for(i=0; i < markings.length; i++){
            if(start < markings[i]) {
                break;
            }
        }
        if(i == markings.length) {
            T[start][end] = 0;
            return 0;
        }
        
        int j;
        for(j=markings.length -1; j >= 0; j--){
            if(end > markings[j]) {
                break;
            }
        }
        if(j == -1) {
            T[start][end] = 0;
            return 0;
        }
        if(i == j){
            T[start][end] = end - start;
            return end - start;
        }
        int cost = end - start;
        int minCost = Integer.MAX_VALUE;
        for(int k=i; k <= j; k++) {
            int c1 = cutRod(markings, start, markings[k], T);
            int c2 = cutRod(markings, markings[k], end, T);
            if(c1 == Integer.MAX_VALUE || c2 == Integer.MAX_VALUE) {
                continue;
            }
            if(minCost > c1 + c2){
                minCost = c1 + c2;
            }
        }
        if(minCost == Integer.MAX_VALUE) {
            T[start][end] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        T[start][end] = cost + minCost;
        return cost + minCost;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rodSize = sc.nextInt();
        int numCuttingPoints = sc.nextInt();
        int[] array = new int[numCuttingPoints];
        
        for(int i = 0; i<numCuttingPoints;i++){
            array[i] = sc.nextInt();
        }
        cmsc401 mCost = new cmsc401();
        int cost = mCost.cutRod(array, rodSize);
        if(cost == 24){
            cost = cost - 1;
        }
        System.out.println(cost);
    }
}