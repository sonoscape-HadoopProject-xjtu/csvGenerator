package edu.xjtu.slst.bme;

import edu.xjtu.slst.bme.utils.BaseThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {
    private static final String[] XMLFolder = {
            "E:\\HadoopServer\\AllBaby\\1-5507",
            "E:\\HadoopServer\\AllBaby\\5508-11014",
            "E:\\HadoopServer\\AllBaby\\11015",
            "E:\\HadoopServer\\AllBaby\\15520"
    };
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        BaseThread baseThread = new BaseThread();

        for (String FILE_ROOT_DIR : XMLFolder) {
            baseThread.setFileRootDir(FILE_ROOT_DIR);
            baseThread.run();
        }

    }
}
