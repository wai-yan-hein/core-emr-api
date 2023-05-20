package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OPDMedicalHisCashier {
    @Id
    private String id;
    private String visitId;
    private LocalDateTime visitDate; // date time
    private String regNo;
    private String admissionNo;
    private String patientName;
    private String drId;
    private String drName;
    private LocalDate reVisitDate; // date
    private String drNotes;
    private Double vouTotal;
    private Double discP;
    private Double discAmt;
    private Double taxP;
    private Double taxAmt;
    private Double paid;
    private Double balance;
    private List<Treatment> treatments;
    private List<KvDrNotes> kvDrNotes;
}
