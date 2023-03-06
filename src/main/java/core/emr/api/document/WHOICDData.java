package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("who_icd_data")
public class WHOICDData {
    String code;
    String desc_eng;
    String desc_myan;

}
