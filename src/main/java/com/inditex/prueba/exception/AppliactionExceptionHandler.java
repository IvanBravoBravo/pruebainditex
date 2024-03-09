package com.inditex.prueba.exception;

import com.inditex.prueba.domain.HttpError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
@Slf4j
public class AppliactionExceptionHandler {

    @ExceptionHandler({
        BrandNotFoundException.class,
        BrandExistException.class,
        ProductNotFoundException.class,
        ProductExistException.class,
        PrecioNotFoundException.class
    })
    @Nullable
    public final ResponseEntity<HttpError> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        log.error("Manejando " + ex.getClass().getSimpleName() + " debido a " + ex.getMessage());

        HttpError httpError = new HttpError();

        if (ex instanceof BrandNotFoundException brandNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            BrandNotFoundException bnfe = brandNotFoundException;
            return handleBrandNotFoundException(bnfe, httpError, headers, status, request);
        } else if(ex instanceof BrandExistException brandExistException){
            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
            BrandExistException bee = brandExistException;
            return handleExceptionInternal(bee, httpError, headers, status, request);
        } else if(ex instanceof ProductExistException productExistException){
            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
            ProductExistException pee = productExistException;
            return handleExceptionInternal(pee, httpError, headers, status, request);
        } else if(ex instanceof ProductNotFoundException productNotFoundException){ 
            HttpStatus status = HttpStatus.NOT_FOUND;
            ProductNotFoundException pnf = productNotFoundException;
            return handleExceptionInternal(pnf, httpError, headers, status, request);
        } else if(ex instanceof PrecioNotFoundException precioNotFoundException){ 
            HttpStatus status = HttpStatus.NOT_FOUND;
            PrecioNotFoundException pnf = precioNotFoundException;
            return handleExceptionInternal(pnf, httpError, headers, status, request);
        } else {
            if (log.isWarnEnabled()) {
                log.warn("Exception no manejada: " + ex.getClass().getName());
            }
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, httpError, headers, status, request);
        }
    }

    protected ResponseEntity<HttpError> handleBrandNotFoundException(BrandNotFoundException ex, HttpError httpError,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        return handleExceptionInternal(ex, httpError, headers, status, request);
    }

    protected ResponseEntity<HttpError> handleExceptionInternal(Exception ex, HttpError httpError,
            HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        httpError.addDetail(
                new Timestamp(System.currentTimeMillis()),
                status.value(),
                ex.getLocalizedMessage());

        return new ResponseEntity<>(httpError, headers, status);
    }
}
