package turing_machine;

public class Tape {
    private char data;
    private Tape next;
    private Tape previous;

    public Tape() {
        this.data = '_';
    }

    public Tape(boolean isNext, Tape auxTape) {
        if (isNext) {
            this.previous = auxTape;
        } else {
            this.next = auxTape;
        }
        this.data = '_';
    }

    public Tape(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Tape getNext() {
        if (this.next == null) {
            this.next = new Tape(true, this);
        }

        return next;
    }

    public void setNext(Tape next) {
        this.next = next;
    }

    public Tape getPrevious() {
        if (this.previous == null) {
            this.previous = new Tape(false, this);
        }

        return previous;
    }

    public void setPrevious(Tape previous) {
        this.previous = previous;
    }
}
