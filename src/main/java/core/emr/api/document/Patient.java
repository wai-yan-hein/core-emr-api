package core.emr.api.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Data
public class Patient {
    private String patientNo;
    private String patientName;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd ")
    private Date regDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd ")
    private Date dob;
    private Gender gender;
    private String nrc;
    private City city;
    private String nationality;
    private String religion;
    private Doctor doctor;
    private String address;
    private String phoneNo;
    private Integer age;
    private String admissionNo;
    private Township township;
}
