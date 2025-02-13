package org.payment.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.payment.service.dao.entity.PaymentEntity;
import org.payment.service.dao.repository.PaymentRepository;
import org.payment.service.dto.PaymentRequestDto;
import org.payment.service.recpord.StatusResponse;
import org.payment.service.dto.TransferRequestDto;
import org.payment.service.util.enums.PaymentStatus;
import org.payment.service.util.halper.PaymentNumberGenerater;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentNumberGenerater numberGenerater;
    private PaymentEntity entity;

    public StatusResponse postUser(PaymentRequestDto dto) throws Exception {
        var entity = PaymentEntity.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .accountNumber(numberGenerater.generateAndSaveAccountNumber())
                .balance(dto.getBalance())
                .build();
        log.info("Created user: {}, AccountNumber: {}", dto.getName(), entity.getAccountNumber());
        repository.save(entity);

        return new StatusResponse(PaymentStatus.SUCCESS);
    }


    public StatusResponse transferBalance(TransferRequestDto request) {
        var senderEntity = repository.findByAccountNumber(request.getAccountNumber());
        var receiverEntity = repository.findByAccountNumber(request.getAccountNumber2());
        if (senderEntity.isPresent() && receiverEntity.isPresent()) {
            var senderData = senderEntity.get();
            var receiverData = receiverEntity.get();
            if (senderData.getBalance().compareTo(request.getBalance()) >= 0) {
                senderData.setBalance(senderData.getBalance().subtract(request.getBalance()));
                receiverData.setBalance(receiverData.getBalance().add(request.getBalance()));
                repository.save(senderData);
                repository.save(receiverData);
                return new StatusResponse(PaymentStatus.SUCCESS);
            } else {
               return new StatusResponse(PaymentStatus.INSUFFICIENT_BALANCE);
            }
        } else {
            return new StatusResponse(PaymentStatus.NOT_FOUND);
        }
    }


}
