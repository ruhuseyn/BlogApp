package rufethuseynov.blogapp.exception.subexceptions;

import rufethuseynov.blogapp.exception.superexeptions.MainNotFoundException;

public class BlogNotFoundException extends MainNotFoundException{
    public BlogNotFoundException(String message) {
        super(message);
    }
}
