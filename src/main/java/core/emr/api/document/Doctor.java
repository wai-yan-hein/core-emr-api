package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("doctor")
public class Doctor {
    private String doctorId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private boolean active;
    private String licenseNo;
    private String phone;
    private String nrc;


}
