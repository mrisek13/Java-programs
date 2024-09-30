package vjezba_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

public class Vjezba_01 {

    Vector vec = new Vector();

    public static void main(String[] args) {
        Vjezba_01 App = new Vjezba_01();
        System.out.println(Vjezba_01.class.getResource(""));
        
        App.upisPodataka();
        App.ispisVektor();
    }

    void ispisVektor() {
        for (int x = 0; x <vec.size(); x++) {
         Student data = (Student)vec.elementAt(x);
         data.ispis();
        }
    }
  
    void upisPodataka() {
        String path = getClass().getClassLoader().getResource(".").getPath();
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Upišite podatke o osobama");
            for (int x = 1; x <= 3; x++) {
                System.out.println("Upis " + x + ". osobe:");
                Osoba osoba = new Osoba();
                System.out.print("Ime:");
                osoba.setIme(bufferRead.readLine());
                System.out.print("Prezime:");
                osoba.setPrezime(bufferRead.readLine());
                System.out.print("Godina roðenja:");
                String god = bufferRead.readLine();
                osoba.setGodina(Integer.parseInt(god));
                System.out.print("Spol:");
                osoba.setSpol(bufferRead.readLine().charAt(0));
                vec.add(osoba);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void upisPodatakaStudent() {
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Upišite podatke o osobama");
            for (int x = 1; x <= 1; x++) {
                System.out.println("Upis " + x + ". osobe:");
                Student student = new Student();
                System.out.print("Ime:");
                student.setIme(bufferRead.readLine());
                System.out.print("Prezime:");
                student.setPrezime(bufferRead.readLine());
                System.out.print("Naziv studija:");
                student.setNazivStudija(bufferRead.readLine());
                System.out.print("Godina studija:");
                String god = bufferRead.readLine();
                student.setGodinaStudija(Integer.parseInt(god));
                vec.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    void upisPodatakaScaner() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Upišite podatke o osobama");
            for (int x = 1; x <= 3; x++) {
                System.out.println("Upis " + x + ". osobe:");
                Osoba osoba = new Osoba();
                osoba.setIme(in.nextLine());
                osoba.setPrezime(in.nextLine());
                osoba.setGodina(in.nextInt());
                osoba.setSpol(in.nextLine().charAt(0));
                vec.add(osoba);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        in.close();
    }
}
