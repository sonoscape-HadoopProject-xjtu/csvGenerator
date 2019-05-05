package edu.xjtu.slst.bme.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseThread implements Runnable {
    private Thread t;
    private final static Logger logger = LogManager.getLogger(BaseThread.class);
    private volatile static CSVUtil csvUtil = new CSVUtil();
    private String FILE_ROOT_DIR;

    /**
     * Set location storage csv file.
     *
     * @param csvFileDir CSV_FILE_DIR.
     */
    public static void setCsvFileDir(String csvFileDir) {
        csvUtil.setFilePath(csvFileDir);
    }

    /**
     * Set File Dir.
     *
     * @param fileRootDir FILE_ROOT_DIR.
     */
    public void setFileRootDir(String fileRootDir) {
        FILE_ROOT_DIR = fileRootDir;
    }

    /**
     * Get all file names from FILE_ROOT_DIR and save csv file to CSV_FILE_DIR
     */
    @Override
    public void run() {
        // If there is no file in the folder, interrupt the thread and exit.
        if (FILE_ROOT_DIR.isEmpty()) {
            t.interrupt();
            throw new IllegalArgumentException("File dir have not been set yet. Process exit.");
        } else {
            File[] files = new File(FILE_ROOT_DIR).listFiles();
            List<Parameter> parameterList = new ArrayList<>();

            // Get all file information and parse XML Files.
            if (files == null) throw new NullPointerException("Empty folder.");

            // Parse every XML file.
            for (File file : files) {
                String fileName = file.getName();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

                if (Objects.equals(suffix, "xml")) {
                    Parameter parameter = XMLParse.parseParameters(file);
                    if (parameter != null)
                        parameterList.add(parameter);
                    else
                        throw new NullPointerException("Empty parameter detected. Maybe XMLParse class did not work properly.");
                }
            }

            // Write CSV Files.
            try {
                csvUtil.writeCSV(parameterList);
            } catch (IllegalArgumentException e) {
                logger.fatal(e.toString());
                t.interrupt();
            }
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, FILE_ROOT_DIR);
            t.start();
        }
    }
}
