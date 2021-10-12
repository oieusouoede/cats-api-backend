package demo.ede.catsapi.cat;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// One cannot control cats, actually.
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(value = "Cat Controller")
@RequestMapping("/cats")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CatController {

    private CatService catService;

    @ApiOperation(value = "Register new Kitten")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMsgDTO registerNewCat(@RequestBody @Valid CatDTO catDTO){
        return catService.registerNewCat(catDTO);
    }

    @ApiOperation(value = "Find kitten by ID")
    @GetMapping("/find={id}")
    public CatDTO findCatById(@PathVariable Integer id) throws CatNotFoundException {

        return catService.findCatById(id);
    }

    @ApiOperation(value = "Find all registered kittens")
    @GetMapping("/find=all")
    public List <CatDTO> allCats (){
        return catService.allCats();
    }

    @ApiOperation(value = "Update cat information by ID")
    @PutMapping("/update={id}")
    public ResponseMsgDTO updateCatById(@PathVariable Integer id, @RequestBody CatDTO catDTO) throws CatNotFoundException {
        return catService.updateCatById(id, catDTO);

    }

    @ApiOperation(value = "Delete kitten by ID")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete={id}")
    public ResponseMsgDTO deleteCatById(@PathVariable Integer id) throws CatNotFoundException {
        return catService.deleteCatById(id);
    }
}
