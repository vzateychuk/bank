package vez.ccy.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vez.ccy.model.CurrencyRate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CurrencyApiController implements CurrencyApi {

  private final ObjectMapper objectMapper;
  private final HttpServletRequest request;

  public ResponseEntity<Void> addCurrency(CurrencyRate body) {
    return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
  }

  public ResponseEntity<CurrencyRate> getCurrencyRate(String code, OffsetDateTime asof) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      try {
        return new ResponseEntity<CurrencyRate>(
            objectMapper.readValue(
                "{\n  \"code\" : \"RUB\",\n  \"rate\" : 91.8,\n  \"name\" : \"Russan Ruble\",\n  \"from\" : \"2024-01-01T01:01:01Z\",\n  \"to\" : \"2999-01-01T01:01:01Z\"\n}",
                CurrencyRate.class),
            HttpStatus.NOT_IMPLEMENTED);
      } catch (IOException e) {
        log.error("Couldn't serialize response for content type application/json", e);
        return new ResponseEntity<CurrencyRate>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity<CurrencyRate>(HttpStatus.NOT_IMPLEMENTED);
  }

  public ResponseEntity<List<CurrencyRate>> searchCurrency(
      String code, OffsetDateTime asof, Integer skip, Integer limit) {
    String accept = request.getHeader("Accept");
    if (accept != null && accept.contains("application/json")) {
      try {
        return new ResponseEntity<List<CurrencyRate>>(
            objectMapper.readValue(
                "[ {\n  \"code\" : \"RUB\",\n  \"rate\" : 91.8,\n  \"name\" : \"Russan Ruble\",\n  \"from\" : \"2024-01-01T01:01:01Z\",\n  \"to\" : \"2999-01-01T01:01:01Z\"\n}, {\n  \"code\" : \"RUB\",\n  \"rate\" : 91.8,\n  \"name\" : \"Russan Ruble\",\n  \"from\" : \"2024-01-01T01:01:01Z\",\n  \"to\" : \"2999-01-01T01:01:01Z\"\n} ]",
                List.class),
            HttpStatus.NOT_IMPLEMENTED);
      } catch (IOException e) {
        log.error("Couldn't serialize response for content type application/json", e);
        return new ResponseEntity<List<CurrencyRate>>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    return new ResponseEntity<List<CurrencyRate>>(HttpStatus.NOT_IMPLEMENTED);
  }
}
