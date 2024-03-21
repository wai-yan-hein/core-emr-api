package core.emr.api.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document
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
    private String currencyId;
    private Integer paymentId;
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
    private List<OTDetailHis> services;
}
