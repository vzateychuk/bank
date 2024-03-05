package vez.ccy.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * CurrencyRate
 */
@Validated
@Builder
@Data
public class CurrencyRate {

  /**
   * currency code
   **/
  @Schema(example = "RUB", description = "currency code")
  @NotBlank
  @JsonProperty("code") private String code;

  /**
   * rate value against base currency
   **/
  @Schema(example = "91.8", description = "rate value against base currency")
  @NotNull @Min(0)
  @JsonProperty("rate")  private BigDecimal rate;

  /**
   * currency name
   **/
  @Schema(example = "Russian Ruble", description = "currency name")
  @JsonProperty("name")  private String name;
}
