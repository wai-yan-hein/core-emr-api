package core.emr.api.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Township {
    private String townshipId;
    private String townshipName;
}
