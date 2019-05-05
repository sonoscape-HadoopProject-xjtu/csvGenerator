package edu.xjtu.slst.bme.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

class CSVWrite {
    private final static Logger logger = LogManager.getLogger(CSVWrite.class);
    private String filePath;
    private Writer out;
    private CSVPrinter printer;

    void setFilePath(String FilePath) {
        filePath = FilePath;
    }

    void writeCSV(List<Parameter> parameterList, String fileName) {
        CSVFormat format = CSVFormat.DEFAULT;
        try {
            out = new FileWriter(filePath + fileName);
            printer = new CSVPrinter(out, format);
            for (Parameter parameter : parameterList) {
                List<String> records = new ArrayList<>();
                records.add(parameter.getFileName());
                records.add(parameter.getXmin());
                records.add(parameter.getXmax());
                records.add(parameter.getYmin());
                records.add(parameter.getYmax());
                records.add(parameter.getClassName());
                printer.printRecord(records);
            }
            logger.info("Successfully write csv file: " + filePath + fileName);
        } catch (IOException e) {
            logger.error(e.toString());
            System.exit(-1);
        }
    }

    void close() throws IOException {
        printer.close();
        out.close();
    }
}
