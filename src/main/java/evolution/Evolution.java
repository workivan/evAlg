package evolution;

import evolution.genome.Genome;

import java.util.List;

public interface Evolution {
    List<Genome> getGenomes();
    void score(List<?> results);
}
