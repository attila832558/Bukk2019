public class Versenyzo {
    private String rajtszam;
    private String kategoria;
    private String nev;
    private String egyesulet;
    private String ido;
    private Versenytav versenytav;

    public Versenyzo(String sor) {
        String[] adatok = sor.split(";");
        rajtszam = adatok[0];
        kategoria = adatok[1];
        nev = adatok[2];
        egyesulet = adatok[3];
        ido = adatok[4];
        versenytav = new Versenytav(rajtszam);
    }

    public String getRajtszam() {
        return rajtszam;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getNev() {
        return nev;
    }

    public String getEgyesulet() {
        return egyesulet;
    }

    public String getIdo() {
        return ido;
    }

    public Versenytav getVersenytav() {
        return versenytav;
    }

    public boolean No() {
        return kategoria.charAt(kategoria.length() - 1) == 'n';
    }

    public int getHoursFromIdo() {
        String oraString = ido.split(":")[0];
        return Integer.parseInt(oraString);
    }

    public int getSecondsFromIdo() {
        String[] idoSplit = ido.split(":");
        int ora = Integer.parseInt(idoSplit[0]);
        int perc = Integer.parseInt(idoSplit[1]);
        int masodperc = Integer.parseInt(idoSplit[2]);
        return (ora * 3600) + (perc * 60) + masodperc;
    }

}
