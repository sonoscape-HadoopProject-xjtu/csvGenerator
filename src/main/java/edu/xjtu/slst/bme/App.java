package edu.xjtu.slst.bme;

import edu.xjtu.slst.bme.utils.BaseThread;

class App {
    private static final String[] XMLFolder = {
            "E:\\HadoopServer\\AllBaby\\1-5507",
            "E:\\HadoopServer\\AllBaby\\5508-11014",
            "E:\\HadoopServer\\AllBaby\\11015",
            "E:\\HadoopServer\\AllBaby\\15520"
    };
    private static final String csvFullPath = "E:\\HadoopServer\\AllBaby\\test.csv";

    public static void main(String[] args) {
        BaseThread.setCsvFileDir(csvFullPath);

        for (String FILE_ROOT_DIR : XMLFolder) {
            BaseThread baseThread = new BaseThread();
            baseThread.setFileRootDir(FILE_ROOT_DIR);
            baseThread.start();
        }

    }
}
