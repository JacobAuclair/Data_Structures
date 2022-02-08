
import java.util.*;

public class CirclularArray
{
    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> obj = new ArrayList<String>();
        int index = 0;
        final int arraymax = 9;
        boolean j = false;
        System.out.println("Enter a word to add to the circular array,");
        System.out.println("type \"!p\" to print the array, or \"!j\" to exit");
        while (j = false){
            if (scan.next() == ("!p")){
                System.out.println("Currently the array list has following elements:"+obj);
            }else if (scan.next() == ("!j")){
                j = true;
            }else{
                obj.remove(index);
                obj.add(index, scan.next());
                index++;
                if(index >arraymax){
                    index = 0;
                }
            }
        }
    }
}

