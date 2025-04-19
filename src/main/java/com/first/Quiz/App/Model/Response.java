package com.first.Quiz.App.Model;

import lombok.Data;

@Data
public class Response {
    private Integer id;
    private String response;

    public String getResponse() {
        return response;
    }
    public Integer getId(){
        return id;
    }


}
