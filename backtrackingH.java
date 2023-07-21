public class backtrackingH {

    public static int Rat_in_maze(int i,int j,int row,int col){
        // o(2^row+col)
          if(i==row-1 || j==col-1 ){
           System.out.println(i+"  "+j);
              return 1;
            
          }
          
          int w1 = Rat_in_maze( i+1, j, row, col);
          System.out.println("XXXX");
        int w2 = Rat_in_maze( i, j+1, row, col);
        System.out.println("----");
          return w1+w2;
      }
  
    public static void main(String[] args){

        int maze[][] = new int[4][4];
        maze[1][0] = 0;
        maze[1][2]= 0;
        maze[3][1]=0;             
           System.out.println(Rat_in_maze(0,0, 3, 3));

    }

}
