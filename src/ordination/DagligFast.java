package ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination{
    private final Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }

    @Override
    public double samletDosis() {
        double antalPillerOmDagen = 0;
        for (Dosis dosis : doser) {
            if(dosis.getAntal() < 0){
                throw new IllegalArgumentException("Dosis skal være positiv");
            }
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


    public void setDoser(double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
        doser[0] = new Dosis(LocalTime.of(8,0), morgenAntal);
        doser[1] = new Dosis(LocalTime.of(12, 0), middagAntal);
        doser[2] = new Dosis(LocalTime.of(18, 0), aftenAntal);
        doser[3] = new Dosis(LocalTime.of(17, 0), natAntal);
    }
}
