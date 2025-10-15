package in.ashokit.exception;

public class NoProductCategoriesFound extends RuntimeException{

    public NoProductCategoriesFound(){

    }

    public NoProductCategoriesFound(String msg){
        super(msg);
    }
}
