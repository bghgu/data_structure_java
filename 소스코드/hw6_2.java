//***************************
// 파일명: hw6_2.java
// 작성자: 배다슬
// 작성일: 10월 7일
// 설명: 정수 연결 리스트
//***************************

package hw6_2;

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
	//노드 수 필드
	private int count;
	//생성자
	public LinkedList() {
		head = null;
	}
	//노드 수 접근자
	public int getCount() {
		return count;
	}
	//노드 수 설정자
	public void setCount(int count) {
		this.count = count;
	}

	//처음에 삽입: 정수를 매개변수로 받아 해당 위치에 삽입한다.
	public void insertFirstNode(int data) {
		//삽입할 새 노드
		Node newNode = new Node(data);
		
		//처음 노드가 삽입 될 경우
		if(head == null) {
			//1번 노드 지정
			head = newNode;
			System.out.println("처음 삽입");
		}
		//노드 삽입이 2번 이상 진행 된 경우
		else {
			System.out.println("2번 이상 삽입");
			//새 노드가 가리키는 값으로 현재 1번 노드 지정
			newNode.link = head;
			//새 노드를 1번 노드로 지정
			head = newNode;
		}
	}
	
	//중간에 삽입 : 정수와 넣을 위치의 전 노드의 참조변수를 매개변수로 받아서 해당 위치에 삽입
	public void insertMiddleNode(int index, int data) {
		//인덱스 검색을 통해 삽입할 노드의 이전 노드 저장
		Node indexNode = searchdata(index);
		//노드값이 없을 경우
		if (indexNode == null) {
			System.out.println(index + " 의 위치를 찾을 수 없습니다.");
			System.out.println("첫 위치에 값을 입력합니다.");
			//1번 노드 지정 메소드 호출
			insertFirstNode(data);
		}
		//노드값이 존재 할 경우
		else {
			//새로 입력할 노드 생성
			Node newNode = new Node(data);
			//새 노드가 가리키는 곳에 이전 노드가 가리키는 값 삽입
			newNode.link = indexNode.link;
			//이전 노드가 가리키는 곳에 새 노드 지정
			indexNode.link = newNode;
		}
	}
	
	//마지막에 삽입: 정수를 매개변수로 받아 마지막 위치에 삽입한다.
	public void insertLastNode(int data) {
		//삽입할 새 노드
		Node newNode = new Node(data);
		
		//처음 노드가 삽입 될 경우
		if(head == null) {
			//노드 삽입
			head = newNode;
			System.out.println("처음 삽입");
		}
		
		//노드 삽입이 2번 이상 진행 된 경우
		else {
			//현재 노드를 임시 저장
			Node temp = head;
			//노드가 가리키는 게 존재 할 때 까지
			while(temp.link != null)
				//다음 노드를 가리키기 위해 링크 지정
				temp = temp.link;
			//다음 노드로 새로 생성된 노드 지정
			temp.link = newNode;	
		}
	}
	
	//삭제 : 인덱스를 입력받아 삭제
	public void deleteindex(int index) {
		//삭제할 인덱스 저장
		Node indexNode = searchindex(index);
		//인덱스 범위 조회
		lengthList();
		//삭제하려는 인덱스가 1번일 경우
		if(index == 0) {
			head = indexNode.link;
		}
		//삭제하려는 인덱스가 1번이 아닐 경우
		else {
			//인덱스가 범위를 벗어 날 경우
			if(getCount() <= index) {
				System.out.println("범위를 벗어났습니다.");
			}
			else {
				Node preNode = searchPreNode(indexNode);
				preNode.link = indexNode.link;
			}
		}
	}
	
	//삭제 : 정수와 삭제할 노드의 전 노드의 참조변수를 매개변수로 받아서 해당 위치의 노드 삭제
	public void deletedata(int data) {
		//삭제할 노드 저장
		Node temp = searchdata(data);
		//노드가 없을 경우
		if(temp == null) {
			System.out.println("노드를 찾을 수 없습니다.");
		}
		//노드가 있을 경우
		else {
			System.out.println("노드를 찾았습니다.");
			//삭제하려는 노드가 1번 노드일 경우
			if(temp == head) {
				System.out.println("1번 노드 삭제");
				//1번이 가리키는 값을 1번으로 지정
				head = temp.link;
			}
			else {
				//삭제하려는 노드의 이전 노드 저장
				Node preNode = searchPreNode(temp);
				System.out.println("2번 이상 노드 삭제");
				//이전 노드가 가리키는 값을 삭제하려는 노드가 가리키는 값으로 대체
				preNode.link = temp.link;
			}
		}
	}
	
	//노드 조회(index)
	public Node searchindex(int index) {
		//1번째 노드 임시 저장
		Node temp = head;
		//몇번 째 노드인지 카운트 하기 위한 변수
		int count = 0;
		//노드가 없을 때 까지 검색
		while(temp != null) {
			//인덱스가 카운트 수와 같다면
			if(index == count)
				//현재 노드 반환
				return temp;
			else {
				//다음 노드 진행을 위해 링크
				temp = temp.link;
				//카운트 증가
				count++;
			}
		}
		//현재 노드 반환
		return temp;
	}
	
	//이전 노드를 찾아서 반환
	public Node searchPreNode(Node node) {
		//1번 노드 저장
		Node temp = head;
		//노드가 가리키는 갑이 있을 때 까지
		while (temp.link != null) {
			//노드의 다음을 지정하는게 찾으려는 노드와 같을 경우
			if (temp.link == node)
				return temp;
			//다음 진행
			else
				temp = temp.link;
		}
		//노드 반환
		return temp;
	}
	
	//노드 조회(data)
	public Node searchdata(int data) {
		//현재 노드 임시 저장
		Node temp = head;
		//노드가 없을 때 까지 검색
		while(temp != null) {
			//인덱스가 카운트 수와 같다면
			if(data == temp.getData())
				//현재 노드 반환
				return temp;
			else {
				//다음 노드 진행을 위해 링크
				temp = temp.link;
			}
		}
		//현재 노드 반환
		return temp;
	}
	
	//길이조회: 리스트의 길이를 리턴
	public void lengthList() {
		//노드 카운트 필드 초기화
		setCount(1);
		int c = 1;
		//첫 노드 저장
		Node temp = head;
		//노드가 가리키는게 있을 때 까지
		while(temp != null) {
			//링크 저장
			temp = temp.link;
			if(temp != null)
				//카운트 
				c++;
		}
		setCount(c);
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

public class hw6_2 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//메뉴 선택 변수
				int menu;
				//입력 정수 변수
				int num;
				//인덱스 입력 변수
				int index;
				//메뉴 선택 입력 객체 생성
				Scanner scan = new Scanner(System.in);
				//LinkedList객체 생성
				LinkedList node = new LinkedList();
				//반복, 무조건 처음 1번은 실행
				do{
					System.out.println("1: 인덱스로 삽입 2: 인덱스로 삭제 3: 값을 받아서 삭제 4:전체출력 5:종료");
					menu = scan.nextInt();
					//메뉴 선택
					switch(menu) {
					case 1 : 
						//1 선택시 사용자로부터 인덱스와 정수를 입력받아 삽입  
						do{
							System.out.println("인덱스 입력");
							System.out.println("범위는 0부터 시작");
							index = scan.nextInt();
						}while(index<0);
						System.out.println("삽입할 정수 입력");
						num = scan.nextInt();
						//노드 추가 메소드 호출
						//만약 첫 위치에 값을 넣기를 원할 경우
						if(index == 0)
							node.insertFirstNode(num);
						//첫 위치에 값을 넣기를 원치 않을 경우
						else
							node.insertMiddleNode(index, num);
						break;
					case 2 :
						//2 선택시 사용자로부터 인덱스를 받아서 삭제
						do{
							System.out.println("인덱스 입력");
							System.out.println("범위는 0부터 시작");
							index = scan.nextInt();
						}while(index<0);
						//노드 추가 메소드 호출
						node.deleteindex(index);
						break;
					case 3 :
						//3 선택시 사용자로부터 정수를 입력받아 삭제(중복시 앞에 것만 삭제) 
						System.out.println("삭제할 정수 입력");
						num = scan.nextInt();
						//노드 추가 메소드 호출
						node.deletedata(num);
						break;
					case 4 :
						//노드 내용 출력 메소드 호출
						System.out.println(node.toString());
						node.lengthList();
						System.out.println("리스트 길이는 " + node.getCount() + " 입니다.");
						break;
					case 5 :
						System.out.println("종료");
						break;
					default :
						System.out.println("메뉴를 잘못 입력하셨습니다.");
						break;
					}
				}while(menu != 5); //메뉴가 3이면 종료
			}
	}