package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PN extends Ordination{

    private double antalEnheder; // mængde af medicin ved behov

    private double antalGange;
    private List<LocalDate> datoerGivetMedicin = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel lagemiddel) {
        super(startDen, slutDen, lagemiddel);
        this.antalGange = 0;
        this.antalEnheder = 0;
    }

    public PN(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
        this.antalGange = 0;
        this.antalEnheder = 0;
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

    // (antal gange ordinationen er anvendt * antal enheder) / (antal dage mellem første og sidste givning)
    public double doegnDosis() {
        double dosis = 0;
        dosis = (antalGange * antalEnheder) / forskelFørsteOgSidste();
        return dosis;
    }

    /**
     * Beregner dagene mellem første og sidste dag givet medicin
     * @return {@code -1} hvis der ikke er givet medicin endnu, ellers gives
     * forskellen på første og sidste dag givet medicin
     */
    private int forskelFørsteOgSidste() {
        LocalDate førsteGivning = null;
        LocalDate sidsteGivning = null;

        try {
            førsteGivning = datoerGivetMedicin.getFirst();
            sidsteGivning = datoerGivetMedicin.getFirst();
        } catch (NoSuchElementException e) {
            System.out.println("Der er ikke givet medicin endnu");
            return -1;
        }

        for (LocalDate d : datoerGivetMedicin) {
            if (førsteGivning.isAfter(d)) {
                førsteGivning = d;
            }
            if (sidsteGivning.isBefore(d)) {
                sidsteGivning = d;
            }
        }
        return Math.toIntExact(ChronoUnit.DAYS.between(førsteGivning, sidsteGivning));
        // giver dage mellem første og sidste givning
    }

    @Override
    public String getType() {
        return "PN";
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
