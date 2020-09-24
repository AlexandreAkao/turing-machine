package turing_machine;

import java.io.*;
import java.util.*;

public class TuringMachine {
    protected int q = 0;
    protected Tape firstHead;
    protected Tape lastHead;
    protected Tape head;
    protected String initTapeWord;
    protected Set<Integer> F = new HashSet<>();
    protected Map<Integer, Instruction> sigma = new HashMap<>();

    public TuringMachine() {}

    public TuringMachine(BufferedReader file) {
        readFile(file);
    }

    private void readFile(BufferedReader file) {
        try {
            while (file.ready()) {
                String line = file.readLine();

                if (!line.equals("")) {
                    if (line.contains("fita")) {
                        this.initTapeWord = line.substring(5);
                    } else if (line.contains("init")) {
                        this.q = Integer.parseInt(line.substring(6));
                    } else if (line.contains("accept")) {
                        String acceptLine = line.substring(7);
                        String[] acceptStates = acceptLine.split(",");

                        int[] acceptStateInt = new int[acceptStates.length];

                        for (int i = 0; i < acceptStates.length; i++) {
                            acceptStateInt[i] = Integer.parseInt(acceptStates[i].trim().substring(1));
                        }

                        setF(acceptStateInt);
                    } else if (line.substring(0, 1).equals("q")) {
                        String[] instructionData = line.split(",");

                        Instruction newInstruction = new Instruction(
                            Integer.parseInt(instructionData[0].substring(1)),
                            instructionData[1].charAt(0),
                            Integer.parseInt(instructionData[2].substring(1)),
                            instructionData[3].charAt(0),
                            instructionData[4].equals(">")
                        );

                        setSigma(newInstruction);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("ERROR!!");
            System.out.println("Reiniciar aplicacao!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setF(int[] endStates) {
        F.clear();

        for (int endState : endStates) {
            F.add(endState);
        }
    }

    private void setSigma(Instruction symbols) {
        sigma.put(this.sigma.size(), symbols);
    }

    private Instruction getInstruction(int currentStateValid, char readCharValid) {
        Instruction validInstruction = null;

        for (int i = 0; i < this.sigma.size(); i++) {
            if (this.sigma.get(i).validate(currentStateValid, readCharValid)) {
                return this.sigma.get(i);
            }
        }

        return validInstruction;
    }

    public boolean run() {
        this.fillTape(initTapeWord);
        System.out.println("---------------------------------");
        System.out.println("Fita Inicial: " + this.initTapeWord);

        while (!F.contains(q)) {
            Instruction currentInstruction = getInstruction(q, head.getData());

            if (currentInstruction == null) {
                System.out.println("Instrucao invalida");
                return false;
            }

            consome(currentInstruction);

            head.setData(currentInstruction.getWriteChar());
            this.q = currentInstruction.getNextState();

            if (currentInstruction.getDirection()) {
                Tape next = this.head.getNext();

                if (this.head == this.lastHead && next.getData() != '_') {

                    this.lastHead = next;
                }

                if (this.head == this.firstHead && this.head.getData() == '_') {
                    this.firstHead = next;
                }

                this.head = next;
            } else {
                Tape previous = this.head.getPrevious();

                if (this.head == this.firstHead && previous.getData() != '_') {

                    this.firstHead = previous;
                }

                if (this.head == this.lastHead && this.head.getData() == '_') {
                    this.lastHead = previous;
                }

                this.head = previous;
            }
        }

        System.out.print("Fita Final: ");
        printTape();
        System.out.println("---------------------------------");

        return true;
    }

    private void fillTape(String w) {
        char[] listChar = w.toCharArray();
        this.head = new Tape();
        this.firstHead = head;
        Tape headAux = head;

        for (int i = 0; i < listChar.length; i++) {
            if (i == listChar.length - 1) {
                this.lastHead = headAux;
            }

            headAux.setData(listChar[i]);
            headAux = headAux.getNext();
        }
    }

    private void printTape() {
        Tape auxTape = this.firstHead;

        while (auxTape.getPrevious() != this.lastHead) {
            System.out.print(auxTape.getData());
            auxTape = auxTape.getNext();
        }
        System.out.println();
    }

    private void consome(Instruction instruction) {
        Tape auxTape = this.firstHead;

        System.out.print("Estado inicial: " + instruction.getCurrentState() + " |==      ");

        while (auxTape != this.head && this.head != auxTape.getPrevious()) {
            System.out.print(auxTape.getData());
            auxTape = auxTape.getNext();
        }

        System.out.print(" [" + instruction.getReadChar() + " -> " + instruction.getWriteChar() + "] ");

        if (auxTape.getPrevious() != this.lastHead) {
            auxTape = auxTape.getNext();
        }

        while (auxTape.getPrevious() != this.lastHead && this.firstHead != this.lastHead) {
            System.out.print(auxTape.getData());
            auxTape = auxTape.getNext();
        }

        System.out.print("      ==| Estado final: " + instruction.getNextState() + " ");
        System.out.println(instruction.getDirection() ? "  ====>" : "  <====");

        System.out.println();
    }
}
