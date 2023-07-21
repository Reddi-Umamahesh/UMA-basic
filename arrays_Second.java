//package DSA;
//import java.util.*;


public class arrays_Second {

  public static void main(String args[]){
    int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
   // diagonalsum(matrix);
 //   optimised_diagonalsum(matrix);
   // printing_spiral(matrix);
   search(matrix, 10);
  }

  public static void diagonalsum(int matrix[][]){
    int sum1=0;
    int sum2=0;
  for(int i =0;i<matrix.length;i++){
    for(int j=0;j<matrix[0].length;j++){
      if(i==j){
     sum1+=matrix[i][j];
      }
      else if((i+j)==(matrix.length)-1){
        sum2+=matrix[i][j];
      }
    } }
  int sum = sum1+sum2;
  System.out.println(sum);
  //time complexicty = o(n2) 
  }

  public static void optimised_diagonalsum(int matrix[][]){
    int sum1=0;
    int sum2=0;
   for(int i=0;i<matrix.length;i++){
    sum1 += matrix[i][i];
    sum2 += matrix[i][matrix.length-1-i];
   }int sum = sum1+sum2;
   System.out.println(sum);
   //T.C = o(n)
  }

 
  public static void printing_spiral(int matrix[][]){
  
    int startrow = 0;
    int endrow = matrix.length-1;
    int startcoloum =0;
    int endcoloum = matrix[0].length-1;

    while(startrow<=endrow && startcoloum<=endcoloum){

      //top
      for(int j=startcoloum;j<=endcoloum;j++){
        System.out.print(matrix[startrow][j]+" ");
        }
     
      //right
      for(int i =startrow+1;i<=endrow;i++){
        System.out.print(matrix[i][endcoloum]+" ");
      }
      //bottom
      for(int j=endcoloum-1;j>=startcoloum;j--){
    System.out.print(matrix[endrow][j]+" ");
      }
      //left
      for(int i =endcoloum-1;i>startcoloum;i--){
        System.out.print(matrix[i][startcoloum]+" ");
      }
      startrow++;
      startcoloum++;
      endcoloum--;
      endrow--;
    }
  }

  public static boolean search(int matrix[][],int key){
    //bruteforce method - check all the numbers tc=o(n2)
    //row wise binary search  tc = nlog(n)
    //staircase method is the best  but in a sorted matrix

   int row = matrix.length-1;
   int col = 0;

  while(col<=matrix[0].length-1 && row>=0){
     if(key == matrix[row][col]){
     System.out.print("key found at matrix["+row+"]["+col+"]");
     return true;
     }
     else if(key> matrix[row][col]){
     col++;
     }
     else if(key<matrix[row][col]){
      row--;
     }
  }
  System.out.println("key not found ");
  return false;

  }

}