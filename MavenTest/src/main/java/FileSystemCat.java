import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.log4j.BasicConfigurator;

import java.io.InputStream;

/**
 * Created By IDEA
 * Author:小小小沐风
 * Date:2021/3/20 22:28
 * Discretion:查询HDFS文件内容并输出
 */
public class FileSystemCat {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        BasicConfigurator.configure();

        //设置HDFS访问地址
        conf.set("fs.defaultFS","hdfs://192.168.66.128:9000");
        //取的FileSystem文件系统实例
        FileSystem fs = FileSystem.get(conf);
        //打开文件输入流
        InputStream in = fs.open(new Path("hdfs:/test.txt"));
        //输出文件内容
        IOUtils.copyBytes(in,System.out,4096,false);
        //关闭输入流
        IOUtils.closeStream(in);
    }
}
