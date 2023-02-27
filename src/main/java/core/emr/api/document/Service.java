package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Service {
    private String srvName;
    private float srvAmt;
}
