import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created By IDEA
 * Author:小小小沐风
 * Date:2021/3/22 16:49
 * Discretion:获取文件或目录的元数据
 */
public class FileStatusCat {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();

        BasicConfigurator.configure();

        //设置HDFS访问地址
        conf.set("fs.defaultFS","hdfs://192.168.66.128:9000");
        //取的FileSystem文件系统实例
        FileSystem fs = FileSystem.get(conf);
        FileStatus fileStatus = fs.getFileStatus(new Path("hdfs:/file.txt"));
        //判断是文件还是文件夹
        if (fileStatus.isDirectory()){
            System.out.println("这是一个文件夹");
        }else {
            System.out.println("这是一个文件");
        }

        //输出元数据信息
        System.out.println("文件路径：" + fileStatus.getPath());
        System.out.println("文件修改日期：" + new Timestamp(fileStatus.getModificationTime()).toString());
        System.out.println("文件上次访问日期：" + new Timestamp(fileStatus.getAccessTime()).toString());
        System.out.println("文件长度：" + fileStatus.getLen());
        System.out.println("文件备份数：" + fileStatus.getReplication());
        System.out.println("文件块大小：" + fileStatus.getBlockSize());
        System.out.println("文件所有者：" + fileStatus.getOwner());
        System.out.println("文件所在分组：" + fileStatus.getGroup());
        System.out.println("文件的权限：" + fileStatus.getPermission().toString());
    }
}
