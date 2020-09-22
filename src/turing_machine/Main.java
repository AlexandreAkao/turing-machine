package turing_machine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br;

        String path = "F:\\Projetos\\Faculdade\\TuringMachine\\src\\ex3.mt";

        br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO_8859_1"));

        TuringMachine TM = new TuringMachine(br);

        validate(TM.run());
    }

    private static void validate(boolean flag) {
        if (flag) {
            System.out.println("Reconheceu");
        } else {
            System.out.println("Nao reconheceu");
        }
    }
}
