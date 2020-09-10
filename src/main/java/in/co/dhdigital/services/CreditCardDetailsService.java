package in.co.dhdigital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.co.dhdigital.models.CreditCardDetails;
import in.co.dhdigital.repositories.CreditCardDetailsRepository;
import service.in.co.dhdigital.ws.types.CreditCardDetailsRequest;
import service.in.co.dhdigital.ws.types.CreditCardDetailsResponse;



public class CreditCardDetailsService {

	@Autowired
	CreditCardDetailsRepository creditCardDetailsRepository;
	
	public CreditCardDetailsResponse getCreditCardDetails(CreditCardDetailsRequest request) {
		String creditCardNumber = request.getCreditCardNumber();
		System.out.println("CreditCardNumber : "+creditCardNumber);
		
		List<CreditCardDetails> creditCardDetailsList= creditCardDetailsRepository.findByCardNumber(creditCardNumber);
		CreditCardDetailsResponse response = new CreditCardDetailsResponse();
		
		if (creditCardDetailsList != null && creditCardDetailsList.size()>0){
			response.setCardNumber(creditCardDetailsList.get(0).getCardNumber());
			response.setCustomerName(creditCardDetailsList.get(0).getCustomerName());
			response.setCardType(creditCardDetailsList.get(0).getCardType());
			//response.setDateOfBirth(creditCardDetailsList.get(0).getDateOfBirth());
			response.setGender(creditCardDetailsList.get(0).getGender());
		}
		return response;
		
	}
}
