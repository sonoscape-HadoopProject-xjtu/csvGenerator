package edu.xjtu.slst.bme.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

class XMLParse {
    private final static Logger logger = LogManager.getLogger(XMLParse.class);

    /**
     * @param file File object.
     * @return A parameter object that includes information we need.
     */
    static Parameter parseParameters(File file) {
        try {
            Document document = new SAXReader().read(file);
            Parameter parameter = new Parameter();

            Element rootElement = document.getRootElement();

            parameter.setFileName(file.getPath().
                    substring(0,
                            file.getPath().lastIndexOf(".")) + ".jpg");

            Element object = rootElement.element("object");
            parameter.setClassName(object.element("name").getText());

            Element bndBox = object.element("bndbox");

            parameter.setXmin(bndBox.element("xmin").getText());
            parameter.setYmin(bndBox.element("ymin").getText());
            parameter.setXmax(bndBox.element("xmax").getText());
            parameter.setYmax(bndBox.element("ymax").getText());

            return parameter;
        } catch (IllegalArgumentException | DocumentException e) {
            logger.fatal(e.toString());
            return null;
        }
    }
}
