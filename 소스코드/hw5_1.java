//***************************
// 파일명: hw5_1.java
// 작성자: 배다슬
// 작성일: 9월 22일
// 설명:...
//***************************

package hw5_1;

import java.util.Scanner;

public class hw5_1 {

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
		
		System.out.println("초기 리스트");
		System.out.println("길이 = " + size);
		System.out.print("내용 = ");
		for(int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}
		//출력이 보기 좋게 하기 위한 개행
		System.out.println("");
		
		System.out.println("새로운 값을 삽입합니다.");
		System.out.print("삽입할 정수값 입력 : ");
		num = scan.nextInt();
		
		//값 리스트 삽입
		for(int i=0; i<11; i++)
		{
			if(array[i] < num)
			{	
				//새로 입력한 값이 들어가야 할 위치 저장
				x++;
			}
		}
		//배열의 길이 1증가
		size++;
		
		//맨 마지막 배열 값부터 이동 시작
		//값을 입력해야 할 곳 다음번 까지 연산
		for (int i=size; x<i; i--)
		{
			array[i] = array[i-1];
	    }
		
		//마지막으로 값을 입력
		array[x]=num;

		System.out.print("삽입 후 리스트");
		System.out.println("길이 = " + size);
		System.out.print("내용 = ");
		for(int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}
		
	}

}
