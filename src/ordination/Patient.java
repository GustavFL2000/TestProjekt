package ordination;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Patient {
    private String cprnr;
    private String navn;
    private double vaegt;

    // TODO: Link til Ordination
    private List<Ordination> ordinationer = new ArrayList<>();

    public Patient(String cprnr, String navn, double vaegt) {
        this.cprnr = cprnr;
        this.navn = navn;
        this.vaegt = vaegt;
    }

    public String getCprnr() {
        return cprnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getVaegt(){
        return vaegt;
    }

    public void setVaegt(double vaegt){
        this.vaegt = vaegt;
    }

    //TODO: Metoder (med specifikation) til at vedligeholde link til Ordination
    public void addOrdination(Ordination ordination) {
        ordinationer.add(ordination);
    }

    public List<Ordination> getOrdinationer() {
        return new ArrayList<>(ordinationer);
    }


    public void removeOrdination(Ordination ordination){
        if(!ordinationer.contains(ordination)){
            throw new NoSuchElementException("Denne ordination findes ikke for patienten");
        }
        else ordinationer.remove(ordination);
    }

    @Override
    public String toString(){
        return navn + "  " + cprnr;
    }

}
