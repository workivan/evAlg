package evolution.genome;

import java.util.List;
import java.util.stream.Stream;

public class Genomes {
    private final List<Genome> currentGenomes;

    public List<Genome> current() {
        return currentGenomes;
    }

    public Genome getGenomeByIndex(Integer i) {
        return currentGenomes.get(i);
    }

    public Genomes(Integer pSize) {
        currentGenomes = Stream
                .generate(Genome::new)
                .limit(pSize)
                .toList();
    }

}
