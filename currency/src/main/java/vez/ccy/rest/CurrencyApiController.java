package vez.ccy.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vez.ccy.service.CurrencyRateService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CurrencyApiController implements CurrencyApi {

  private final CurrencyRateService service;

  @Override
  public ResponseEntity<CurrencyRate> addCurrency(CurrencyRate ccy) {
    CurrencyRate added = service.upsert(ccy);
    return new ResponseEntity<>(added, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<CurrencyRate> getCurrencyRate(String code) {
    CurrencyRate found = service.get(code);
    return new ResponseEntity<>(found, HttpStatus.OK);
  }
}
