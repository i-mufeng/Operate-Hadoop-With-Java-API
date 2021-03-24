import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

/**
 * Created By IDEA
 * Author:小小小沐风
 * Date:2021/3/22 16:34
 * Discretion:遍历文件和目录
 */
public class ListStatus {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        BasicConfigurator.configure();

        //设置HDFS访问地址
        conf.set("fs.defaultFS","hdfs://192.168.66.128:9000");
        //取的FileSystem文件系统实例
        FileSystem hdfs = FileSystem.get(conf);

        FileStatus[] fs = hdfs.listStatus(new Path("hdfs:/"));
        if (fs.length > 0){
            for (FileStatus f : fs){
                showDir(f,hdfs);
            }
        }
    }

    public static void showDir(FileStatus fs,FileSystem hdfs) throws Exception{
        Path path = fs.getPath();
        System.out.println(path);

        if (fs.isDirectory()){
            FileStatus[] f = hdfs.listStatus(path);
            if (f.length > 0){
                for (FileStatus file : f){
                    showDir(file,hdfs);
                }
            }
        }
    }
}
