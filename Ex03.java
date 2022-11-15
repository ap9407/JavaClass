package day02;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex03 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		String path = "https://search.pstatic.net/common/?src=http%3A%2F%2Fimage.nmv.naver.net%2Fblog_2022_02_18_801%2Fa2077cb1-906c-11ec-92eb-48df379cca40_01.jpg&type=sc960_832";
				
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		
		try { 
			bis = new BufferedInputStream(new URL(path).openStream());
			fos = new FileOutputStream(new File("my.jpg"));
			
			byte[] buffer = new byte[1024]; // 버퍼, 1바이트씩 처리하면 함수호출이 너무 많다.
			int count, total = 0;			// 일정한 크기만큼 데이터를 모아서 한번에 처리한다.
			
			while((count = bis.read(buffer, 0, 1024)) != -1) {
				total += count;
				System.out.println(total);
				fos.write(buffer, 0, count);
			}
			
		} finally {
			bis.close();
			fos.close();
		}
		System.out.println("끝");
	}

}
