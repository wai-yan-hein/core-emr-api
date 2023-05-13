package core.emr.api.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Gender {
    private String genderId;
    private String genderName;
}
