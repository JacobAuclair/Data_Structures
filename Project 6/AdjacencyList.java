import java.util.*;
public class AdjacencyList{
    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input two integers seperated by a space between 1 and 10, first number for\n the start node and second number for the end node");
        int adj[][] = new int[10][11];
        for(int a = 0; a<10;a++){
            adj[a][0] = (a+1);
        }
        int i,j;
        while(scan.hasNext){
            i = scan.nextInt();
            j = scan.nextInt();
            addEdge(adj[][],i,j)
        }
    }

    void addEdge(int adj[][],int i, int j) {
        if (i>0&&i<11){
            if(j>0&&j<11){
                adj[i][j] = j;
            }
        }
    }
}