package vez.ccy.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CurrencyNotFoundException.class)
    public ProblemDetail handleCurrencyNotFoundException(CurrencyNotFoundException e) {
      log.error(e.getMessage());
      return asProblemDetail(HttpStatus.NOT_FOUND, "Currency Not Found", e.getMessage());
    }

    private ProblemDetail asProblemDetail(HttpStatus httpStatus, String title, String message) {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(httpStatus, message);
        detail.setTitle(title);
        return detail;
    }

}
