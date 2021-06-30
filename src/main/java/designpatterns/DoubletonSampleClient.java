package designpatterns;

public class DoubletonSampleClient {

    public static void main(String[] args) {

        // We can see only 2 hascodes are getting printed

        DoubletonSample obj1 = DoubletonSample.getInstance();
        System.out.println("Hashcode obj1: "+obj1);

        DoubletonSample obj2 = DoubletonSample.getInstance();
        System.out.println("Hashcode obj1: "+obj2);

        DoubletonSample obj3 = DoubletonSample.getInstance();
        System.out.println("Hashcode obj1: "+obj3);

        DoubletonSample obj4 = DoubletonSample.getInstance();
        System.out.println("Hashcode obj1: "+obj4);





    }
}
