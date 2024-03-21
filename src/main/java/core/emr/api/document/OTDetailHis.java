package core.emr.api.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@Builder
public class OTDetailHis {
    @Id
    private String id;
    private String otDetailId;
    private String serviceId;
    private String qty;
    private String price;
    private Integer feesVersionId;
    private Integer uniqueId;
    private String chargeType;
    private Double amount;
    private Boolean readerStatus;
    private Double srvFee1;
    private Double srvFee2;
    private Double srvFee3;
    private Double srvFee4;
    private Double srvFee5;
    private Integer restoreId;
    private String isReturnIn;
    private Double returnInAmt;
    private String returnInBy;
    private LocalDateTime returnInDate;
    private String payId1;
    private String payId2;
    private String payId3;
    private String payId4;
    private String payId5;
    private String fee1PayAmt;
    private String fee2PayAmt;
    private String fee3PayAmt;
    private String fee4PayAmt;
    private String fee5PayAmt;
    private Boolean needDoctor;
    private String vouNo;
}
