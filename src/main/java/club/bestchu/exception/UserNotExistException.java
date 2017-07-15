package club.bestchu.exception;

/**
 * Created by bestchu on 2017/7/14.
 */
public class UserNotExistException extends Exception{
    public UserNotExistException(){

    }

    public UserNotExistException(String message){
        super(message);
    }

    public UserNotExistException(Throwable cause){
        super(cause);
    }

    public UserNotExistException(String message, Throwable cause){
        super(message, cause);
    }
}
