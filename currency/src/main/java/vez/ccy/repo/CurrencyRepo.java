package vez.ccy.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vez.ccy.entity.CurrencyRateEntity;

@Repository
public interface CurrencyRepo extends MongoRepository<CurrencyRateEntity, String> { }
