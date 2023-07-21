public class typepromoting {
    public static void main(String[] args) {
        char a = 'a';
        short b = 3;
        int c = a + b;
        System.out.println(c);

        int d = 12;
        long e = 13;
        float f = 17.7f;
        double g = 15.15;
        double ans = (d + e + f + g);
        System.out.println(ans);

        byte p = 5;
        byte q = (byte)(p * 2);
        System.out.println(q);
        
    }
    
}
