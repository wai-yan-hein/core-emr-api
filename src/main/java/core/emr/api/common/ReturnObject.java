/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.emr.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @author Lenovo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ReturnObject {
    private String status;
    private String message;
    private String errorMessage;
    private List<Object> list;
    private Object data;
    private byte[] file;
}
