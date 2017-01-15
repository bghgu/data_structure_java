//***************************
// 파일명: hw5_2.java
// 작성자: 배다슬
// 작성일: 9월 23일
// 설명: 순차 자료구조
//***************************

package hw5_2;

import java.util.Scanner;

public class hw5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//배열 크키 100 생성
		int[] array = new int[100];
		
		//입력값 변수
		int num;
		
		//배열의 길이를 구하기 위한 변수
		int size = 0;
		
		//새로 입력한 값의 위치를 구하기 위한 변수
		int x = -1;
		
		//입력값을 받기위해 scan객체 생성
		Scanner scan = new Scanner(System.in);
		
		//초기 리스트 값 할당
		for(int i=0; i<10; i++)
		{
			//배열 값 할당
			array[i] = i*11;
			//배열의 크기 값 계산
			size++;
		}
		System.out.println("hw5_2: 배다슬");
		System.out.println("초기 리스트");
		System.out.println("길이 = " + size);
		System.out.print("내용 = ");
		for(int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}
		//출력이 보기 좋게 하기 위한 개행
		System.out.println("");
		System.out.println("값을 삭제합니다.");
		
		//정확한 범위의 값이 입력 되도록 반복
		do{
			System.out.println("정확한 범위의 값을 입력해 주세요.");
			System.out.print("삭제할 인덱스 입력(0~9): ");
			num = scan.nextInt();
		}while(num<0 || num>9);
		
		//값을 앞으로 한칸씩 땡기기
		for (int i=num; size>i; i++)
		{
			array[i] = array[i+1];
	    }
		
		//배열의 길이 1감소
		size--;
		
		System.out.print("삭제 후 리스트");
		System.out.println("길이 = " + size);
		System.out.print("내용 = ");
		for(int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}	
	}

}
