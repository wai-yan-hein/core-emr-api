package core.emr.api.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Treatment {
    private String group;
    private String subGroup;
    private String code;
    private String desc;
    private PharmacyPattern pattern;
    private Integer days;
    private Integer qty;
    private String remark;
    private String relStr;
    private Double fees;
    private Double fees1;
    private Double fees2;
    private Double fees3;
    private Double fees4;
    private Double fees5;
    private Double fees6;
    private Boolean isPercent = Boolean.FALSE;
    private Double serviceCost;
    private String itemUnit;
}
