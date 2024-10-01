/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author Matija Risek
 */
public class JavaApplication2 {

    Vector vec = new Vector();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaApplication2 app = new JavaApplication2();
        app.upisPodataka();
        app.ispisPodataka();
    }
    
    void upisPodataka() {
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Upišite podatke o osobama");
            for (int x = 1; x <= 3; x++) {
                System.out.println("Upis " + x + ". osobe: ");
                Osoba osoba = new Osoba();
                System.out.print("Unesite ime " + x + ". osobe: ");
                osoba.setIme(bufferRead.readLine());
                System.out.print("Unesite prezime " + x + ". osobe: ");
                osoba.setPrezime(bufferRead.readLine()); 
                System.out.print("Unesite godine " + x + ". osobe: ");
                String god = bufferRead.readLine();            
                osoba.setGodina(Integer.parseInt(god));
                System.out.print("Unesite spol " + x + ". osobe: ");
                osoba.setSpol(bufferRead.readLine().charAt(0));
                vec.add(osoba);
            }
        } catch(IOException e) {
            e.printStackTrace();  
        }  
    }

    private void ispisPodataka() {
        for (int x = 0; x <= 2; x++) {
            Osoba o = (Osoba)vec.get(x);
            o.ispis();
        }
    }

}
