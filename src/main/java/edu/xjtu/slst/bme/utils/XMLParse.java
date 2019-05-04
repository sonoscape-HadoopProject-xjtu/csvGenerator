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

    @org.jetbrains.annotations.Nullable
    static Parameter parseParameters(File file) {
        try {
            Document document = new SAXReader().read(file);
            Parameter parameter = new Parameter();

            Element rootElement = document.getRootElement();
            parameter.setFileName(file.getPath());

            Element object = rootElement.element("object");
            parameter.setClassName(object.element("name").getText());

            Element bndBox = object.element("bndbox");

            parameter.setXmin(Integer.getInteger(
                    bndBox.element("xmin").getText()
            ));
            parameter.setYmin(Integer.getInteger(
                    bndBox.element("ymin").getText()
            ));
            parameter.setXmax(Integer.getInteger(
                    bndBox.element("xmax").getText()
            ));
            parameter.setYmax(Integer.getInteger(
                    bndBox.element("ymax").getText()
            ));
            logger.info("Successfully parse XML file: " + file.getName() + ".");
            return parameter;
        } catch (IllegalArgumentException | DocumentException e) {
            logger.fatal(e.toString());
            return null;
        }
    }
}
