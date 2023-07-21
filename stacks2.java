import java.util.Stack;

public class stacks2 {

    public static void stockspan(int stocks[],int span[]){
        Stack <Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1;i<stocks.length;i++){
            int curr = stocks[i];
            while(!s.isEmpty() && curr>stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else {
                int prevh = s.peek();
                span[i] = i-prevh;
            }
            s.push(i);
        }
    }

    public static void Nextgreater(int arr[]){
        int nxtgt[] = new int[arr.length];
        Stack <Integer> s = new Stack<>();
        for(int i=arr.length-1,j=arr.length-1;i>=0;j--,i--){
        while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
            s.pop();
        }
        if(s.isEmpty()){
            nxtgt[j] = -1;
        }else{
            nxtgt[j] = arr[s.peek()];    
        }
        s.push(i);
    }
        for(int i=0;i<nxtgt.length;i++){
            System.out.print(nxtgt[i]+" ");
        }
    }

    public static boolean validparmeters(String str){
        Stack <Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(isopen(str.charAt(i))){
                s.push(str.charAt(i));
            }if(isclose(str.charAt(i))){
                if(s.isEmpty()){
                    System.out.println("Invalid parameters");
                    return false;
                }
                if(ispair(str.charAt(i), s.peek())){
                    s.pop();
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isopen(char a){
        if(a== '['||a=='{'||a=='('){
            return true;
        }
        return false;
    }
    public static boolean isclose(char a){
        if(a==']'||a=='}'||a==')'){
            return true;
        }
        return false;
    }
    public static boolean ispair(char a , char b){
        if(b== '(' && a ==')'){
            return true;
        }
        if(b=='['&&a==']'){
            return true;
        }
        if(b=='{'&&a=='}'){
            return true;
        }
        return false;
    }

    public static boolean isDuplicateparenthisis(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            
            //closing
            if(ch==')'){
                int count=0;
                while(s.peek()!='('){
                    count++;
                    s.pop();
                }
                if(count<1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
   

    public static void Maxarea(int arr[],int width){
        int[] max = new int[arr.length];
            for(int i=0;i<arr.length;i++){
         int leftmax= checkleft(arr, i);
         int rightmax = checkright(arr, i);
         max[i] = (rightmax-leftmax-1) * arr[i];
        }
        
        for (int i = 0; i < max.length; i++){
        System.out.print(max[i]+" ");
    }
    
    }

    public static int checkleft(int arr[],int i){
        int lm = arr[i];
        int j;
        for( j=i;j>=0;j--){
            if(arr[j]<lm){
                return j;
            }
        }
        return j;
    }
    public static int checkright(int arr[],int i){
        int rm = arr[i];
        int j;
        for( j=i;j<arr.length;j++){
            if(arr[j]<rm){
                return j;
            }
        }
        return j;
    }
    public static void main(String args[]){
        int stocks[] = {100,80,60,70,60,85,100};
        int span[] = new int[stocks.length];
        // stockspan(stocks,span);
        // System.out.println("Span of stock is ");
        // for(int i=0;i<span.length;i++){
        //     System.out.print(span[i]+" ");
        // }

        int arr[] = {7,1,0,3,2,6};
  //      Nextgreater(arr);
        String str = "([{}]())";
      //  System.out.println(validparmeters(str));

        String str1 = "((a+b))";
        String str2 = "(a+b)";
      //  System.out.println(isDuplicateparenthisis(str1));

        int height[] = {2,4};
        Maxarea(height, 1);// write optimised code again

    }
    
}
