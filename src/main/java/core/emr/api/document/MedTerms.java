package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("med_terms")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedTerms {
    private String desc;
}
