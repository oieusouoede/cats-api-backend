package demo.ede.catsapi.cat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatDTO {

    private Integer id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    @Max(30)
    private Integer age;

    @NotEmpty
    @Size(min = 2, max = 180)
    private String pastime;
}
