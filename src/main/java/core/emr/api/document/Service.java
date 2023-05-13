package core.emr.api.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Service {
    private String srvName;
    private float srvAmt;
}
