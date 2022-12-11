package com.moex.securitiesinfo.xml_handler.element_handler;

import com.moex.securitiesinfo.model.Security;
import org.w3c.dom.Element;

public class SecurityDeserializer implements Deserializer<Security> {
    @Override
    public Security deserialize(Element element) {
        Long id = Long.valueOf(element.getAttribute("id"));
        String securityId = element.getAttribute("secid");
        String registrationNumber = element.getAttribute("regnumber");
        String name = element.getAttribute("name");
        String emitentTitle = element.getAttribute("emitent_title");
        Security security = Security.builder()
                .id(id)
                .name(name)
                .emitentTitle(emitentTitle)
                .securityId(securityId)
                .registrationNumber(registrationNumber)
                .build();
        return security;
    }
}
