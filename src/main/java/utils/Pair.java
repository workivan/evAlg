package utils;

import evolution.genome.Genome;

public record Pair(Genome gen1, Genome gen2) {
    @Override
    public Genome gen1() {
        return gen1;
    }

    @Override
    public Genome gen2() {
        return gen2;
    }
}
