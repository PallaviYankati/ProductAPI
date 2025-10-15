package in.ashokit.exception;

import in.ashokit.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ApiResponse<String>> handleNpException(NullPointerException npe) {

        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(500);
        response.setMessage(npe.getMessage());
        response.setData(null);

        log.error(npe.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception e) {
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(500);
        response.setMessage(e.getMessage());
        response.setData(null);
        log.error(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}