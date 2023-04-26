package core.emr.api.document;

import lombok.Data;

@Data
public class Treatment {
    private String group;
    private String subGroup;
    private String code;
    private String desc;
    private String pattern;
    private Integer days;
    private Integer qty;
    private Double price;
    private Double discount;
    private Double amount;
    private String remark;

}
