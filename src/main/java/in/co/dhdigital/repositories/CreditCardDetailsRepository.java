package in.co.dhdigital.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.co.dhdigital.models.CreditCardDetails;

@Repository
public interface CreditCardDetailsRepository extends CrudRepository<CreditCardDetails, Long> {

	List<CreditCardDetails> findByCardNumber(String cardNumber);
}
