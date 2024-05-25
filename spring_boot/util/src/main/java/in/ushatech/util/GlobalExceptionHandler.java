package in.ushatech.util;

import in.ushatech.api.core.exception.InvalidInputException;
import in.ushatech.api.core.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody HttpErrorInfo handleNotFoundException(ServerHttpRequest request,NotFoundException notFoundException)
    {
        return createHttpErrorInfo(NOT_FOUND, request,notFoundException);
    }

    public HttpErrorInfo handleInvalidInputException(ServerHttpRequest request, InvalidInputException invalidInputException)
    {
        return createHttpErrorInfo(HttpStatus.UNPROCESSABLE_ENTITY,request,invalidInputException);
    }


    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, ServerHttpRequest request,
                                              Exception exception)
    {
        String path = request.getPath().pathWithinApplication().value();
        log.info(httpStatus+", "+path+" , "+exception.getMessage());
        return new HttpErrorInfo(httpStatus,path, exception.getMessage());
    }

}
