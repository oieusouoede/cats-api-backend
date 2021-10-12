package demo.ede.catsapi.cat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatMapper {

    CatMapper INSTANCE = Mappers.getMapper(CatMapper.class);

    Cat toModel(CatDTO catDTO);

    CatDTO toDTO(Cat cat);

}
