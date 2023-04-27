package core.emr.api.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class OPDLabResult {
//    @Id
    String result_id;
    String service_id;
    String result_text;
    String result_unit;
    String result_normal;
    Integer result_type;
    Integer mig_id;
    Integer sort_order;
    String lab_result_remark;
}
