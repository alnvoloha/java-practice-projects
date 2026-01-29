package valid;

public interface Validator<T> {
    void validate(T input) throws Exception;
}
