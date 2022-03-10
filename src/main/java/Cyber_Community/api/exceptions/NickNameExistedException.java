package Cyber_Community.api.exceptions;

/**
 * Created by Enzo Cotter on 10/03/2022.
 */
public class NickNameExistedException extends RuntimeException{
    public NickNameExistedException(){

    }

    public NickNameExistedException(String message){
        super(message);

    }
}
