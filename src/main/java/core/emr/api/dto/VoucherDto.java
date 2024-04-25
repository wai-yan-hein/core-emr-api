package core.emr.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import core.emr.api.document.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class VoucherDto {
    private String id;
    private String vouNo;
    private String regNo;
    private String patientName;
    private String doctorId;
    private String doctorName;
    private String locationId;
    private String locationName;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime vouDate;
    private List<TreatmentCashier> opdService;
    private List<OTDetailHis> otService;
    private List<DCDetailHis> dcService;
    private String createdBy;
}


