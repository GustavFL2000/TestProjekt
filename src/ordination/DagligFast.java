package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DagligFast extends Ordination{
    private Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }

    public DagligFast(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
    }


    @Override
    public double samletDosis() {
        double antalPillerOmDagen = 0;
        for (Dosis dosis : doser) {
            antalPillerOmDagen += dosis.getAntal();
        }
        return antalDage() * antalPillerOmDagen;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / antalDage() ;
    }

    @Override
    public String getType() {
        return "FAST";
    }

    public Dosis[] getDoser() {
        return doser.clone();
    }
}
