package lambda_tasks;

public interface ITwoParamAndTwoTypes<T, R> {
    R start(T a, T b);
}
