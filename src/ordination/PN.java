package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PN extends Ordination {

    private double antalEnheder; // mængde af medicin ved behov

    private int antalGangeGivet = 0;
    private List<LocalDate> datoerGivetMedicin = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel lagemiddel, double antalEnheder) {
        super(startDen, slutDen, lagemiddel);
        this.antalGangeGivet = 0;
        this.antalEnheder = antalEnheder;
    }

    public PN(LocalDate startDen, LocalDate slutDen, double antalEnheder) {
        super(startDen, slutDen);
        this.antalGangeGivet = 0;
        this.antalEnheder = antalEnheder;
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     *
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        if (givesDen.isAfter(getStartDen().minusDays(1)) && givesDen.isBefore(getSlutDen().plusDays(1))) {
            datoerGivetMedicin.add(givesDen);
            antalGangeGivet++;
            return true;
        }
        return false;
    }


    public double doegnDosis() {
        return samletDosis() / forskelFørsteOgSidste();
        // (antal gange ordinationen er anvendt * antal enheder) / (antal dage mellem første og sidste givning)
    }

    /**
     * Beregner dagene mellem første og sidste dag givet medicin
     *
     * @return {@code -1} hvis der ikke er givet medicin endnu, ellers gives
     * forskellen på første og sidste dag givet medicin
     */
    protected int forskelFørsteOgSidste() {
        // Objects.requireNonNull(datoerGivetMedicin, "Der er ikke givet medicin endnu");
        LocalDate førsteGivning;
        LocalDate sidsteGivning;

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
        return Math.toIntExact(ChronoUnit.DAYS.between(førsteGivning, sidsteGivning)) + 1;
        // returnere dage mellem første og sidste givning + 1
        // (+1 er pga at hvis start og slut er samme dag, er det stadig 1 dag personen får medicin)
    }

    @Override
    public String getType() {
        return "PN";
    }


    public double samletDosis() {
        return antalGangeGivet * antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     *
     * @return
     */
    public int getAntalGangeGivet() {
        return antalGangeGivet;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
