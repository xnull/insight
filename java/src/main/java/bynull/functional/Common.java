package bynull.functional;

/**
 * Created by bynull on 04.07.16.
 */
public class Common {

    /**
     * @param <T1>
     * @param <T2>
     */
    public static class Tuple2<T1, T2> {
        public final T1 v1;
        public final T2 v2;

        private Tuple2(T1 v1, T2 v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public static <T1, T2> Tuple2<T1, T2> of(T1 v1, T2 v2) {
            return new Tuple2<>(v1, v2);
        }
    }
}
