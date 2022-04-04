package evolution.score;

public record Score(Double dist, Double hDiff, Integer time) {
    @Override
    public Double dist() {
        return dist;
    }

    @Override
    public Double hDiff() {
        return hDiff;
    }

    @Override
    public Integer time() {
        return time;
    }
}
