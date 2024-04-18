package rufethuseynov.blogapp.exception.subexceptions;


import rufethuseynov.blogapp.exception.superexeptions.MainNotFoundException;

public class ImageNotFoundException extends MainNotFoundException {
    public ImageNotFoundException(String message) {
        super(message);
    }
}
