import evolution.Evolution;
import evolution.EvolutionAlg;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Evolution ev = new EvolutionAlg();
        while(true){
            ev.getGenomes();
            ev.score(new ArrayList<>());
        }
    }
}
