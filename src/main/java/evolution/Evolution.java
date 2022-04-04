package evolution;

import evolution.genome.Genome;
import evolution.score.Score;

import java.util.List;

public interface Evolution {
    List<Genome> getNextGenomes();
    List<Double> score(List<Score> results);
}
