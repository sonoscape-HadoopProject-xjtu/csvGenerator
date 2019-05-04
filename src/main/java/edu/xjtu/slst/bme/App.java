package edu.xjtu.slst.bme;

import edu.xjtu.slst.bme.utils.BaseThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String[] XMLFolder = {
            "E:\\HadoopServer\\AllBaby\\1-5507",
            "E:\\HadoopServer\\AllBaby\\5508-11014",
            "E:\\HadoopServer\\AllBaby\\11015",
            "E:\\HadoopServer\\AllBaby\\15520"
    };
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        List<BaseThread> baseThreadList = new ArrayList<>();
        for (String FILE_ROOT_DIR : XMLFolder) {
            BaseThread baseThread = new BaseThread(FILE_ROOT_DIR);
            baseThreadList.add(baseThread);
            baseThread.run();
        }

        try {
            for (BaseThread baseThread : baseThreadList)
                baseThread.close();
        } catch (IOException e) {
            logger.error(e.toString());
        }

    }
}
