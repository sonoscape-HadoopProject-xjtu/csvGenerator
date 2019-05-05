package edu.xjtu.slst.bme.utils;

import com.csvreader.CsvWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class CSVUtil {
    private final static Logger logger = LogManager.getLogger(CSVUtil.class);
    private static String csvFilePath;

    void setFilePath(String filePath) {
        csvFilePath = filePath;
    }

    /**
     * @param parameterList parameter List. See Parameter.java for more information.
     */
    synchronized void writeCSV(List<Parameter> parameterList) throws IllegalArgumentException {
        File file = new File(csvFilePath);
        CsvWriter csvWriter;
        try {
            if (file.exists()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                csvWriter = new CsvWriter(writer, ',');
            } else {
                csvWriter = new CsvWriter(csvFilePath);
            }
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
            logger.info("Successfully write csv file: " + csvFilePath);
        } catch (IOException e) {
            logger.error(e.toString());
            System.exit(-1);
        }
    }
}
