
import java.util.*;

public class RedBlueStack
{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        double RedBlue[];
        RedBlue = new double[20];
        int redpoint = 0;
        int bluepoint = 19;
        int temp = 0;
        int i = 0;
        System.out.println("please enter \"red\" or \"blue\"");
        if (scan.hasNext("red")){
            System.out.println("please enter \"pop\" or a double perceision number");
            if (scan.hasNext("pop")){
                redpop(RedBlue, redpoint);
                redpoint--;
            }else{
                if (redpoint == bluepoint){
                    System.out.println("stack full, pop first");
                }else{
                    try{
                        temp = scan.nextInt();
                        redadd(RedBlue, redpoint, temp);
                        redpoint++;
                    }catch(Exception e){}
                }
            }
        }else if (scan.hasNext("blue")){
            System.out.println("please enter \"pop\" or a double perceision number");
            if (scan.hasNext("pop")){
                bluepop(RedBlue, bluepoint);
                bluepoint--;
            }else{
                if (bluepoint == redpoint){
                    System.out.println("stack full, pop first");
                }else{
                    try{
                        temp = scan.nextInt();
                        blueadd(RedBlue, bluepoint, temp);
                        bluepoint--;
                    }catch(Exception e){}
                }
            }
        }
    }

    public static double[] redpop(double RedBlue[], int redpoint){
        RedBlue[redpoint] = 0;
        return RedBlue;
    }

    public static double[] bluepop(double RedBlue[], int bluepoint){
        RedBlue[bluepoint] = 0;
        return RedBlue;
    }

    public static double[] redadd(double RedBlue[], int redpoint, int temp){
        RedBlue[redpoint] = temp;
        return RedBlue;
    }

    public static double[] blueadd(double RedBlue[], int bluepoint, int temp){
        RedBlue[bluepoint] = temp;
        return RedBlue;
    }
}
