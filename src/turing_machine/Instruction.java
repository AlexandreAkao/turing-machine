package turing_machine;

public class Instruction {
    private int currentState;
    private int nextState;
    private char writeChar;
    private char readChar;
    private boolean direction;

    public Instruction(int currentState, char readChar, int nextState, char writeChar, boolean direction) {
        this.currentState = currentState;
        this.nextState = nextState;
        this.writeChar = writeChar;
        this.readChar = readChar;
        this.direction = direction;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public int getNextState() {
        return nextState;
    }

    public void setNextState(int nextState) {
        this.nextState = nextState;
    }

    public char getWriteChar() {
        return writeChar;
    }

    public void setWriteChar(char writeChar) {
        this.writeChar = writeChar;
    }

    public char getReadChar() {
        return readChar;
    }

    public void setReadChar(char readChar) {
        this.readChar = readChar;
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public boolean validate(int currentStateValid, char readCharValid) {
        return currentStateValid == this.currentState && readCharValid == this.readChar;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "currentState=" + currentState +
                ", nextState=" + nextState +
                ", writeChar=" + writeChar +
                ", readChar=" + readChar +
                ", direction=" + direction +
                '}';
    }
}
