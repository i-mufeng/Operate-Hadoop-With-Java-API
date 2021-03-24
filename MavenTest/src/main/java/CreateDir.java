import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

/**
 * Created By IDEA
 * Author:小小小沐风
 * Date:2021/3/21 23:19
 * Discretion:创建HDFS目录mydir
 */
public class CreateDir {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        BasicConfigurator.configure();
        conf.set("fs.defaultFS","hdfs://192.168.66.128:9000");
        FileSystem fs = FileSystem.get(conf);
        boolean isok = fs.mkdirs(new Path("hdfs:/mydir"));
        if (isok){
            System.out.println("创建目录成功！");
        }
        else {
            System.out.println("创建目录失败！");
        }
        fs.close();
    }
}
