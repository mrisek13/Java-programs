/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Vector;

/**
 *
 * @author Maja Risek
 */
public class JavaApplication2 {

    Vector vec = new Vector();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaApplication2 app = new JavaApplication2();
        app.upisPodataka();
        app.ispis();
        app.najstariji();
        app.odrediBrojSpolova('M');
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
            System.out.print("Unesite godinu rodjenja " + x + ". osobe: ");
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
        
    public void ispis(){
        System.out.println("\nISPIS PODATAKA");
        System.out.println("******************");
        for (int x = 0; x < vec.size(); x++) {
            Osoba osoba = (Osoba)vec.elementAt(x);
            osoba.ispis();
            System.out.println("");
        }
    }
    
    void najstariji() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int index = 0;
        int starost = 0;
        
        for (int x = 0; x < vec.size(); x++) {
            Osoba osoba = (Osoba)vec.elementAt(x);
            if(starost < year - osoba.getGodina()){
                starost = year - osoba.getGodina();
                index = x;
            }
        }
        
        System.out.println("\nNajstarija osoba");
        Osoba osoba = (Osoba)vec.elementAt(index);
        osoba.ispis();
    }

    void odrediBrojSpolova(char spol) {
        System.out.println("\nOsobe traženog spola");
        System.out.println("******************");
        int brojac = 0;
        for (int x = 0; x < vec.size(); x++) {
            Osoba osoba = (Osoba)vec.elementAt(x);
            if(osoba.getSpol() == spol){
                brojac++;
            }
        }
        System.out.println("Broj osoba: " + brojac);   
    }


}
