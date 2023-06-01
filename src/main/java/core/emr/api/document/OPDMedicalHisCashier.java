package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@Document
@RequiredArgsConstructor
@AllArgsConstructor
public class OPDMedicalHisCashier {
    @Id
    private String id;
    private String visitId;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime visitDate; // date time
    private String regNo;
    private String admissionNo;
    private String patientName;
    private String drId;
    private String drName;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime reVisitDate; // date
    private String drNotes;
    private Double vouTotal;
    private Double discP;
    private Double discAmt;
    private Double taxP;
    private Double taxAmt;
    private Double paid;
    private Double balance;

    private String sessionId;
    private String userId;
    private String macId;
    private String locId;
    private String locName;
    private String payTypeId;
    private String payTypeName;
    private String currId;
    private String currName;

    private List<TreatmentCashier> treatments;
    private List<KvDrNotes> kvDrNotes;
}
