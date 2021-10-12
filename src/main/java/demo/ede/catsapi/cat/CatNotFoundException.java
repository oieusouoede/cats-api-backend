package demo.ede.catsapi.cat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CatNotFoundException extends Exception {
    public CatNotFoundException(Integer id){
        super("Error: Cat with ID " + id + " is not on our records.");
    }
}