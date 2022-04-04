package evolution.genome;

/**
 * @param p - период [1 * 10^-3, 10]
 * @param o - отклонение [-pi, pi]
 * @param m - нижняя амплитуда [-piR/2, M], где R - длинна ноги
 * @param M - вверхняя амплитуда [-piR/2, piR/2] где R - длинна ноги
 *          M > m
 */

public class GenomeConfig {
    public static final Double MAX_VALUE_P=10.0;
    public static final Double MIN_VALUE_P=0.001;

    public static final Double MAX_VALUE_O=Math.PI;
    public static final Double MIN_VALUE_O=-Math.PI;

    public static final Double MAX_VALUE_m=Math.PI/2;
    public static final Double MIN_VALUE_m=-Math.PI/2;

    public static final Double MAX_VALUE_M=Math.PI/2;

    public static final Integer POPULATION_SIZE = 6;

    public static final Double H_DIFF_WEIGHT = 0.1;
    public static final Double MAX_TIME =  3600.;
    public static final Double TIME_WEIGHT = 0.1;

    public static final Integer LEG_LENGTH = 5;

    public static final Integer PARAMS_COUNTS = 8;
}
