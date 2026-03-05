package ordination;

import java.time.LocalDate;

public class DagligFast extends Ordination{

    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }

    public DagligFast(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
    }

    @Override
    public double samletDosis() {
        //TODO
        return 0;
    }

    @Override
    public double doegnDosis() {
        //TODO
        return 0;
    }

    @Override
    public String getType() {
        //TODO
        return "";
    }



}
