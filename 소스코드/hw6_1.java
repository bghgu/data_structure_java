//***************************
// 파일명: hw6_1.java
// 작성자: 배다슬
// 작성일: 10월 6일
// 설명: 정수 연결 리스트
//***************************
package hw6_1;

import java.util.Scanner;

class Node {
	//정수 저장 필드
	int data;
	//링크 저장 필드(Node 타입)
	Node link;
	//생성자 1(매개변수 x)
	public Node() {
		data = 0;
		link = null;
	}
	//생성자 2(매개변수 정수값)
	public Node(int data) {
		this.data = data;
		this.link = null;
	}
	//생성자 3(매개변수 정수값, 링크값)
	public Node(int data, Node link) {
		this.data = data;
		this.link = link;
	}
	//접근자
	public int getData() {
		return this.data;
	}
}

class LinkedList {
	//첫 노드 저장
	private Node head;
	
	//생성자
	public LinkedList() {
		head = null;
	}
	//처음에 삽입: 정수를 매개변수로 받아 해당 위치에 삽입한다.
	public void insertFirstNode(int data) {
		Node newNode = new Node(data);
		
		//처음 노드가 삽입 될 경우
		if(head == null) {
			head = newNode;
			System.out.println("처음 삽입");
		}
		//노드 삽입이 2번 이상 진행 된 경우
		else {
			System.out.println("2번 이상 삽입");
			newNode.link = head;
			head = newNode;
		}
	}
	//길이조회: 리스트의 길이를 리턴
	public void lengthList() {
		//노드 카운트 필드
		int count = 1;
		//첫 노드 저장
		Node temp = head;
		//노드가 가리키는게 있을 때 까지
		while(temp != null) {
			//링크 저장
			temp = temp.link;
			if(temp != null)
				//카운트 
				count++;
		}
		
		System.out.print(count);
	}
	//내용조회: 리스트 내용을 문자열로 만들어 리턴(toString 오버라이드)
	@Override
	public String toString() {
		//노드 내용 저장을 위해 StringBuffer 클래스 사용
		StringBuffer s = new StringBuffer();
		//첫 노드 저장
		Node temp = head;
		//노드가 가리키는게 있을 때 까지
		while(temp != null) {
			//stringBuffer 객체에 저장
			s.append(temp.data);
			//링크 저장
			temp = temp.link;
			if(temp != null)
				//구분을 위해 쉼표 저장
				s.append(",");
		}
		//리턴
		return "LinkedList [" + s + "]";
	}
	
}

public class hw6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//메뉴 선택 변수
		int menu;
		//입력 정수 변수
		int num;
		//메뉴 선택 입력 객체 생성
		Scanner scan = new Scanner(System.in);
		//LinkedList객체 생성
		LinkedList node = new LinkedList();
		//반복, 무조건 처음 1번은 실행
		do{
			System.out.println("1: 처음에 삽입 2:전체출력 3:종료");
			menu = scan.nextInt();
			//메뉴 선택
			switch(menu) {
			case 1 : 
				System.out.println("삽입할 정수 입력");
				num = scan.nextInt();
				//첫 노드 추가 메소드 호출
				node.insertFirstNode(num);
				break;
			case 2 :
				//노드 내용 출력 메소드 호출
				System.out.println(node.toString());
				System.out.print("리스트 길이는 ");
				//노드 길이 출력 메소드 호출
				node.lengthList();
				System.out.println(" 입니다.");
				break;
			case 3 :
				System.out.println("종료");
				break;
			default :
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				break;
			}
		}while(menu != 3); //메뉴가 3이면 종료
		
	}

}
