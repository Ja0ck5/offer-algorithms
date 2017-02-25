package com.lyj.algorithms.copyFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileTest {

	private static final String FILE_PATH_OUT = "";
	private static final String FILE_PATH = "";

	public static void commonIoStream() throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(new File(FILE_PATH));
			fos = new FileOutputStream(new File(FILE_PATH_OUT));
			
			int len = 0;
			while((len = fis.read()) != -1){
				fos.write(len);
			}
			
		} finally {
			if (null != fis)
				fis.close();
			if (null != fos)
				fos.close();
		}
		
	}
	
	public static void transByCommonIoBufferedStream1() throws Exception {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(new File(FILE_PATH)));
			bos = new BufferedOutputStream(new FileOutputStream(new File(FILE_PATH_OUT)));

			byte[] b = new byte[1024];
			int len = 0;
			while ((len = bis.read(b)) != -1)
				bos.write(b, 0, len);
			bos.flush();
		} finally {
			if (null != bis)
				bis.close();
			if (null != bos)
				bos.close();
		}

	}

	public static void transByCommonIoBuffered() throws Exception {

		Reader br = null;
		Writer bw = null;
		try {
			br = new BufferedReader(new FileReader(new File(FILE_PATH)));
			bw = new BufferedWriter(new FileWriter(new File(FILE_PATH_OUT)));

			char[] c = new char[1024];
			int len = 0;
			while ((len = br.read(c)) != -1)
				bw.write(c, 0, len);
			bw.flush();
		
		} finally {
			if (null != br)
				br.close();
			if (null != bw)
				bw.close();
		}

	}

	public static void transByRandomAccFile() throws Exception {

		FileInputStream fis = null;
		RandomAccessFile raf = null;
		try {
			fis = new FileInputStream(new File(FILE_PATH));
			raf = new RandomAccessFile(new File(FILE_PATH_OUT), "rw");

			byte[] b = new byte[1024];
			int len = 0;
			while ((len = fis.read(b)) != -1)
				raf.write(b, 0, len);
		} finally {
			if (null != raf)
				raf.close();
			if (null != fis)
				fis.close();
		}

	}

	public static void transByNioTransferFrom() throws Exception {

		FileInputStream fis = null;
		RandomAccessFile raf = null;

		try {
			fis = new FileInputStream(new File(FILE_PATH));
			raf = new RandomAccessFile(new File(FILE_PATH_OUT), "rw");
			FileChannel fc = fis.getChannel();
			FileChannel fco = raf.getChannel();
			fco.transferFrom(fc, 0, fc.size());

		} finally {
			if (null != raf)
				raf.close();
			if (null != fis)
				fis.close();
		}

	}

	public static void transByCommonNio() throws Exception {

		FileInputStream fis = null;
		RandomAccessFile raf = null;
		try {
			fis = new FileInputStream(new File(FILE_PATH));
			raf = new RandomAccessFile(new File(FILE_PATH_OUT), "rw");

			FileChannel fc = fis.getChannel();

			FileChannel fco = raf.getChannel();

			ByteBuffer buf = ByteBuffer.allocate(1024);

			while (fc.read(buf) != -1) {
				// 缓冲区翻转用于输出到fco
				buf.flip();
				fco.write(buf);
				//清空缓冲区用于下次读取
				buf.clear();
			}
		} finally {
			if (null != raf)
				raf.close();
			if (null != fis)
				fis.close();
		}

	}

	public static void deleteFile() {
		File f = new File(FILE_PATH_OUT);
		if (f.exists())
			f.delete();
	}

}
