package io.gtihub.andresgois.rest;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(String msg){
        this.errors = Arrays.asList(msg);
    }
}
