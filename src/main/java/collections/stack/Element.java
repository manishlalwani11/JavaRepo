package collections.stack;

public class Element<T> {
    private T data;
    private Element<T> nextElement;

    Element(T data, Element<T> element) {
        this.data = data;
        this.nextElement = element;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Element<T> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Element nextElement) {
        this.nextElement = nextElement;
    }

    @Override
    public String toString() {
        return "Element{" +
                "data=" + data +
                '}';
    }
}
