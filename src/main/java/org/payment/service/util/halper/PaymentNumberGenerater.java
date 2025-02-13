package org.payment.service.util.halper;

import lombok.RequiredArgsConstructor;
import org.payment.service.dao.repository.PaymentRepository;
import org.payment.service.exception.AccountNumberCreatedException;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
@RequiredArgsConstructor
public class PaymentNumberGenerater {
    private final PaymentRepository repository;


    public String generateAndSaveAccountNumber()throws Exception {
        String accountNumber;
        int count = 0;
        var random = new SecureRandom();
        var isMaxAttemptsReached  = false;
        do {
            count++;
            var otp = random.nextInt(1, 999999999);
            accountNumber = String.format("AZ%09d", otp);

            if (count>=3){
                isMaxAttemptsReached  = true;
                break;
            }
        } while (repository.existsByAccountNumber(accountNumber));
        if(isMaxAttemptsReached ){
            throw new AccountNumberCreatedException("account number could not be created");
        }else{
            return accountNumber;
        }

    }
}
