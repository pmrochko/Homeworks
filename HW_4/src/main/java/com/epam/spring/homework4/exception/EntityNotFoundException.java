package com.epam.spring.homework4.exception;

import com.epam.spring.homework4.model.enums.ErrorType;

/**
 * @author Pavlo Mrochko
 */
public class EntityNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Entity is not found";

    public EntityNotFoundException(){
        super(DEFAULT_MESSAGE);
    }

    public EntityNotFoundException(String message){
        super(message);
    }

    @Override
    public ErrorType getErrorType(){
        return ErrorType.VALIDATION_ERROR_TYPE;
    }

}
