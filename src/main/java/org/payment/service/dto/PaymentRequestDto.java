package org.payment.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {
    String name;
    String surname;
    BigDecimal balance;
}


