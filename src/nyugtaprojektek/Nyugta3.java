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
        fejlec();

        int tetel1 = 350, tetel2 = 90, tetel3 = 1320;
        ArrayList<Integer> tetelek = new ArrayList<>();
        tetelek.add(tetel1);
        tetelek.add(tetel2);
        tetelek.add(tetel3);

        nyugtaTorzs(tetelek);


        /* 7.2 7 szélesen 2 tizedessel,a max: 1234.99
        *  a %10s  egy "" -t ír ki, ezzel tolom beljebb
         */
        alaIras();
    }

    static void kiiras(String szoveg1, int szoveg2, String szoveg3) {
        String tetelKiForm = "%10s: %5d %s\n";
        System.out.printf(tetelKiForm, szoveg1, szoveg2, szoveg3);
    }

    static void tetelekKiirasa(ArrayList<Integer> tetelek, String tipus) {
        int listaHossza = tetelek.size();

        for (int i = 0; i < listaHossza; i++) {
            String hanyTetel = "Tétel" + (i + 1);
            kiiras(hanyTetel, tetelek.get(i), tipus);
        }
    }

    static void alaIras() {
        String rovidVonal = "_______";
        String rovidVonalValaszto = "      ";

        System.out.println(szaggatottVonal);
        System.out.println("");
        System.out.print(rovidVonal);
        System.out.print(rovidVonalValaszto);
        System.out.println(rovidVonal);
        System.out.print(" Dátum");
        System.out.print(rovidVonalValaszto);
        System.out.printf("%6s\n", "Név");
        System.out.println(csillagok);
        System.out.printf("%12s\n", "CÉG");
        System.out.println(csillagok);
    }

    private static void kifizetKiir(int fizetendo) {
        kiiras("Fizetendő", fizetendo, HUF);
        double euro = fizetendo / 350.0;
        System.out.printf("%10s%7.2f %s\n", "", euro, eur);
    }

    static void fejlec() {
        System.out.println(csillagok);
        System.out.printf("%14s\n", "Nyugta 3");
        System.out.println(csillagok);

    }

    private static void nyugtaTorzs(ArrayList<Integer> tetelek) {
        int osszesen = sum(tetelek);
        int szervizDijMertek = 10;
        int szervizDij = osszesen / szervizDijMertek;
        int fizetendo = osszesen + szervizDij;

        tetelekKiirasa(tetelek, HUF);
        System.out.println(duplaVonal);
        kiiras("Összesen", osszesen, HUF);
        System.out.println(szaggatottVonal);
        kiiras("Szervízdíj", szervizDij, HUF);
        System.out.printf("(%d%%)\n", szervizDijMertek);
        System.out.println(duplaVonal);
        kifizetKiir(fizetendo);
    }

    static int sum(ArrayList<Integer> lista) {
        int osszeg = 0;
        int hossza = lista.size();
        for (int i = 0; i < hossza; i++) {
            osszeg += lista.get(i);
        }
        return osszeg;
    }
}
