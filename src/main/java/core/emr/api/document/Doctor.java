package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
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
