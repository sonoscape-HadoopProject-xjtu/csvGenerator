package edu.xjtu.slst.bme.utils;

class Parameter {

    private String fileName;
    private String xmin;
    private String xmax;
    private String ymin;
    private String ymax;
    private String className;

    String getClassName() throws IllegalArgumentException {
        if (className == null) throw new IllegalArgumentException("Class name undefined.");
        return className;
    }

    void setClassName(String className) {
        this.className = className;
    }

    String getFileName() throws IllegalArgumentException {
        if (fileName == null) throw new IllegalArgumentException("Filename undefined.");
        return fileName;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }

    String getXmin() throws IllegalArgumentException {
        if (xmin == null) throw new IllegalArgumentException("X-min value undefined.");
        return xmin;
    }

    void setXmin(String xmin) {
        this.xmin = xmin;
    }

    String getXmax() throws IllegalArgumentException {
        if (xmax == null) throw new IllegalArgumentException("X-max value undefined.");
        return xmax;
    }

    void setXmax(String xmax) {
        this.xmax = xmax;
    }

    String getYmin() throws IllegalArgumentException {
        if (ymin == null) throw new IllegalArgumentException("Y-min value undefined.");
        return ymin;
    }

    void setYmin(String ymin) {
        this.ymin = ymin;
    }

    String getYmax() throws IllegalArgumentException {
        if (ymax == null) throw new IllegalArgumentException("Y-max value undefined.");
        return ymax;
    }

    void setYmax(String ymax) {
        this.ymax = ymax;
    }
}
