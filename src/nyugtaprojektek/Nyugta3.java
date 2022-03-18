package nyugtaprojektek;

import java.util.ArrayList;

/* Probléma:
tüntessük el a kézzel beírt szóközöket,
a huf ne tartalmazzon eurót
a kedvezmény helyett legyen szervízdíj, amit hozzá kell adni a végössdzeghez
*/
public class Nyugta3 {
    
    static String csillagok = "********************";
    static String duplaVonal = "====================";
    static String szaggatottVonal = "--------------------";
    static final String eur = "\u20ac";
    static final String HUF = "Ft";
    public static void main(String[] args) {
        System.out.println(csillagok);
        System.out.printf("%14s\n", "Nyugta 3");
        System.out.println(csillagok);
        
        
        
        int tetel1 = 350, tetel2 = 90, tetel3 = 1320;
        ArrayList<Integer> tetelek = new ArrayList<>();
        tetelek.add(tetel1);
        tetelek.add(tetel2);
        tetelek.add(tetel3);
        tetelekKiirasa(tetelek, HUF);
//        kiiras("Tétel 1", tetel1, HUF);
//        kiiras("Tétel 2", tetel2, HUF);
//        kiiras("Tétel 3", tetel3, HUF);

        
        System.out.println(duplaVonal);
        
        
        int osszesen = tetel1 + tetel2 + tetel3;

        
        kiiras("Összesen", osszesen, HUF);
        
        
        System.out.println(szaggatottVonal);
        
        int szervizDijMertek = 10;
        int szervizDij = osszesen / szervizDijMertek;
        
        kiiras("Szervízdíj", szervizDij, HUF);
        System.out.printf("(%d%%)\n", szervizDijMertek);
        
        System.out.println(duplaVonal);
        
       
        int fizetendo = osszesen + szervizDij;
        
        kiiras("Fizetendő", fizetendo, HUF);
        double euro = fizetendo / 350.0;
        

        
        /* 7.2 7 szélesen 2 tizedessel,a max: 1234.99
        *  a %10s  egy "" -t ír ki, ezzel tolom beljebb
        */
        System.out.printf("%10s%7.2f %s\n","", euro, eur);//
        alaIras();
    }

    
    static void kiiras(String szoveg1, int szoveg2, String szoveg3){
        String tetelKiForm = "%10s: %5d %s\n";
        System.out.printf(tetelKiForm, szoveg1, szoveg2, szoveg3);
    }
    static void tetelekKiirasa(ArrayList<Integer> tetelek, String tipus){
        int listaHossza = tetelek.size();
        
        for (int i = 0; i < listaHossza; i++) {
            String hanyTetel = "Tétel"+(i+1);
            kiiras(hanyTetel, tetelek.get(i), tipus);
        }
    }
    
    static void alaIras() {
        System.out.println(szaggatottVonal);
        System.out.println("");
        String rovidVonal = "_______";
        System.out.print(rovidVonal);
        String rovidVonalValaszto = "      ";
        System.out.print(rovidVonalValaszto);
        System.out.println(rovidVonal);
        System.out.print(" Dátum");
        System.out.print(rovidVonalValaszto);
        System.out.println("   Név");
        System.out.println(csillagok);    
        System.out.printf("%8s\n","CÉG");
        System.out.println(csillagok);
    }
}
