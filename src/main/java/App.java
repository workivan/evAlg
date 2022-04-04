import evolution.Evolution;
import evolution.EvolutionAlg;
import evolution.genome.GenomeConfig;
import evolution.score.Score;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Evolution ev = new EvolutionAlg();
        while(true){
            ev.getNextGenomes();
            ev.score(Arrays.asList(
                    new Score(10., 3., 250),
                    new Score(3., 5., 5),
                    new Score(6., 2., 15),
                    new Score(5., 2., 30),
                    new Score(7., 1., GenomeConfig.MAX_TIME.intValue()),
                    new Score(0., 3., 50)));
        }
    }
}
