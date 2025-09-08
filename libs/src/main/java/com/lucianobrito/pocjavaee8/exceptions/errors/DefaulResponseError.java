package com.lucianobrito.pocjavaee8.exceptions.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DefaulResponseError implements Serializable {

    private int status;
    private String message;
    private String path;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime timestamp;

    public DefaulResponseError(int status, String message, String path, OffsetDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }
}
