package org.payment.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class TransferRequestDto {
    @JsonProperty("sender")
    String accountNumber;
    @JsonProperty("receiver")
    String accountNumber2;
    BigDecimal balance;
}
