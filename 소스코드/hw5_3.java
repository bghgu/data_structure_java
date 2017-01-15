//***************************
// 파일명: hw5_3.java
// 작성자: 배다슬
// 작성일: 9월 23일
// 설명: 순차 자료구조
//***************************

package hw5_3;

import java.util.Arrays;
import java.util.Scanner;
//배열 연산 클래스
class StringList {
	
	int size = 0;
	
	String array[] = new String[100];
	
	/*삽입: 인덱스와 문자열을 매개변수로 받아 
	해당 위치에 삽입한다.*/
	public void insert(int num, String word) {
		size++;
		array[num] = word;
	}
	
	/*삭제: 문자열을 매개변수로 받아 
	해당 원소를 삭제한다.(중복시 앞에 것만 삭제)*/
	public void delete(int num) {
		size--;
		array[num] = null;
	}
	
	/*조회: 인덱스를 매개변수로 받아
	해당 위치의 원소를 리턴한다.*/
	public String search(int num) {
		return array[num];
	}
	
	/*길이조회: 리스트의 길이를 리턴*/
	public int size() {
		return size;
	}
	
	/*내용조회: 리스트 내용을 문자열로 
	만들어 리턴(toString 오버라이드)*/
	@Override
	public String toString() {
		
		for(int i=0; i<100; i++)
		{
			if(array[i] != null)
				return "array=" + Arrays.toString(array);
		}
		return "값이 없습니다.";
	}
}

public class hw5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringList array = new StringList();
		
		int a;
		//입력받을 인덱스
		int num;
		int size = 0;
		//입력받을 단어
		String word;
		
		//입력값을 받기위해 scan객체 생성
		Scanner scan = new Scanner(System.in);
		
		System.out.println("hw5_3: 배다슬");
		do{
			System.out.println("1:인덱스로삽입\n2:삭제\n3:인덱스로조회\n4:전체출력\n5:종료");
			System.out.print("메뉴 선택 : ");
			a =scan.nextInt();
			//스위치문을 통한 메뉴구현
			switch(a)
			{
				case 1 : 
				{
					System.out.println("1. 인덱스로 삽입");
					System.out.print("0~99 사이의 인덱스를 입력해 주세요.");
					System.out.print("인덱스 선택 : ");
					num=scan.nextInt();
					//반복
					if(num<0 || num>99) {
						do{
							System.out.println("범위를 벗어났습니다.");
							System.out.print("0~99 사이의 인덱스를 입력해 주세요.");
							System.out.print("인덱스 선택 : ");
							num=scan.nextInt();
						}while(num<0 || num>99);
					}
					System.out.print("단어 입력 : ");
					word=scan.next();
					//메소드 호출
					array.insert(num, word);
					break;
				}
				case 2 : 
				{
					System.out.println("2. 삭제");
					System.out.print("0~99 사이의 인덱스를 입력해 주세요.");
					System.out.print("인덱스 삭제 : ");
					num=scan.nextInt();
					//반복
					if(num<0 || num>99) {
						do{
							System.out.println("범위를 벗어났습니다.");
							System.out.print("0~99 사이의 인덱스를 입력해 주세요.");
							System.out.print("인덱스 삭제 : ");
							num=scan.nextInt();
						}while(num<0 || num>99);
					}
					//메소드 호출
					array.delete(num);
					break;
				}
				case 3 : 
				{
					System.out.println("3. 인덱스로 조회");
					System.out.print("0~99 사이의 인덱스를 입력해 주세요.");
					System.out.print("인덱스 선택 : ");
					num=scan.nextInt();
					//반복
					if(num<0 || num>99) {
						do{
							System.out.println("범위를 벗어났습니다.");
							System.out.print("0~99 사이의 인덱스를 입력해 주세요.");
							System.out.print("인덱스 선택 : ");
							num=scan.nextInt();
						}while(num<0 || num>99);
					}
					System.out.println(array.search(num));
					break;
				}
				case 4 : 
				{
					System.out.println("4. 전체 출력");
					System.out.println(array.toString());
					System.out.println("사이즈 : " + array.size());
					break;
				}
			}
			
		}while(a != 5);
		System.out.println("종료");
	}

}
