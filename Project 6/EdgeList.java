import java.util.*;
import java.lang.*;

public class EdgeList
{
    public void main (String args[]){
        EdgeList el = new EdgeList();
        Scanner scan = new Scanner(System.in);
        int a,b;
        if (scan.next() == ("add")){
            a = scan.nextInt();
            b = scan.nextInt();
            addEdge(el,a,b);
        }else if(scan.next() == ("remove")){
            a = scan.nextInt();
            b = scan.nextInt();
            removeEdge(el,a,b);
        }
    }

    void addEdge(EdgeList el, int a, int b){
        addEdge(el,a,b);
    }

    void removeEdge(EdgeList el, int a, int b){
        removeEdge(el,a,b);
    }
    
    public java.lang.String toString(EdgeList el){
        System.out.println(el);
        return ("done");
    }
}
