package br.andresgois.github.io.exception;

import java.util.ArrayList;
import java.util.List;

import br.andresgois.github.io.resource.exceptions.FieldMessage;

public class ValidationError extends StandardError{
    
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
    
}
