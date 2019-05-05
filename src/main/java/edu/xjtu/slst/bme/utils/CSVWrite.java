package edu.xjtu.slst.bme.utils;

import com.csvreader.CsvWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

class CSVWrite {
    private final static Logger logger = LogManager.getLogger(CSVWrite.class);
    private String filePath;

    void setFilePath(String FilePath) {
        filePath = FilePath;
    }

    void writeCSV(List<Parameter> parameterList) {
        CsvWriter csvWriter = new CsvWriter(filePath + ".csv");
        try {
            for (Parameter parameter : parameterList)
                csvWriter.writeRecord(new String[]{
                        parameter.getFileName(),
                        parameter.getXmin(),
                        parameter.getXmax(),
                        parameter.getYmin(),
                        parameter.getYmax(),
                        parameter.getClassName()
                });
            csvWriter.close();
            logger.info("Successfully write csv file: " + filePath + ".csv");
        } catch (IOException e) {
            logger.error(e.toString());
            System.exit(-1);
        }
    }
}
