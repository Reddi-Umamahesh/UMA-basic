//package DSA;
import java.util.*;
public class strings {
    public static void main(String args[]){
     //creating strings
    //  String name1 = "umamahesh"; 
     Scanner sc = new Scanner(System.in);
      String line = sc.nextLine();
 //    String name2 = sc.nextLine();
 //    System.out.println(palindrome(name2)); 
//   displacement(name2);
//    String s1 = "umamahesh";
//    String s2 = "Reddiumamahesh";
//    System.out.println(s1.equals(s2));
//    System.out.println(s2.compareTo(s1));
sc.close();
//string bulider 
// StringBuilder sb = new StringBuilder("");
// for(char ch='A';ch<='Z';ch++){
//     sb.append(ch);
// } 
// System.out.print(sb);
//    StringBuilder sb = new StringBuilder();
 //     System.out.print(to_upper_case(line));
    System.out.print(string_compression(line));
    
    }

    //palindrome
    public static boolean palindrome(String name){
        for(int i=0;i<name.length()/2;i++){
            if(name.charAt(i)!=name.charAt(name.length()-1-i)){
         return false;
            }
        }return true;
    }

    //
    public static void displacement(String directions){

      int x =0,y=0;
      for(int i=0;i<directions.length();i++){
        if(directions.charAt(i)=='e'){
            x++;
        }
        if(directions.charAt(i)=='w'){
            x--; 
        }
        if(directions.charAt(i)=='n'){
            y++;
        }
        if(directions.charAt(i)=='s'){
            y--; 
        }
      }  
      int x2 = x*x;
      int y2 = y*y;
      System.out.println(x2);
      System.out.println(y2);
      double disp = Math.sqrt(x2+y2);
      System.out.println(disp);
    }
   
    public static String to_upper_case(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1;i<str.length();i++){
       if(str.charAt(i)==' '&& str.length()-1>i){
        sb.append(str.charAt(i));
        i++;
        sb.append(Character.toUpperCase(str.charAt(i)));
       }else{
        sb.append(str.charAt(i));
       }

        }
        return sb.toString();
    }

    //string compresion
    public static String string_compression(String str){
        StringBuilder newstr = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            Integer count = 1;
            while(str.charAt(i)==str.charAt(i+1) && str.length()-1>i){
                count++;
                i++;
            }
            newstr.append(str.charAt(i));
        if(count >1){
            newstr.append(count.toString());
        }
        }
        return newstr.toString();
    }

   

    


    


    
    
}
