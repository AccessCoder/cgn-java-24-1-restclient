package de.neuefische.cgnjava241restclient.exceptions;

import de.neuefische.cgnjava241restclient.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUniversalException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Minimaler ExceptionHandler der einfach nur die Fehlernachricht ausgibt und einen passenden HTTP Status
//    @ExceptionHandler(InvalidIdException.class)
//    public ResponseEntity<String> handleInvalidIdException(InvalidIdException exception){
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
//    }

    //Version mit umfangreicherer Information, z. B. dem Fehlerpfad, Status, Nachricht und Zeitstempel
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidIdException(InvalidIdException exception,
                                                                     WebRequest webRequest){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    //100% Variante mit umfangreicheren Informationen + passendem Header
//    @ExceptionHandler(InvalidIdException.class)
//    public ResponseEntity<ErrorResponseDto> handleInvalidIdException(InvalidIdException exception,
//                                                                     WebRequest webRequest){
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/problem+json");
//
//        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
//                webRequest.getDescription(false),
//                HttpStatus.NOT_FOUND,
//                exception.getMessage(),
//                LocalDateTime.now()
//        );
//        return new ResponseEntity<>(errorResponseDto, headers, HttpStatus.NOT_FOUND);
//    }

}
