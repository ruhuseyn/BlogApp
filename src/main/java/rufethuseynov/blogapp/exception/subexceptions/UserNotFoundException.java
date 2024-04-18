package rufethuseynov.blogapp.exception.subexceptions;

import rufethuseynov.blogapp.exception.superexeptions.MainNotFoundException;

public class UserNotFoundException extends MainNotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
