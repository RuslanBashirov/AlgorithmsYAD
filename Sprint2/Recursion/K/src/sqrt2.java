import java.text.DecimalFormat;

public class sqrt2 {
    public static final DecimalFormat df2 = new DecimalFormat( "0.00000" );
    public static void main(String[] args) {
        sqrt2(100);
    }

    static void sqrt2(double mid){
        if ((mid*mid < 2) && (mid+0.00001)*(mid+0.00001) > 2){
            System.out.println(df2.format(mid));
            return;
        }
            sqrt2((mid+2/mid)/2);
    }
}
