package spring.mongodbSpring.Exception;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String msg){
        super(msg);
    }
}
