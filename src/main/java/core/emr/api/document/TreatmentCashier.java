package core.emr.api.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@RequiredArgsConstructor
@AllArgsConstructor
public class TreatmentCashier {
    @Id
    private String id;
    private String group;
    private String subGroup;
    private String code;
    private String desc;
    private PharmacyPattern pattern;
    private Integer days;
    private Float qty;
    private String remark;
    private String relStr;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd ")
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
    private Boolean checkItem;
}
