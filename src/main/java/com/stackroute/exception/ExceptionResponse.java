package com.stackroute.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;

    public void setErrorMessage(String message) {
        this.errorMessage=message;
    }

    public void setRequestedURI(String requestURI) {
        this.requestedURI=requestURI;

    }
}
