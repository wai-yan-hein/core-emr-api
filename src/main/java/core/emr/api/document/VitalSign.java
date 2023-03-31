package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VitalSign {
    @Id
    private String id;
    private String bookingId;
    private String regNo;
    private String nurseRemark;
    private Integer temperature;
    private String tempUnit;
    private Integer plus;
    private Integer respiratory;
    private Integer bpUpper;
    private Integer bpLower;
    private Integer oxygenStatus;
    private Integer oxygenRate;
    private Integer oxygenConcentration;
    private String oxygenMethod;
    private Integer glucoMeter;
    private String glucoUnit;
    private Integer weight;
    private String weightUnit;
    private Integer height;
    private String heightUnit;
    private Integer bmi;
    private String createdBy;
    private Date createdDate; //date time
}
