package vez.ccy.exception;

public class CurrencyNotFoundException extends RuntimeException {

  public CurrencyNotFoundException(String code) {
      super(code);
  }
}
