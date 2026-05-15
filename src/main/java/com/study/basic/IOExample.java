package com.study.basic;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class IOExample {

    public static void IOIntroduce() {
        System.out.println();
        System.out.println("IO体系");
        System.out.println("1.IO分为字节流和字符流，主要的类有 InputStream、OutputStream、Reader、Writer。");
        System.out.println("2.字节流可以处理一切文件，字符流一般只能处理文字。");
        System.out.println("3.缓冲字节流对于提升效率非常高，缓冲字符流则没这么高。");
    }

    public static void FileExample() throws IOException {
        System.out.println();
        System.out.println("文件流");
        System.out.println("有三种方式创建构造函数");
        // 构造函数
        System.out.println("1.传入路径，类型String");
        String path = "D:\\test.txt";
        File file1 = new File(path);
        System.out.println(file1);
        System.out.println("2.传入父路径和子路径，类型都是String");
        String parent = "D:\\";
        String child = "test.txt";
        File file2 = new File(parent, child);
        System.out.println(file2);
        System.out.println("3.传入File父路径和String子路径");
        File parentFile = new File(parent);
        File file3 = new File(parentFile, child);
        System.out.println(file3);
        // 常用方法
        File f = new File("/Users/username/aaa/bbb.java");
        System.out.println("f的绝对路径 " + f.getAbsolutePath());
        System.out.println("f的完整路径 " + f.getPath());
        System.out.println("f的长度 " + f.length());
        System.out.println("f的名称 " + f.getName());
        System.out.println("判断文件是否存在 " + f.exists());
        System.out.println("判断是否为目录 " + f.isDirectory());
        System.out.println("判断是否为文件 " + f.isFile());
        System.out.println("创建文件等方法 ");
        // 3.创建多级目录
        File newFileDirectory = new File("D:/study/github/java-backend-notes/testDir");
        if (newFileDirectory.mkdirs()) {
            System.out.println("创建文件夹成功 " + newFileDirectory.getAbsolutePath());

            // 1.创建文件
            File newFile = new File("D:/study/github/java-backend-notes/testFile.txt");
            if (newFile.createNewFile()) {
                System.out.println("创建成功 " + newFile.getAbsolutePath());
            } else {
                System.out.println("创建失败 " + newFile.getAbsolutePath());
            }

            // 2.删除文件
            if (newFile.exists()) {
                if (newFile.delete()) {
                    System.out.println("删除成功 " + newFile.getAbsolutePath());
                } else {
                    System.out.println("删除失败 " + newFile.getAbsolutePath());
                }
            }
        } else {
            System.out.println("创建文件夹失败 " + newFileDirectory.getAbsolutePath());
            newFileDirectory.delete();
        }

        // 4.列出目录下的所有文件名
        File findAllFiles = new File("D:/study/github/java-backend-notes/src/main/java/com/study/basic/demo");
        System.out.println("这个目录下的所有文件名 " + Arrays.toString(findAllFiles.list()));
        // 5.列出目录下所有文件和子目录
        File findAllFilesDirs = new File("D:/study/github/java-backend-notes/src/main/java/com/study/basic");
        System.out.println("这个目录下的所有文件和子目录 " + Arrays.toString(findAllFilesDirs.listFiles()));

    }

    public static void main(String[] args) throws IOException {
        IOIntroduce();
        FileExample();
    }
}
