package designpatterns;

public class SingletonSample {

    private static SingletonSample singletonInstance = new SingletonSample();

    private SingletonSample(){

    }

    public static SingletonSample getInstance() {
        return singletonInstance;
    }

    public void printHashCode(){
        System.out.println("printHashCode of SingleTon: " + singletonInstance);
    }

}
