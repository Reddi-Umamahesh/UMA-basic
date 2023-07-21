class backtracking{

    public static void backtrackingarrays(int arr[],int i,int val){

        if(i==arr.length){
            printarray(arr);
            return;
            
        }
        arr[i] = val;
        backtrackingarrays(arr, i+1, val+1);
        arr[i]=val-2;

    }

    public static void subsets(String str,int i,String ans){
        if(i==str.length()){
           System.out.println(ans); 
           return;
        }
        //yes -- accepted
        subsets(str, i+1, ans+str.charAt(i));
        //no
        subsets(str, i+1, ans);
    }
    public static void printarray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }System.out.println();

    }

    public static void permutations(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String newstr = str.substring(0, i)+str.substring(i+1, str.length());
            permutations(newstr,ans+curr);
        }
    }

    static int count;

    public static boolean nqueens(char board[][],int row){
        if(row==board.length){
        count++;
        return true;
        }
        for(int j=0;j<board.length;j++){
          if(issafe(board,row,j)){
            board[row][j]= 'Q' ;
            if(nqueens(board, row+1)){
               return true;
            }
            board[row][j]= '.';
           
            }
        }
        return false;
        
    }

    public static void print(char board[][]){
        System.out.println("--------chess board----------");
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+ " ");
            }System.out.println();
        }
    }
    public static boolean issafe(char board[][], int row,int col){
        //vertically up 
        for(int i=row-1;i>=0;i--){
           if(board[i][col] == 'Q'){
                 return false;
           }
        }
        //diagonally leftup
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
           if(board[i][j] == 'Q'){
        return false;
              }
        }
    //diagonally rightup
    for(int i=row-1,j=col+1; i>=0 && j<board.length;i--,j++){
       if(board[i][j] == 'Q'){
       return false;
          }  
        }
        
    
    return true;
    }

    public static int gridways(int i,int j,int row,int col){
      // o(2^row+col)
        if(i==row-1 || j==col-1){
            return 1;
        }
        if(i==row || j == col){
          return 0;
        }
        int w1 = gridways(i+1, j, row, col);
        int w2 = gridways(i, j+1, row, col);
        return w1+w2;
    }

    



    public static void main(String[] args){
       System.out.println("hello, world!"); 
 //      int arr[] = new int[5];
   //    backtrackingarrays(arr, 0, 1);
     //  printarray(arr);
//      String str = "abc";
  //     subsets(str, 0, "");
//  permutations(str, "");
  char board[][] = new char[4][4];
for(int i=0;i<board.length;i++){
    for(int j=0;j<board.length;j++){
    board[i][j] ='.';
    }
}

/*   if(nqueens(board, 0)){
 System.out.println("solution exists");
 print(board);
} else{
//    System.out.println("solution doesn't exist");
} */
 //  System.out.println(gridways(0, 0, 3, 3));
    
    }
}