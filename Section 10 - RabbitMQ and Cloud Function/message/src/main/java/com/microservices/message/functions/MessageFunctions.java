package com.microservices.message.functions;

import com.microservices.message.dto.AccountsMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class MessageFunctions {

    @Bean
    public Function<AccountsMessageDTO, AccountsMessageDTO> email() {
        return accountsMessageDTO -> {
            log.info("Sending email with the details: {}", accountsMessageDTO.toString());
            return accountsMessageDTO;
        };
    }

    @Bean
    public Function<AccountsMessageDTO, Long> sms() {
        return accountsMessageDTO -> {
            log.info("Sending sms with the details: {}", accountsMessageDTO.toString());
            return accountsMessageDTO.accountNumber();
        };
    }
}
