package vez.ccy.mapper;

import org.mapstruct.Mapper;
import vez.ccy.entity.CurrencyRateEntity;
import vez.ccy.rest.CurrencyRate;

@Mapper(componentModel = "spring")
public interface CurrencyRateMapper {
    CurrencyRateEntity dtoToEntity(CurrencyRate dto);
    CurrencyRate entityToDto(CurrencyRateEntity entity);
}
