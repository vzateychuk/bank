package vez.ccy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * CurrencyRate
 */
@Validated
public class CurrencyRate {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("rate")
  private BigDecimal rate = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("from")
  private OffsetDateTime from = null;

  @JsonProperty("to")
  private OffsetDateTime to = null;

  public CurrencyRate code(String code) {
    this.code = code;
    return this;
  }

  /**
   * currency code
   * @return code
   **/
  @Schema(example = "RUB", required = true, description = "currency code")
      @NotNull

    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public CurrencyRate rate(BigDecimal rate) {
    this.rate = rate;
    return this;
  }

  /**
   * rate value agains base currency
   * @return rate
   **/
  @Schema(example = "91.8", required = true, description = "rate value against base currency")
      @NotNull

    @Valid
    public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public CurrencyRate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * currency name
   * @return name
   **/
  @Schema(example = "Russan Ruble", description = "currency name")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CurrencyRate from(OffsetDateTime from) {
    this.from = from;
    return this;
  }

  /**
   * The datetime when rate is active. ISO_ZONED_DATE_TIME format: yyyy-mm-ddThh:mm:ss.SSS+offset value[zone id].  
   * @return from
   **/
  @Schema(example = "2024-01-01T01:01:01Z", description = "The datetime when rate is active. ISO_ZONED_DATE_TIME format: yyyy-mm-ddThh:mm:ss.SSS+offset value[zone id].  ")
  
    @Valid
    public OffsetDateTime getFrom() {
    return from;
  }

  public void setFrom(OffsetDateTime from) {
    this.from = from;
  }

  public CurrencyRate to(OffsetDateTime to) {
    this.to = to;
    return this;
  }

  /**
   * The datetime when rate deactivated. ISO_ZONED_DATE_TIME format. 
   * @return to
   **/
  @Schema(example = "2999-01-01T01:01:01Z", description = "The datetime when rate deactivated. ISO_ZONED_DATE_TIME format. ")
  
    @Valid
    public OffsetDateTime getTo() {
    return to;
  }

  public void setTo(OffsetDateTime to) {
    this.to = to;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrencyRate currencyRate = (CurrencyRate) o;
    return Objects.equals(this.code, currencyRate.code) &&
        Objects.equals(this.rate, currencyRate.rate) &&
        Objects.equals(this.name, currencyRate.name) &&
        Objects.equals(this.from, currencyRate.from) &&
        Objects.equals(this.to, currencyRate.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, rate, name, from, to);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CurrencyRate {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
