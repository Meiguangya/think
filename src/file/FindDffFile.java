package file;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FindDffFile {

    public static void main(String[] args) {
        File file1 = new File("/Users/meiguangya/Downloads/对比/1/web/WEB-INF/lib");
        File file2 = new File("/Users/meiguangya/Downloads/对比/2/web/WEB-INF/lib");
        if(file1.isDirectory()){
            File[] files = file1.listFiles();
            File[] files2 = file2.listFiles();
            Set<String> file1Names = new HashSet<>();
            for (File file : files) {
                file1Names.add(file.getName());
            }
            System.out.println(file1Names.size());
            for (File file : files2) {
                if(file1Names.contains(file.getName())){
                    if(file.getName().contains("shiro-lang")){
                        System.out.println(file.getName());
                    }
                    file1Names.remove(file.getName());
                }
            }
            System.out.println(file1Names.size());

            file1Names.forEach(e-> System.out.println(e));
        }

    }

    //commons-logging-1.1.1.jar
    //commons-lang-2.5.jar

    //commons-logging-1.0.4.jar
    //commons-lang-2.3.jar

}
