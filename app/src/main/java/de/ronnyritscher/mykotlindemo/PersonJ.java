package de.ronnyritscher.mykotlindemo;

import java.util.Objects;

/**
 * Beispiel unterschied der Klassen PersonJ.java und PersonK.kt
 *
 * Angelegte PERSON in JAVA
 */
public class PersonJ {

    private String vName;
    private String nName;
    private String strasse;
    private String ort;
    private String plz;  //String, da es mit 0 beginnt
    private int hnr;
    private int alter;
    //private boolean istMitarbeiter; //in Java: hinzufügen neuer Elemente in alle Sachen ändern/anpassen

    //CONSTRUCTOR
    public PersonJ(String vName, String nName, String strasse, String ort, String plz, int hnr, int alter) {
        this.vName = vName;
        this.nName = nName;
        this.strasse = strasse;
        this.ort = ort;
        this.plz = plz;
        this.hnr = hnr;
        this.alter = alter;
    }
    //COPY-CONSTRUCTOR
    public PersonJ(PersonJ other) {
        this.vName = other.vName;
        this.nName = other.nName;
        this.strasse = other.strasse;
        this.ort = other.ort;
        this.plz = other.plz;
        this.hnr = other.hnr;
        this.alter = other.alter;
    }

    //GETTER UND SETTER     --!!!!!! für die Erkennung der getter und setter muss der erste Buchstabe groß sein--
    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getNName() {
        return nName;
    }

    public void setNName(String nName) {
        this.nName = nName;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public int getHnr() {
        return hnr;
    }

    public void setHnr(int hnr) {
        this.hnr = hnr;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    //TO-STRING
    @Override
    public String toString() {
        return "PersonJ{" +
                "vName='" + vName + '\'' +
                ", nName='" + nName + '\'' +
                ", strasse='" + strasse + '\'' +
                ", ort='" + ort + '\'' +
                ", plz='" + plz + '\'' +
                ", hnr=" + hnr +
                ", alter=" + alter +
                '}';
    }

    //EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonJ personJ = (PersonJ) o;
        return hnr == personJ.hnr &&
                alter == personJ.alter &&
                Objects.equals(vName, personJ.vName) &&
                Objects.equals(nName, personJ.nName) &&
                Objects.equals(strasse, personJ.strasse) &&
                Objects.equals(ort, personJ.ort) &&
                Objects.equals(plz, personJ.plz);
    }

    //HASHCODE
    @Override
    public int hashCode() {
        return Objects.hash(vName, nName, strasse, ort, plz, hnr, alter);
    }

}
