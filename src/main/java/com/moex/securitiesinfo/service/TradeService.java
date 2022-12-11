package com.moex.securitiesinfo.service;

import com.moex.securitiesinfo.model.Security;
import com.moex.securitiesinfo.model.Trade;
import com.moex.securitiesinfo.repository.Repository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class TradeService extends AbstractMoexService<Trade> {
    @Autowired
    private Repository<Security> securityRepository;

    @Override
    public Trade create(Trade trade) {
        String securiryId = trade.getSecurityId();
        if (securityRepository.readBySecurityId(securiryId).isEmpty()){
            throw new EntityNotFoundException("Ценной бумаги нет в базе");
        }
        return repository.save(trade);
    }
}
