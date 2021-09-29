package hu.petrik;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Bejegyzes> bejegyzesLista = new ArrayList<>();

    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Peti", "Szia Jancsi, mikor jossz at?");
        bejegyzesLista.add(b1);
        Bejegyzes b2 = new Bejegyzes("Jancsi", "Ma nem tudok, anya nem engedi.");
        bejegyzesLista.add(b2);

        //BejegyzesBekeres();
        Beolvasas("bejegyzesek.txt");
        RandomLikeok();
        BejegyzesModositas();
    }

    static void BejegyzesBekeres() {
        System.out.print("Kérem adja meg mennyi bejegyzést szeretne felvenni: ");
        int valasz = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < valasz; i++) {
            System.out.print("\nKi a szerzo: ");
            String szerzo = sc.nextLine();
            System.out.print("\nMi a tartalom: ");
            String tartalom = sc.nextLine();
            bejegyzesLista.add(new Bejegyzes(szerzo, tartalom));
        }
    }

    static void Beolvasas(String path) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String[] data;
            String line = br.readLine();
            while (line != "") {
                data = line.split(";");
                bejegyzesLista.add(new Bejegyzes(data[0], data[1]));
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void RandomLikeok() {
        Random rnd = new Random();
        for (int i = 0; i < bejegyzesLista.size() * 20; i++) {
            bejegyzesLista.get(rnd.nextInt(bejegyzesLista.size())).like();
        }
    }

    static void BejegyzesModositas() {
        System.out.print("Melyik bejegyzést szeretné módosítani? ");
        int valasz = Integer.parseInt(sc.nextLine());
        System.out.println(bejegyzesLista.get(valasz));
        System.out.println("Mire szeretné szerkeszteni? ");
        String szerkesztettTartalom = sc.nextLine();
        bejegyzesLista.get(valasz).setTartalom(szerkesztettTartalom);
        System.out.println(bejegyzesLista.get(valasz));
    }
}
