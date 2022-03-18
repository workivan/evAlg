package evolution;

import evolution.genome.Genome;

import java.util.List;
/**
 * Самая простая реализация эволюционного алгоритма
 * @author Андрей и Иван
 */
public class EvolutionAlg implements Evolution{
    /** размер популяции */
    private int pSize;


    public EvolutionAlg(){
        setup();
        createRandGenomes();
    }

    public void setup(){
        // инициация необходимых для создания алгоритма параметров
    }

    private void createRandGenomes() {
        return;
    }

    private void crossing(){
        return;
    };

    @Override
    public List<Genome> getGenomes() {
        return null;
    }

    @Override
    public void score(List<?> results) {
        return;
    }
}
