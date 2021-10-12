package demo.ede.catsapi.cat;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CatService {

    private CatRepository catRepository;

    private final CatMapper catMapper = CatMapper.INSTANCE;

    public ResponseMsgDTO registerNewCat(CatDTO catDTO){
        Cat newCat = catMapper.toModel(catDTO);
        Cat registeredCat = catRepository.save(newCat);
        return createResponseMsg("Success: Cat registered on ID " + registeredCat.getId());
    }

    public CatDTO findCatById(Integer id) throws CatNotFoundException {
        Cat searchedCat = checkIfCatExists(id);
        return catMapper.toDTO(searchedCat);
    }

    public List<CatDTO> allCats(){
        List<Cat> registeredCats = catRepository.findAll();
        return registeredCats
                .stream()
                .map(catMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ResponseMsgDTO updateCatById(Integer id, CatDTO catDTO) throws CatNotFoundException {
        checkIfCatExists(id);

        Cat catToUpdate = catMapper.toModel(catDTO);
        Cat updatedCat = catRepository.save(catToUpdate);
        return createResponseMsg("Success: Cat with ID " + updatedCat.getId() + " updated successfully");
    }

    public ResponseMsgDTO deleteCatById (Integer id) throws CatNotFoundException {
        Cat deletedCat = checkIfCatExists(id);
        catRepository.deleteById(id);
        return createResponseMsg("Success: Cat with ID " + id + "was deleted from the records.");
    }

    private Cat checkIfCatExists(Integer id) throws CatNotFoundException {
        return catRepository.findById(id).orElseThrow(() -> new CatNotFoundException(id));
    }

    private ResponseMsgDTO createResponseMsg(String msg){
        return ResponseMsgDTO
                .builder().msg(msg).build();
    }
}
