public class NumberAndPointer{
    private int number;
    private NumberAndPointer next;

    public NumberAndPointer(int number, NumberAndPointer next) {
        this.number = number;
        this.next = next;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public NumberAndPointer getNext() {
        return next;
    }

    public void setNext(NumberAndPointer next) {
        this.next = next;
    }
}
