import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

/**
 * Created By IDEA
 * Author:小小小沐风
 * Date:2021/3/22 17:20
 * Discretion:下载文件到本地
 */
public class DownloadFile {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();

        BasicConfigurator.configure();

        //设置HDFS访问地址
        conf.set("fs.defaultFS","hdfs://192.168.66.128:9000");
        //取的FileSystem文件系统实例
        FileSystem fs = FileSystem.get(conf);
        Path src = new Path("hdfs:/test.rar");
        Path dst = new Path("D:/");
        fs.copyToLocalFile(src,dst);
        System.out.println("下载文件成功");
    }
}
