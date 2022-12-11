package com.moex.securitiesinfo.xml_handler;

import com.moex.securitiesinfo.model.DataSet;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Производит парсинг и дальнейшую обработку XML-файла
 * для получение требуемых объектов
 *
 * На момент решения о существовании XMLMapper не знала,
 * поэтому использовано данное решение
 */
@Component
public interface XmlHandler<T extends DataSet> {
    /**
     * Парсит XML-файл в коллекции
     * @param file - XML-файл с входными данными
     */
    void handle(File file) throws IOException, SAXException;

    /**
     * Возвращает количество элементов в коллекции
     * @return
     */
    int getLength();

    /**
     * Возвращает объект с указанным индексом
     * @param index - инфекс объекта в коллекции
     * @return - указанный объект
     */
    T item(int index);
}
