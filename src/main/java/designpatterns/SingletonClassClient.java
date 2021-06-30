package designpatterns;

import java.lang.reflect.InvocationTargetException;

public class SingletonClassClient {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        SingletonSample singletonSample = SingletonSample.getInstance();
        singletonSample.printHashCode();

        SingletonSample singletonSample1 = SingletonSample.getInstance();
        singletonSample1.printHashCode();

    }
}
