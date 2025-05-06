package com.microservices.accounts.functions;

import com.microservices.accounts.service.IAccountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class AccountFunctions {

    @Bean
    public Consumer<Long> updateCommunication(IAccountsService accountsService) {
        return accountNumber -> {
          log.info("Update account status: {}", accountNumber.toString());
          accountsService.updateCommunicationStatus(accountNumber);
        };
    }
}
