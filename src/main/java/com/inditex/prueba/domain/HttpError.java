package com.inditex.prueba.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class HttpError implements java.io.Serializable{
    @JsonProperty("error")
    List<HttpError.Detail> details;
    
    public HttpError(Timestamp timestamp, Integer codigo, String det){
        Detail detail = new Detail(timestamp, codigo, det);
        this.details = new ArrayList<>();
        this.details.add(detail);
    }
    
    public HttpError(){
    }
    
    public void addDetail(Timestamp timestamp, Integer codigo, String det){
        Detail detail = new Detail(timestamp, codigo, det);
        if(this.details==null){
            this.details = new ArrayList<>();
        }
        this.details.add(detail);
    }
    
    @Data
    public class Detail implements java.io.Serializable{
        public Detail(Timestamp timestamp, Integer codigo, String detail) {
            this.timestamp = timestamp;
            this.codigo = codigo;
            this.detail = detail;
        }
        Timestamp timestamp;
        Integer codigo;
        String detail;
    }
}
