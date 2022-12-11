package com.moex.securitiesinfo.service;

import com.moex.securitiesinfo.model.DataSet;
import com.moex.securitiesinfo.repository.Repository;
import com.moex.securitiesinfo.xml_handler.XmlHandler;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public abstract class AbstractMoexService<T extends DataSet> implements MoexService<T> {
    @Autowired
    protected Repository<T> repository;
    @Autowired
    private XmlHandler<T> xmlHandler;

    @Override
    public void saveFromXML(File file) throws IOException, SAXException {
        xmlHandler.handle(file);
        for (int i = 0; i < xmlHandler.getLength(); i++) {
            create(xmlHandler.item(i));
        }
    }

    @Override
    public T readBySecurityId(String securityId) {
        return repository.readBySecurityId(securityId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public T read(Long entityId) {
        return repository.findById(entityId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public T update(T updatedEntity) {
        return repository.save(updatedEntity);
    }

    @Override
    public void delete(Long entityId) {
        repository.deleteById(entityId);
    }
}
