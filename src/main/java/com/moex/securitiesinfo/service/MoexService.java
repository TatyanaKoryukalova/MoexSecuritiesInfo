package com.moex.securitiesinfo.service;

import com.moex.securitiesinfo.model.DataSet;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

@Service
public interface MoexService<T extends DataSet> {

    T create(T entity);

    T read(Long entityId);

    T update(T updatedEntity);

    void delete(Long entityId);

    void saveFromXML(File file) throws IOException, SAXException;

    T readBySecurityId(String securityId);
}
