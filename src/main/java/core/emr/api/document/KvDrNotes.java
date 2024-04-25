package core.emr.api.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class KvDrNotes {
    private String key;
    private String value;
}
