package simp.test1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		t.fileSave();

	}

//	fileSave() 메소드를 작성하시오. : public void fileSave(String fileName){}
//	- 전달받은 fileName 으로 파일 객체를 생성한다.
//	- 파일 객체와 연결하는 파일 출력스트림을 생성한다.
//	- 파일에 Book 객체를 기록할 수 있는 객체 출력스트림을 추가한다.
//	- 파일에 Book 객체 정보를 기록하고 스트림들을 닫는다.
//	- Book 객체 샘플 : "자바를 정복하자", 35000
	
	public void fileSave(String fileName) {
		File f = new File(fileName);
		try (FileOutputStream fos = new FileOutputStream(f);
			 ObjectOutputStream oos = new ObjectOutputStream
				(new BufferedOutputStream(fos));
			) {
			oos.writeObject(new Book("자바를 정복하자", 35000));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

//	+ fileSave() : void
//	=> 2번 문항의 [원인]에 기술한 Book 객체만 저장할 수 있는 ArrayList bookList 객체를 생성한다.
//	=> bookList 에 아래의 5개의 Book 객체를 리스트에 저장한다.
//	Book("자바를 잡아라", 30000));
//	Book("오라클 정복", 35000));
//	Book("웹표준 2.0", 27500));
//	Book("자바 Servlet/JSP", 28000));
//	Book("ajax 사용법", 15000));
//	=> 저장된 bookList 정보 출력 확인한다.
	
	public void fileSave() {
		ArrayList<Book> bookList = new ArrayList<>();
		bookList.add(new Book("자바를 잡아라", 30000));
		bookList.add(new Book("오라클 정복", 35000));
		bookList.add(new Book("웹표준 2.0", 27500));
		bookList.add(new Book("자바 Servlet/JSP", 28000));
		bookList.add(new Book("ajax 사용법", 15000));
		
		for(Book b : bookList) {
			System.out.println(b);
		}
	}
}
