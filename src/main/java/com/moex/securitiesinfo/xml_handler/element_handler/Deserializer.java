package com.moex.securitiesinfo.xml_handler.element_handler;

import com.moex.securitiesinfo.model.DataSet;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

/**
 * Десериализатор представленных в приложении сущностей
 * из типа Element
 *
 * @param <T> - тип получаемой сущности
 */
@Component
public interface Deserializer<T extends DataSet> {
    /**
     * Возвращает элемент типа DataSet на основе заданного Element
     *
     * @param element - элемент к преобразованию
     * @return требуемый объект сущности
     */
    T deserialize(Element element);
}
