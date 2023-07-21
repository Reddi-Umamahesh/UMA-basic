public class factorial {
    public static int factrial(int n) {
       int f = 1;
        for(int i = 1; i <= n; i++){
            f = f * i;
        }
        return f;    
        }
        public static int bincoff(int n, int r) {
            int fact_n = factrial(n);
            int fact_r = factrial(r);
            int fact_nmr = factrial(n - r);
            int bincoff = fact_n / (fact_r*fact_nmr);
            return bincoff;
        }
    
    public static void main(String[] args) {
        int a = 12;
        int f = factrial(a);
        System.out.println("factorial = " + f);
        System.out.println(factrial(5));

        System.out.println(bincoff(5, 2));

    }
    
}
