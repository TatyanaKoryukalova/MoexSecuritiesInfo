package com.moex.securitiesinfo.moex_request;

public class Request {
    private static final String URL_DELIMITER = "/";
    private static final String PARAMS_DELIMITER = "&";
    private static final String PARAMS_PREFIX = "?";
    private static final String ISS_URL_PREFIX = "https://iss.moex.com/iss/";
    /*
    list of securities request:
    securities.xml - all data in .xml file
        ?iss.meta=off - metadata (on|off)
        &securities.columns=id,secid,regnumber,name,emitent_title - columns required in response table
        &start=0 - pagination, first security index in a table

    trading history for any date
    history/engines/stock/markets/index/securities.xml
        ?date=2010-11-22 - date of trading history
        "&history.columns=SECID,TRADEDATE,TRADINGSESSION,OPEN,CLOSE"),

     */

}
