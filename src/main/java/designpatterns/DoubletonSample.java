package designpatterns;

/**
 Similarly we can create Tripleton, quadraton ...  xxxton classes.
 */
public class DoubletonSample {

    private static DoubletonSample doubletonInstance1;
    private static DoubletonSample doubletonInstance2;

    private DoubletonSample() {

    }


    // Factory method
    public static DoubletonSample getInstance() {
        if (doubletonInstance1 == null) {
            doubletonInstance1 = new DoubletonSample();
            return doubletonInstance1;
        } else if (doubletonInstance2 == null) {
            doubletonInstance2 = new DoubletonSample();
            return doubletonInstance2;
        } else {
            if (Math.random() < 0.5) {
                return doubletonInstance1;
            } else {
                return doubletonInstance2;
            }
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
