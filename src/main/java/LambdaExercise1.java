import java.util.function.BiFunction;

public class LambdaExercise1 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        };

        BiFunction<Integer, Integer, Integer> sum2 = (x, y) -> x + y;

        BiFunction<Integer, Integer, Integer> sum3 = Integer::sum;
    }
}
