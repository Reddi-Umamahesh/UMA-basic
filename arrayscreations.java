//package DSA;
//import java.util.*;

class arrayscreations{

    public static void update(int marks[]){
        for(int i=0;i<marks.length;i++){
            marks[i] = marks[i]+1;
        }

    }
    public static void main(String[] args){

    //datatype arrayname[] = new datatype[size];
    int marks[] = new int[5];
   // String fruits[] = {"mango","apple","banana"};
    marks[0]=98;
    marks[1]=99;
    update(marks);

    for(int i =0;i<marks.length-1;i++){
        System.out.print(marks[i]+" ");
    }System.out.println();

    //System.out.println("enter your marks");
    //Scanner sc = new Scanner(System.in);
   // marks[0] = sc.nextInt();
    //System.out.println(fruits.length);

    

    
    

    }

    
} 
