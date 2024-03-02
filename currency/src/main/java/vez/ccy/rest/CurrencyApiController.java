package vez.ccy.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vez.ccy.model.CurrencyRate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CurrencyApiController implements CurrencyApi {

  private final ObjectMapper objectMapper;
  private final HttpServletRequest request;

  public ResponseEntity<Void> addCurrency(
      @Parameter(in = ParameterIn.DEFAULT, description = "Currency/Rate to add", schema = @Schema())
          @Valid
          @RequestBody
          CurrencyRate body) {
    String accept = request.getHeader("Accept");
    return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
  }

  public ResponseEntity<CurrencyRate> getCurrencyRate(
      @Parameter(
              in = ParameterIn.PATH,
              description = "currency code",
              required = true,
              schema = @Schema())
          @PathVariable("code")
          String code,
      @Parameter(
              in = ParameterIn.QUERY,
              description = "date when rate is active (latest value if missed)",
              schema = @Schema())
          @Valid
          @RequestParam(value = "asof", required = false)
          OffsetDateTime asof) {
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
      @Parameter(
              in = ParameterIn.QUERY,
              description = "pass currency-code for looking up currency",
              schema = @Schema())
          @RequestParam(value = "code", required = false)
          String code,
      @Parameter(
              in = ParameterIn.QUERY,
              description = "date when rate is active (latest value if missed)",
              schema = @Schema())
          @Valid
          @RequestParam(value = "asof", required = false)
          OffsetDateTime asof,
      @Min(0)
          @Parameter(
              in = ParameterIn.QUERY,
              description = "number of records to skip for pagination",
              schema = @Schema(allowableValues = {"0"}))
          @Valid
          @RequestParam(value = "skip", required = false)
          Integer skip,
      @Min(0)
          @Max(50)
          @Parameter(
              in = ParameterIn.QUERY,
              description = "maximum number of records to return",
              schema =
                  @Schema(
                      allowableValues = {"0", "50"},
                      maximum = "50"))
          @Valid
          @RequestParam(value = "limit", required = false)
          Integer limit) {
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
