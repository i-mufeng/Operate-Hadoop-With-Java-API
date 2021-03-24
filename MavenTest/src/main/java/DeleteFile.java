import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

/**
 * Created By IDEA
 * Author:小小小沐风
 * Date:2021/3/22 14:27
 * Discretion:删除文件
 */
public class DeleteFile {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();

        BasicConfigurator.configure();

        //设置HDFS访问地址
        conf.set("fs.defaultFS","hdfs://192.168.66.128:9000");
        //取的FileSystem文件系统实例
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path("hdfs:/newfile.txt");
        boolean isok = fs.deleteOnExit(path);
        if (isok){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        fs.close();
    }
}
