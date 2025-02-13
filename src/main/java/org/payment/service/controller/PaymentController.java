package org.payment.service.controller;

import lombok.RequiredArgsConstructor;
import org.payment.service.dto.PaymentRequestDto;
import org.payment.service.dto.TransferRequestDto;
import org.payment.service.recpord.StatusResponse;
import org.payment.service.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payment")
class PaymentController {
    private final PaymentService paymentService;
    @PostMapping("/useradd")
    public StatusResponse postUser(@RequestBody PaymentRequestDto dto) throws Exception {
        return paymentService.postUser(dto);
    }
    @PutMapping("/transfer")
    public StatusResponse transferBalance(@RequestBody TransferRequestDto dto){
        return paymentService.transferBalance(dto);
    }
}
