package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import core.emr.api.dto.VoucherDto;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime visitDate; // date time
    private String regNo;
    private String admissionNo;
    private String patientName;
    private String drId;
    private String drName;
    private String locId;
    private String locName;
    private String currId;
    private String currName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime reVisitDate; // date
    private String drNotes;
    private Double vouTotal;
    private Double discP;
    private Double discA;
    private Double taxP;
    private Double taxA;
    private Double paid;
    private Double balance;
    private Integer maxUniqueId;
    private List<TreatmentCashier> treatments;
    private List<KvDrNotes> kvDrNotes;
    //from htut
    private String opdInvId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime opdDate;


    public VoucherDto toVouDto(OPDMedicalHisCashier model) {
        return VoucherDto.builder()
                .id(model.getId())
                .vouNo(model.getOpdInvId())
                .regNo(model.getRegNo())
                .patientName(model.getPatientName())
                .doctorId(model.getDrId())
                .doctorName(model.getDrName())
                .locationId(model.getLocId())
                .locationName(model.getLocName())
                .currencyId(model.getCurrId())
                .currencyName(model.getCurrName())
                .paymentId(0)
                .paymentName("")
                .deleted(false)
                .vouTotal(model.getVouTotal())
                .discP(model.getDiscP())
                .discA(model.getDiscA())
                .taxP(model.getTaxP())
                .taxA(model.getTaxA())
                .paid(model.getPaid())
                .vouBalance(model.getBalance())
                .vouDate(model.getVisitDate())
                //.createdBy(model.getCreatedBy())
                .opdService(model.getTreatments())

                .build();
    }
}


