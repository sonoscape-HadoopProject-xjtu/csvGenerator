package edu.xjtu.slst.bme.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Parameter {
    private final static Logger logger = LogManager.getLogger(Parameter.class);

    private String fileName;
    private String xmin;
    private String xmax;
    private String ymin;
    private String ymax;
    private String className;

    String getClassName() {
        return className;
    }

    void setClassName(String className) {
        this.className = className;
    }

    String getFileName() {
        return fileName;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }

    String getXmin() {
        return xmin;
    }

    void setXmin(String xmin) {
        this.xmin = xmin;
    }

    String getXmax() {
        return xmax;
    }

    void setXmax(String xmax) {
        this.xmax = xmax;
    }

    String getYmin() {
        return ymin;
    }

    void setYmin(String ymin) {
        this.ymin = ymin;
    }

    String getYmax() {
        return ymax;
    }

    void setYmax(String ymax) {
        this.ymax = ymax;
    }
}
