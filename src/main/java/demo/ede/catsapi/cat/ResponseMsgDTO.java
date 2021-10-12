package demo.ede.catsapi.cat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMsgDTO {
    private String msg;
}
