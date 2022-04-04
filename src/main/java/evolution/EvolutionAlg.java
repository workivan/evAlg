package evolution;

import evolution.genome.Genome;
import evolution.genome.GenomeConfig;
import evolution.genome.Genomes;
import evolution.score.Score;
import utils.Pair;
import utils.RandomDouble;

import java.util.ArrayList;
import java.util.List;

/**
 * Самая простая реализация эволюционного алгоритма
 *
 * @author Андрей и Иван
 */
public class EvolutionAlg implements Evolution {
    private final int pSize; //размер популяции
    private final Genomes genomes; //текущий геном

    private int epoch; //эпоха

    public EvolutionAlg() {
        pSize = GenomeConfig.POPULATION_SIZE;
        genomes = new Genomes(pSize);
    }

    private void update(List<Double> vals) {
        Double fixtureSum = vals.stream().reduce(0., Double::sum);
        List<Double> probs = vals.stream().map(value -> value / fixtureSum).toList();

        List<Pair> pairs = makePairs(probs);

        for (Pair pair : pairs) {
            crossing(pair.gen1(), pair.gen2());
        }
    }

    private void crossing(Genome first, Genome second) {
        List<Double> params = new ArrayList<>();
        int crossStart = RandomDouble.inRange(0., GenomeConfig.PARAMS_COUNTS.doubleValue()).intValue();

        List<Double> leftParams = first.getParams();
        List<Double> rightParams = second.getParams();
        for (int i = crossStart; i < leftParams.size(); i++) {
            Double swap = rightParams.get(i);
            rightParams.set(i, leftParams.get(i));
            leftParams.set(i, swap);
        }

        first.updateParams(leftParams);
        second.updateParams(rightParams);
    }

    private List<Pair> makePairs(List<Double> probs) {
        List<Pair> pairs = new ArrayList<>();
        while (pairs.size() <= GenomeConfig.POPULATION_SIZE / 2) {

            double sum = 0.;
            int i, j;
            boolean fil1 = false, fill2 = false;
            double r1 = RandomDouble.inRange(0., 1.);
            double r2 = RandomDouble.inRange(0., 1.);

            for (i = 0; i < probs.size(); i++) {
                sum += probs.get(i);
                if (sum > r1) {
                    break;
                }
            }
            j = i;
            while (j == i) {
                sum = 0;
                for (j = 0; j < probs.size(); j++) {
                    sum += probs.get(j);
                    if (sum > r2) {
                        break;
                    }
                }
            }
            pairs.add(new Pair(
                    genomes.getGenomeByIndex(i),
                    genomes.getGenomeByIndex(j)
            ));

        }
        return pairs;
    }


    @Override
    public List<Genome> getNextGenomes() {
        return genomes.current();
    }

    @Override
    public List<Double> score(List<Score> results) {
        List<Double> vals = results.stream()
                .map(score -> GenomeConfig.H_DIFF_WEIGHT * (score.hDiff() / GenomeConfig.LEG_LENGTH) + score.dist() +
                        GenomeConfig.TIME_WEIGHT * (score.time() / GenomeConfig.MAX_TIME))
                .toList();
        update(vals);
        return vals;
    }
}
