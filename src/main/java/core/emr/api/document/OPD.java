package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Document
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OPD {
    private String vouNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date opdDate;
    private Patient patient;
    private Doctor doctor;
    private boolean deleted;
    private float vouTotal;
    private float disPercent;
    private float disAmt;
    private float taxPercent;
    private float taxAmt;
    private float vouPaid;
    private float vouBalance;
    private String createdBy;
    private String createdName;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date createdDate;
    private String updatedBy;
    private String updatedName;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date updatedDate;
    private String currency;
    private String remark;
    private List<OPDDetail> listDetail;


}
