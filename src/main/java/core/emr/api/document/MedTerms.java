package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("medTerms")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedTerms {
    private String desc;
}
