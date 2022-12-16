package com.epam.spring.homework4.exception;

import com.epam.spring.homework4.model.enums.ErrorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Pavlo Mrochko
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {

    private ErrorType errorType;

    public ServiceException(String message) {
        super(message);
    }

    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }

}
