package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
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


    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid,antal);
        doser.add(dosis);
    }

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }

    public double medicinPåDag(){
        double antalDosis = 0;
        for (Dosis dosis : doser) {
            if(dosis.getAntal() < 0){
                throw new IllegalArgumentException("Dosis skal være positiv");
            }
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
        if(medicinPåDag() < 0){
            throw new IllegalArgumentException("Antal medicin skal være positiv");
        }
        if(antalDage() <= 0){
            throw new IllegalArgumentException("Antal dage skal være mindst 1");
        }

        return medicinPåDag() * antalDage();
    }

    /**
     * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     *
     * @return
     */
    @Override
    public double doegnDosis() {
        return samletDosis() / antalDage(); //Samme som at returnere medicinPrDag
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
