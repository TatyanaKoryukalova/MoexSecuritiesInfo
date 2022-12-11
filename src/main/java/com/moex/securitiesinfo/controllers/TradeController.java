package com.moex.securitiesinfo.controllers;

import com.moex.securitiesinfo.model.Security;
import com.moex.securitiesinfo.model.Trade;
import com.moex.securitiesinfo.moex_request.Request;
import com.moex.securitiesinfo.service.MoexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * todo
 * это набросок контроллера с методом добавления оного трейда, чтобы не забыть
 * что-то не так, но ладно
 *
 * todo
 * Итак, задача минимум. один контроллер.
 * На индекс выводится сводная таблица и всё
 * в контроллере только гет метод с загрузкой xml, если пустые таблицы,  подгрузкой данных где надо
 * выводом сводной таблицы
 */
@Controller
public class TradeController {
//    @Autowired
//    private MoexService<Trade> tradeMoexService;
//    @Autowired
//    private MoexService<Security> securityMoexService;
//    //todo???
//    private Request moexRequest;

    @GetMapping("/")
    public void someMethod(Trade trade) throws IOException {
        readXmlByUrl(new URL("https://iss.moex.com/iss/securities.xml" +
                        "?iss.meta=off" +
                        "&securities.columns=id,secid,regnumber,name,emitent_title"),
                "securities.xml");
        readXmlByUrl(new URL("https://iss.moex.com/iss/history/engines/stock/markets/index/securities.xml" +
                        "?date=2010-11-22" +
                        "&history.columns=SECID,TRADEDATE,TRADINGSESSION,OPEN,CLOSE"),
                "history.xml");
    }
//
//    private void extracted(Trade trade) {
//        String securityId = trade.getSecurityId();
//        try {
//            securityMoexService.readBySecurityId(securityId);
//        } catch (EntityNotFoundException exception){
//            File file = moexRequest.requestSecurity(securityId);
//            try {
//                securityMoexService.saveFromXML(file);
//            } catch (IOException e) {
//                //todo refactor
//                throw new RuntimeException(e);
//            } catch (SAXException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        tradeMoexService.create(trade);
//    }
    private void readXmlByUrl(URL url, String filename) throws IOException {
        ReadableByteChannel readableByteChannel =
                Channels.newChannel(url.openStream());
        File fileForRecord = new File("src/main/resources/xml",filename);;
        FileOutputStream outputStream = new FileOutputStream(fileForRecord);
        outputStream.getChannel().transferFrom(readableByteChannel,0,Long.MAX_VALUE);
        outputStream.close();
    }
    //http://iss.moex.com/iss/securities.xml?q=SEARCH_STRING - запрос по бумаге, где SEARCH_STRING - secid
    //&securities.columns=name ...
}
