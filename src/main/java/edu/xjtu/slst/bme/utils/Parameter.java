package edu.xjtu.slst.bme.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Parameter {
    private final static Logger logger = LogManager.getLogger(Parameter.class);

    private String fileName;
    private int xmin;
    private int xmax;
    private int ymin;
    private int ymax;
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

    int getXmin() {
        return xmin;
    }

    void setXmin(int xmin) {
        this.xmin = xmin;
    }

    int getXmax() {
        return xmax;
    }

    void setXmax(int xmax) {
        this.xmax = xmax;
    }

    int getYmin() {
        return ymin;
    }

    void setYmin(int ymin) {
        this.ymin = ymin;
    }

    int getYmax() {
        return ymax;
    }

    void setYmax(int ymax) {
        this.ymax = ymax;
    }
}
