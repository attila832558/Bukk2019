import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 3. feladat
        List<Versenyzo> versenyzok = new ArrayList<>();
        File file = new File("bukkm2019.txt");
        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                versenyzok.add(new Versenyzo(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //4. feladat
        int teljesitok = versenyzok.size();
        int indulok = 691;
        double arany = (1 - ((double) teljesitok / (double) indulok)) * 100;
        System.out.println("4. feladat: Versenytavot nem teljesitok: " + arany + "%");

        //5. feladat
        int rovidNok = 0;
        for (Versenyzo versenyzo : versenyzok) {
            if (versenyzo.getVersenytav().getTav().equals("Rövid") && versenyzo.No()) {
                rovidNok++;
            }
        }
        System.out.println("5. feladat: Noi versenyzok szama a rovid tavu versenyen: " + rovidNok + "fo");

        //6. feladat
        boolean volt = false;
        for (Versenyzo versenyzo : versenyzok) {
            if (versenyzo.getHoursFromIdo() >= 6) {
                volt = true;
                break;
            }
        }
        System.out.println("6. feladat: " + (volt ? "Volt ilyen versenyző" : "Nem volt ilyen versenyző"));

        //7. feladat
        String rajtszam = "";
        String gyoztes = "";
        String gyoztesEgyesulet = "";
        String gyoztesIdo = "";
        int min = Integer.MAX_VALUE;
        for (Versenyzo versenyzo : versenyzok) {
            if (versenyzo.getVersenytav().getTav().equals("Rövid") && versenyzo.getKategoria().equals("ff")) {
                if (versenyzo.getSecondsFromIdo() < min) {
                    min = versenyzo.getSecondsFromIdo();
                }
            }
        }
        for (Versenyzo versenyzo : versenyzok) {
            if (versenyzo.getVersenytav().getTav().equals("Rövid") && versenyzo.getKategoria().equals("ff")) {
                if (versenyzo.getSecondsFromIdo() == min) {
                    rajtszam = versenyzo.getRajtszam();
                    gyoztes = versenyzo.getNev();
                    gyoztesEgyesulet = versenyzo.getEgyesulet();
                    gyoztesIdo = versenyzo.getIdo();
                    break;
                }
            }
        }
        System.out.println("7. feladat: A felnott ferfi (ff) kategoria gyoztese rovid tavon");
        System.out.println("\tRajtszam: " + rajtszam);
        System.out.println("\tNev: " + gyoztes);
        System.out.println("\tEgyesulet: " + gyoztesEgyesulet);
        System.out.println("\tIdo: " + gyoztesIdo);

        //8. feladat
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (Versenyzo versenyzo : versenyzok) {
            if (!versenyzo.No()) {
                if (hashMap.containsKey(versenyzo.getKategoria())) {
                    hashMap.put(versenyzo.getKategoria(), hashMap.get(versenyzo.getKategoria()) + 1);
                } else {
                    hashMap.put(versenyzo.getKategoria(), 1);
                }
            }
        }
        System.out.println("8. feladat: Statisztika");
        for (String key : hashMap.keySet()) {
            System.out.println("\t" + key + " - " + hashMap.get(key) + "fő");
        }

    }
}