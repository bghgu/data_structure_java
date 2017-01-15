//***************************
// ���ϸ�: hw6_1.java
// �ۼ���: ��ٽ�
// �ۼ���: 10�� 6��
// ����: ���� ���� ����Ʈ
//***************************
package hw6_1;

import java.util.Scanner;

class Node {
	//���� ���� �ʵ�
	int data;
	//��ũ ���� �ʵ�(Node Ÿ��)
	Node link;
	//������ 1(�Ű����� x)
	public Node() {
		data = 0;
		link = null;
	}
	//������ 2(�Ű����� ������)
	public Node(int data) {
		this.data = data;
		this.link = null;
	}
	//������ 3(�Ű����� ������, ��ũ��)
	public Node(int data, Node link) {
		this.data = data;
		this.link = link;
	}
	//������
	public int getData() {
		return this.data;
	}
}

class LinkedList {
	//ù ��� ����
	private Node head;
	
	//������
	public LinkedList() {
		head = null;
	}
	//ó���� ����: ������ �Ű������� �޾� �ش� ��ġ�� �����Ѵ�.
	public void insertFirstNode(int data) {
		Node newNode = new Node(data);
		
		//ó�� ��尡 ���� �� ���
		if(head == null) {
			head = newNode;
			System.out.println("ó�� ����");
		}
		//��� ������ 2�� �̻� ���� �� ���
		else {
			System.out.println("2�� �̻� ����");
			newNode.link = head;
			head = newNode;
		}
	}
	//������ȸ: ����Ʈ�� ���̸� ����
	public void lengthList() {
		//��� ī��Ʈ �ʵ�
		int count = 1;
		//ù ��� ����
		Node temp = head;
		//��尡 ����Ű�°� ���� �� ����
		while(temp != null) {
			//��ũ ����
			temp = temp.link;
			if(temp != null)
				//ī��Ʈ 
				count++;
		}
		
		System.out.print(count);
	}
	//������ȸ: ����Ʈ ������ ���ڿ��� ����� ����(toString �������̵�)
	@Override
	public String toString() {
		//��� ���� ������ ���� StringBuffer Ŭ���� ���
		StringBuffer s = new StringBuffer();
		//ù ��� ����
		Node temp = head;
		//��尡 ����Ű�°� ���� �� ����
		while(temp != null) {
			//stringBuffer ��ü�� ����
			s.append(temp.data);
			//��ũ ����
			temp = temp.link;
			if(temp != null)
				//������ ���� ��ǥ ����
				s.append(",");
		}
		//����
		return "LinkedList [" + s + "]";
	}
	
}

public class hw6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�޴� ���� ����
		int menu;
		//�Է� ���� ����
		int num;
		//�޴� ���� �Է� ��ü ����
		Scanner scan = new Scanner(System.in);
		//LinkedList��ü ����
		LinkedList node = new LinkedList();
		//�ݺ�, ������ ó�� 1���� ����
		do{
			System.out.println("1: ó���� ���� 2:��ü��� 3:����");
			menu = scan.nextInt();
			//�޴� ����
			switch(menu) {
			case 1 : 
				System.out.println("������ ���� �Է�");
				num = scan.nextInt();
				//ù ��� �߰� �޼ҵ� ȣ��
				node.insertFirstNode(num);
				break;
			case 2 :
				//��� ���� ��� �޼ҵ� ȣ��
				System.out.println(node.toString());
				System.out.print("����Ʈ ���̴� ");
				//��� ���� ��� �޼ҵ� ȣ��
				node.lengthList();
				System.out.println(" �Դϴ�.");
				break;
			case 3 :
				System.out.println("����");
				break;
			default :
				System.out.println("�޴��� �߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}while(menu != 3); //�޴��� 3�̸� ����
		
	}

}
