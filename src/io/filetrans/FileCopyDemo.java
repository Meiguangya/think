package io.filetrans;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

interface FileCopyRunner {
    void copyFile(File source, File target);
}

public class FileCopyDemo {

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        //copyByNIOTransfer();

        copyByNioBuffer();

        //copyByBuffer();
    }

    //使用NIO的transfer 复制
    public static void copyByNIOTransfer(){
        FileCopyRunner fileCopyRunner = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                FileChannel fio = null;
                FileChannel fout = null;
                try {
                    fio = new FileInputStream(source).getChannel();
                    fout = new FileOutputStream(target).getChannel();
                    long transferred = 0L;
                    long size = fio.size();
                    while(transferred!=size){
                        transferred+=fio.transferTo(0,fio.size(),fout);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fio);
                    close(fout);
                }
            }
        };

        long start = System.currentTimeMillis();
        fileCopyRunner.copyFile(new File("/Users/meiguangya/Desktop/jdkapi1.8.CHM"),
                new File("/Users/meiguangya/Desktop/copy_1_jdkapi1.8.CHM"));
        long end = System.currentTimeMillis();
        System.out.println("niotransfer 完成 用时" + (end - start));
    }


    public static void copyByNioBuffer(){
        FileCopyRunner fileCopyRunner = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                FileChannel fio = null;
                FileChannel fout = null;
                try {
                    fio = new FileInputStream(source).getChannel();
                    fout = new FileOutputStream(target).getChannel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while(fio.read(buffer)!= -1){
                        buffer.flip(); //将写入buff变成从buff中读
                        while(buffer.hasRemaining()){
                            //channel对buff中的数据进行读，然后把读出来的数据写出到外面
                            fout.write(buffer);
                        }
                        buffer.clear();//将对buff读操作变成对buff进行写操作
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        long start = System.currentTimeMillis();
        fileCopyRunner.copyFile(new File("/Users/meiguangya/Desktop/jdkapi1.8.CHM"),
                new File("/Users/meiguangya/Desktop/copy_1_jdkapi1.8.CHM"));
        long end = System.currentTimeMillis();
        System.out.println("niotransfer 完成 用时" + (end - start));
    }


    //2.使用缓冲读
    public static void copyByBuffer() {
        FileCopyRunner bufferRunner = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                BufferedInputStream in = null;
                BufferedOutputStream out = null;

                try {
                    in = new BufferedInputStream(new FileInputStream(source));
                    out = new BufferedOutputStream(new FileOutputStream(target));

                    byte[] bytes = new byte[1024];
                    int res = 0;
                    while (true) {
                        res = in.read(bytes);
                        if (res == -1) {
                            break;
                        }
                        out.write(bytes, 0, res);
                        out.flush();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(in);
                    close(out);
                }
            }
        };

        long start = System.currentTimeMillis();
        bufferRunner.copyFile(new File("/Users/meiguangya/Desktop/fastdfs.txt"),
                new File("/Users/meiguangya/Desktop/copy_5_fastdfs.txt"));
        long end = System.currentTimeMillis();
        System.out.println("noBufferStreamCopy 完成 用时" + (end - start));
    }


    //1.一个字节一个字节的读
    public void copyByByte() {
        FileCopyRunner noBufferStreamCopy;
        noBufferStreamCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                FileInputStream fin = null;
                FileOutputStream fout = null;
                try {
                    fin = new FileInputStream(source);
                    fout = new FileOutputStream(target);
                    int res;
                    while ((res = fin.read()) != -1) {
                        fout.write(res);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fin);
                    close(fout);
                }
            }
        };

        long start = System.currentTimeMillis();
        noBufferStreamCopy.copyFile(new File("/Users/meiguangya/Desktop/fastdfs.txt"),
                new File("/Users/meiguangya/Desktop/copy_1_fastdfs.txt"));
        long end = System.currentTimeMillis();
        System.out.println("noBufferStreamCopy 完成 用时" + (end - start));
    }

}
