package vez.ccy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vez.ccy.entity.CurrencyRateEntity;
import vez.ccy.exception.CurrencyNotFoundException;
import vez.ccy.mapper.CurrencyRateMapper;
import vez.ccy.repo.CurrencyRepo;
import vez.ccy.rest.CurrencyRate;

@Service
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {

  private final CurrencyRateMapper mapper;
  private final CurrencyRepo repo;

  @Override
  public CurrencyRate upsert(CurrencyRate dto) {
    CurrencyRateEntity entity = mapper.dtoToEntity(dto);
    CurrencyRateEntity added = repo.save(entity);
    return mapper.entityToDto(added);
  }

  @Override
  public CurrencyRate get(String code) {
    CurrencyRateEntity found = repo.findById(code).orElseThrow(() -> new CurrencyNotFoundException(code));
    return mapper.entityToDto(found);
  }
}
