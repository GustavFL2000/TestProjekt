package ordination;

import java.time.LocalDate;

public class DagligFast extends Ordination{
    /**
     * Initialiserer en ny Ordination med startdato, slutdato og et lægemiddel.
     * pre:
     *
     * @param startDen
     * @param slutDen
     * @param laegemiddel
     */
    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }

    /**
     * Initialiserer en ny Ordination med startdato og slutdato
     * pre:
     *
     * @param startDen
     * @param slutDen
     */
    public DagligFast(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
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
    // TODO
}
