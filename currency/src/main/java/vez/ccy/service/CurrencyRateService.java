package vez.ccy.service;


import vez.ccy.rest.CurrencyRate;

public interface CurrencyRateService {

    CurrencyRate upsert(CurrencyRate ccy);

    CurrencyRate get(String code);
}
