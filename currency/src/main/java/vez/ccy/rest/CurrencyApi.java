/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.52).
 * https://github.com/swagger-api/swagger-codegen Do not edit the class manually.
 */
package vez.ccy.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import vez.ccy.model.CurrencyRate;

@Validated
public interface CurrencyApi {

  @Operation(
      summary = "adds currency",
      description = "Adds currency/rate to the system",
      tags = {"currency"})
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "201", description = "created new currency or already exists"),
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid")
      })
  @PostMapping(value = "/currency")
  ResponseEntity<Void> addCurrency(
      @Parameter(in = ParameterIn.DEFAULT, description = "Currency/Rate to add", schema = @Schema())
          @Valid
          @RequestBody
          CurrencyRate body);

  @Operation(
      summary = "get currency details (rate asof date/time)",
      description = "Get currency rate asof date/time ",
      tags = {"currency"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "currency rate asof date",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CurrencyRate.class))),
        @ApiResponse(responseCode = "400", description = "input date/time incorrect"),
        @ApiResponse(responseCode = "404", description = "currency code not found")
      })
  @GetMapping(value = "/currency/{code}")
  ResponseEntity<CurrencyRate> getCurrencyRate(
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
          OffsetDateTime asof);

  @Operation(
      summary = "searches currencies",
      description =
          "By passing in the appropriate options, you can search for available currency in the system ",
      tags = {"currency"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "search results matching criteria",
            content =
                @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = CurrencyRate.class)))),
        @ApiResponse(responseCode = "400", description = "bad skip/limit values"),
        @ApiResponse(responseCode = "404", description = "currency code not found")
      })
  @GetMapping(value = "/currency")
  ResponseEntity<List<CurrencyRate>> searchCurrency(
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
          Integer limit);
}