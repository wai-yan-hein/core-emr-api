package core.emr.api.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("doctor")
public class Doctor {
    private String doctorId;
    private String firstName;
    private String lastName;
}
