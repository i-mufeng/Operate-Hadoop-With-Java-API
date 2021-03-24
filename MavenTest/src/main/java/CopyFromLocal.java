import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

/**
 * Created By IDEA
 * Author:小小小沐风
 * Date:2021/3/22 17:17
 * Discretion:上传本地文件
 */
public class CopyFromLocal {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();

        BasicConfigurator.configure();

        //设置HDFS访问地址
        conf.set("fs.defaultFS","hdfs://192.168.66.128:9000");
        //取的FileSystem文件系统实例
        FileSystem fs = FileSystem.get(conf);
        Path src = new Path("F:/copy_test.txt");
        Path dst = new Path("hdfs:/newfile2.txt");
        fs.copyFromLocalFile(src,dst);
        System.out.println("上传文件成功");
    }
}
