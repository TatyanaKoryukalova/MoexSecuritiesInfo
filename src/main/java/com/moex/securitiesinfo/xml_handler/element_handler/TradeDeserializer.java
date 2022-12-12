package com.moex.securitiesinfo.xml_handler.element_handler;

import com.moex.securitiesinfo.model.Trade;
import org.w3c.dom.Element;

import java.time.LocalDate;

public class TradeDeserializer implements Deserializer<Trade> {
    @Override
    public Trade deserialize(Element element) {
        String securityId = element.getAttribute("SECID");
        LocalDate tradeDate = LocalDate.parse(element.getAttribute("TRADEDATE")) ;
        String tradingSession = element.getAttribute("TRADINGSESSION");
        Double open = Double.valueOf(element.getAttribute("OPEN"));
        Double close = Double.valueOf(element.getAttribute("CLOSE"));
        Trade trade = Trade.builder()
                .securityId(securityId)
                .tradeDate(tradeDate)
                .tradingSessions(tradingSession)
                .open(open)
                .close(close)
                .build();
        return trade;
    }
}
