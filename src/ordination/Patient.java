package ordination;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String cprnr;
    private String navn;
    private double vaegt;

    private List<Ordination> ordinations = new ArrayList<>();

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

    /**
     * Tilføjer en ny orination til listen
     * @param ordination
     */
    public void addOrdination(Ordination ordination) {
        ordinations.add(ordination);
    }

    /**
     * Fjerner en ordination fra listen
     * @param ordination
     */
    public void removeOrdination(Ordination ordination) {
        if (ordinations.contains(ordination)) {
            ordinations.remove(ordination);
        }
    }

    /**
     * Henter en ny liste af
     * @return
     */
    public ArrayList<Ordination> getOrdinations() {
        return new ArrayList<>(ordinations);
    }

    @Override
    public String toString(){
        return navn + "  " + cprnr;
    }

}
