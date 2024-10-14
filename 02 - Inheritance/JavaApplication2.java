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
    Vector vecStudent = new Vector();
    Vector vecRadnik = new Vector();
        
    void upisPodataka() {
        try {
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

    void upisStudenata(int broj) {
        try
        {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Upišite podatke o studentima:");
            
            for(int x=1; x<=broj; x++)
            {
                System.out.println("Upis " + x + ". studenta:");
                Student student = new Student();
                
                System.out.println("Ime:");
                student.setIme(bufferRead.readLine());
                
                System.out.println("Prezime:");
                student.setPrezime(bufferRead.readLine());
                
                System.out.println("Godina roðenja:");
                String rod = bufferRead.readLine();
                student.setGodina(Integer.parseInt(rod));
                
                System.out.println("Spol:");
                student.setSpol(bufferRead.readLine().charAt(0));
                
                System.out.println("Naziv studija:");
                student.setNazivStudija(bufferRead.readLine());
     
                System.out.println("Godina studija:");
                String god = bufferRead.readLine();
                student.setGodinaStudija(Integer.parseInt(god));
                
                System.out.println("JMBAG:");
                String mat = bufferRead.readLine();
                student.setMBS(Integer.parseInt(mat));

                vecStudent.add(student);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
        
    void upisRadnika(int broj) {
        try
        {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Upišite podatke o radnicima:");
            
            for(int x=1; x<=broj; x++)
            {
                System.out.println("Upis " + x + ". radnika:");
                Radnik radnik = new Radnik();
                
                System.out.println("Ime:");
                radnik.setIme(bufferRead.readLine());
                
                System.out.println("Prezime:");
                radnik.setPrezime(bufferRead.readLine());
                
                System.out.println("Godina roðenja:");
                String rod = bufferRead.readLine();
                radnik.setGodina(Integer.parseInt(rod));
                
                System.out.println("Spol:");
                radnik.setSpol(bufferRead.readLine().charAt(0));
                
                System.out.println("Naziv poduzeca:");
                radnik.setNazivPoduzeca(bufferRead.readLine());
                
                System.out.println("Radno mjesto:");
                radnik.setRadnoMjesto(bufferRead.readLine());
                
                System.out.println("Godina radnog staza:");
                String staz = bufferRead.readLine();
                radnik.setGodinaRadnogStaza(Integer.parseInt(staz));

                vecRadnik.add(radnik);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }      
    }
        
        
    public void ispisOsoba() {
        System.out.println("");
        System.out.println("ISPIS OSOBA:");
        System.out.println("******************");
        
        for(int x=0; x<vec.size(); x++)
        {
            Osoba osoba = (Osoba)vec.elementAt(x);
            osoba.ispis();
            System.out.println("");
        }
    }
    
    public void ispisStudenata() {
        System.out.println("");
        System.out.println("ISPIS STUDENATA:");
        System.out.println("******************");
        
        for(int x=0; x<vecStudent.size(); x++)
        {
            Osoba osoba = (Osoba)vecStudent.elementAt(x);
            osoba.ispis();
            System.out.println("");
        }
    }
        
    public void ispisRadnika()
    {
        System.out.println("");
        System.out.println("ISPIS RADNIKA:");
        System.out.println("******************");
        
        for(int x=0; x<vecRadnik.size(); x++)
        {
            Osoba osoba = (Osoba)vecRadnik.elementAt(x);
            osoba.ispis();
            System.out.println("");
        }
    }    
    
    void odrediStudenteGodinaStudija(int godina)
    {
        try{
            System.out.println("Studenti trazene godine:");
            System.out.println("**************************");

            for(int x=0; x<vecStudent.size(); x++)
            {
                Student student = (Student)vecStudent.elementAt(x);
                if(student.getGodinaStudija()==godina)
                {
                    student.ispis();
                    System.out.println("");
                }
        }
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
    public static void main(String[] args) {
        
        JavaApplication2 App = new JavaApplication2();
        int broj = 2;
        int godina = 3;
        
        App.upisPodataka();
        App.upisStudenata(broj);
        App.upisRadnika(broj);
        App.ispisOsoba();
        App.ispisRadnika();
        App.ispisStudenata();
        App.odrediStudenteGodinaStudija(godina);
    }
}
