package ordination;

import java.time.LocalDate;

public class PN extends Ordination{

    private double antalEnheder;

    /**
     * Initialiserer en ny Ordination med startdato, slutdato og et lægemiddel.
     * pre:
     *
     * @param startDen
     * @param slutDen
     * @param laegemiddel
     */
    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }

    /**
     * Initialiserer en ny Ordination med startdato og slutdato
     * pre:
     *
     * @param startDen
     * @param slutDen
     */
    public PN(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        // TODO
        return false;   
    }

    public double doegnDosis() {
        // TODO
        return 0.0;
    }

    /**
     * Returnerer ordinationstypen som en String
     *
     * @return
     */
    @Override
    public String getType() {
        return "";
    }


    public double samletDosis() {
        // TODO
        return 0.0;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        // TODO
        return-1;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
