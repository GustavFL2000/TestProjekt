package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination {
    private LocalDate startDen;
    private LocalDate slutDen;


    //Link til Laegemiddel
    Laegemiddel laegemiddel;

    /**
     *  Initialiserer en ny Ordination med startdato, slutdato og et lægemiddel.
     *  pre:
     * @param startDen
     * @param slutDen
     * @param laegemiddel
     */
    public Ordination(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        this.startDen = startDen;
        this.slutDen = slutDen;
        this.laegemiddel = laegemiddel;
    }


    /**
     * Initialiserer en ny Ordination med startdato og slutdato
     * pre:
     * @param startDen
     * @param slutDen
     */
    public Ordination(LocalDate startDen, LocalDate slutDen) {
        this.startDen = startDen;
        this.slutDen = slutDen;
    }


    /**
     * Registrerer Ordinationens lægemiddel
     * pre:
     * @param laegemiddel
     */
    public void setLaegemiddel(Laegemiddel laegemiddel) {
        if (this.laegemiddel != laegemiddel) {
            this.laegemiddel = laegemiddel;
        }
    }

    public Laegemiddel getLaegemiddel() {
        return this.laegemiddel;
    }


    public LocalDate getStartDen() {
        return startDen;
    }	

    public LocalDate getSlutDen() {
        return slutDen;
    }

    /**
     * Antal hele dage mellem startdato og slutdato. Begge dage inklusive.
     * @return antal dage ordinationen gælder for
     */
    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(startDen, slutDen) + 1;
    }

    @Override
    public String toString() {
        return startDen.toString();
    }

    /**
     * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
     * @return
     */
    public abstract double samletDosis();

    /**
     * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     * @return
     */
    public abstract double doegnDosis();

    /**
     * Returnerer ordinationstypen som en String
     * @return
     */
    public abstract String getType();
}
