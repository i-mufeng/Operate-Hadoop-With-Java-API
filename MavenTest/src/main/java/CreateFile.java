import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created By IDEA
 * Author:小小小沐风
 * Date:2021/3/21 23:28
 * Discretion:新建文件
 */
public class CreateFile {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        BasicConfigurator.configure();
        conf.set("fs.defaultFS","hdfs://192.168.66.128:9000");
        FileSystem fs = FileSystem.get(conf);
        FSDataOutputStream outputStream = fs.create(new Path("hdfs:/newfile.txt"));
        outputStream.write("这个文件通过Java API 生成".getBytes(StandardCharsets.UTF_8));
        outputStream.close();
        fs.close();
        System.out.println("文件创建成功！");

    }
}
