package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination{

    //Link til dosis
    private final ArrayList<Dosis> doser = new ArrayList<>();

    /**
     * Initialiserer en ny Ordination med startdato, slutdato og et lægemiddel.
     * pre:
     *
     * @param startDen
     * @param slutDen
     * @param laegemiddel
     */
    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }


    public DagligSkaev(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid,antal);
        doser.add(dosis);
    }

    public ArrayList<Dosis> getDosis() {
        return new ArrayList<>(doser);
    }

    public double medicinPåDag(){
        double antalDosis = 0;
        for (Dosis dosis : doser) {
            antalDosis += dosis.getAntal();
        }
        return antalDosis;
    }

    /**
     * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
     *
     * @return
     */
    @Override
    public double samletDosis() {
        return medicinPåDag() * antalDage();
    }

    /**
     * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     *
     * @return
     */
    @Override
    public double doegnDosis() {
        return samletDosis() / antalDage();
    }

    /**
     * Returnerer ordinationstypen som en String
     *
     * @return
     */
    @Override
    public String getType() {
        return "SKAEV";
    }
}
