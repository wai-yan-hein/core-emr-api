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
public class OPDMedicalHis {
    @Id
    private String id;
    private String visitId;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date visitDate; // date time
    private String regNo;
    private String admissionNo;
    private String patientName;
    private String drId;
    private String drName;
    private Date reVisitDate; // date
    private String drNotes;
    private OPDCFFeeService cfType;
    private Double cfFees;
    private Boolean isFoc;
    private List<Examination> examinations;
    private List<Treatment> treatments;
    private List<KvDrNotes> kvDrNotes;
}
