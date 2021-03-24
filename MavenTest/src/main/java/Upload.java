import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.apache.log4j.BasicConfigurator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created By IDEA
 * Author:小小小沐风
 * Date:2021/3/21 23:38
 * Discretion:上传文件
 */
public class Upload {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        BasicConfigurator.configure();
        conf.set("fs.defaultFS","hdfs://192.168.66.128:9000");
        InputStream in = new BufferedInputStream( new FileInputStream("D:\\apache\\Hadoop-2.3-master\\config.rar"));
        FileSystem fs = FileSystem.get(conf);

        FSDataOutputStream outputStream = fs.create(new Path("hdfs:/test.rar"), new Progressable() {
            @Override
            public void progress() {
                System.out.print(". ");
            }
        });
        IOUtils.copyBytes(in,outputStream,4096,false);
    }
}
