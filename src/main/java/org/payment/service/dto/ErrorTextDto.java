package org.payment.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.payment.service.util.enums.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorTextDto {
    private PaymentStatus status;
    private String message;
}
