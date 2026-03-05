package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligSkaev extends Ordination{
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
        // TODO
    }

    /**
     * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
     *
     * @return
     */
    @Override
    public double samletDosis() {
        return 0;
    }

    /**
     * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     *
     * @return
     */
    @Override
    public double doegnDosis() {
        return 0;
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
}
