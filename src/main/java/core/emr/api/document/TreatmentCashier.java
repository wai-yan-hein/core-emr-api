package core.emr.api.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class TreatmentCashier {
    private String group;
    private String subGroup;
    private String code;
    private String desc;
    private PharmacyPattern pattern;
    private Integer days;
    private Float qty;
    private String remark;
    private String relStr;
    private LocalDate expDate;
    private Double fees;
    private Double fees1;
    private Double fees2;
    private Double fees3;
    private Double fees4;
    private Double fees5;
    private Double fees6;
    private Boolean isPercent = Boolean.FALSE;
    private Boolean isFOC = Boolean.FALSE;
    private Double serviceCost;
    private String itemUnit;
    private Double amount;
    private Integer uniqueId;
}
