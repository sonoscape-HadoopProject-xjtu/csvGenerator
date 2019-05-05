package edu.xjtu.slst.bme.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseThread implements Runnable {
    private final static Logger logger = LogManager.getLogger(BaseThread.class);
    private final static CSVWrite csv = new CSVWrite();
    private static String FILE_ROOT_DIR;

    public void setFileRootDir(String fileRootDir) {
        FILE_ROOT_DIR = fileRootDir;

    }

    /**
     * Get all file names from FILE_ROOT_DIR
     */
    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + " is already running.");
        if (FILE_ROOT_DIR.isEmpty()) {
            logger.error("File dir have not been set yet. Process exit.");
            Thread.currentThread().interrupt();
        } else {
        File[] files = new File(FILE_ROOT_DIR).listFiles();
        List<Parameter> parameterList = new ArrayList<>();
        // Get all file information and parse XML Files.
        assert files != null;
        for (File file : files) {
            String fileName = file.getName();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (Objects.equals(suffix, "xml")) {
                Parameter parameter = XMLParse.parseParameters(file);
                if (parameter != null)
                    parameterList.add(parameter);
                else {
                    logger.fatal("Empty parameter detected. Maybe XMLParse class did not work properly.");
                    System.exit(-1);
                }
            }
        }
        csv.setFilePath(FILE_ROOT_DIR);
            csv.writeCSV(parameterList);
        }
        logger.info(Thread.currentThread().getName() + " finished.");
    }
}
