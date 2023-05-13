package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class PharmacyPattern {
    @Id
    private String id;
    private String patternCode;
    private String despEng;
    private String despMM;
    private float factor;
}
