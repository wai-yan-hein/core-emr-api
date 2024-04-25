package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import core.emr.api.dto.VoucherDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document
@RequiredArgsConstructor
@AllArgsConstructor
public class DcHis {
    @Id
    private String id;
    private String dcInvId;
    private String otId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dcDate;
    private String admissionNo;
    private String patientId;
    private String patientName;
    private String donorName;
    private String doctorId;
    private String doctorName;
    private String currencyId;
    private String currencyName;
    private Integer paymentId;
    private String paymentName;
    private Boolean deleted;
    private Double vouTotal;
    private Double discP;
    private Double discA;
    private Double taxP;
    private Double taxA;
    private Double paid;
    private Double vouBalance;
    private String createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdDate;
    private String updatedBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedDate;
    private String paidCurrencyId;
    private Double paidCurrAmt;
    private String remark;
    private Integer sessionId;
    private String migId;
    private String intgUpdStatus;
    private List<DCDetailHis> services;

    public VoucherDto toVouDto(DcHis model) {
        return VoucherDto.builder()
                .id(model.getId())
                .vouNo(model.getDcInvId())
                .regNo(model.getPatientId())
                .patientName(model.getPatientName())
                .doctorId(model.getDoctorId())
                .doctorName(model.getDoctorName())
                .currencyId(model.getCurrencyId())
                .currencyName(model.getCurrencyName())
                .paymentId(model.getPaymentId())
                .paymentName(model.getPaymentName())
                .deleted(model.getDeleted())
                .vouTotal(model.getVouTotal())
                .discP(model.getDiscP())
                .discA(model.getDiscA())
                .taxP(model.getTaxP())
                .taxA(model.getTaxA())
                .paid(model.getPaid())
                .vouBalance(model.getVouBalance())
                .vouDate(model.getDcDate())
                .createdBy(model.getCreatedBy())
                .dcService(model.services)
                .build();
    }
}
