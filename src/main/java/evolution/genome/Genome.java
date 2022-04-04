package evolution.genome;

import utils.RandomDouble;

import java.util.ArrayList;
import java.util.List;

public class Genome {
    LegGenome left;
    LegGenome right;

    public List<Double> getParams() {
        List<Double> params = new ArrayList<>();
        params.add(left.p);
        params.add(left.o);
        params.add(left.m);
        params.add(left.M);
        params.add(right.p);
        params.add(right.o);
        params.add(right.m);
        params.add(right.M);
        return params;
    }

    public void updateParams(List<Double> params) {
        left.p = params.get(0);
        left.o = params.get(1);
        left.m = params.get(2);
        left.M = params.get(3);
        right.p = params.get(4);
        right.o = params.get(5);
        right.m = params.get(6);
        right.M = params.get(7);
    }

    private static LegGenome setupLeg() {
        Double mValue = RandomDouble.inRange(
                GenomeConfig.MIN_VALUE_m * GenomeConfig.LEG_LENGTH, GenomeConfig.MAX_VALUE_m * GenomeConfig.LEG_LENGTH
        );
        return new LegGenome(
                RandomDouble.inRange(GenomeConfig.MIN_VALUE_P, GenomeConfig.MAX_VALUE_P),
                RandomDouble.inRange(GenomeConfig.MIN_VALUE_O, GenomeConfig.MAX_VALUE_O),
                RandomDouble.inRange(mValue, GenomeConfig.MAX_VALUE_M * GenomeConfig.LEG_LENGTH),
                mValue
        );
    }

    public Genome() {
        left = setupLeg();
        right = setupLeg();
    }
}
