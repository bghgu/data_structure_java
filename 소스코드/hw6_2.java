//***************************
// ���ϸ�: hw6_2.java
// �ۼ���: ��ٽ�
// �ۼ���: 10�� 7��
// ����: ���� ���� ����Ʈ
//***************************

package hw6_2;

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
	//��� �� �ʵ�
	private int count;
	//������
	public LinkedList() {
		head = null;
	}
	//��� �� ������
	public int getCount() {
		return count;
	}
	//��� �� ������
	public void setCount(int count) {
		this.count = count;
	}

	//ó���� ����: ������ �Ű������� �޾� �ش� ��ġ�� �����Ѵ�.
	public void insertFirstNode(int data) {
		//������ �� ���
		Node newNode = new Node(data);
		
		//ó�� ��尡 ���� �� ���
		if(head == null) {
			//1�� ��� ����
			head = newNode;
			System.out.println("ó�� ����");
		}
		//��� ������ 2�� �̻� ���� �� ���
		else {
			System.out.println("2�� �̻� ����");
			//�� ��尡 ����Ű�� ������ ���� 1�� ��� ����
			newNode.link = head;
			//�� ��带 1�� ���� ����
			head = newNode;
		}
	}
	
	//�߰��� ���� : ������ ���� ��ġ�� �� ����� ���������� �Ű������� �޾Ƽ� �ش� ��ġ�� ����
	public void insertMiddleNode(int index, int data) {
		//�ε��� �˻��� ���� ������ ����� ���� ��� ����
		Node indexNode = searchdata(index);
		//��尪�� ���� ���
		if (indexNode == null) {
			System.out.println(index + " �� ��ġ�� ã�� �� �����ϴ�.");
			System.out.println("ù ��ġ�� ���� �Է��մϴ�.");
			//1�� ��� ���� �޼ҵ� ȣ��
			insertFirstNode(data);
		}
		//��尪�� ���� �� ���
		else {
			//���� �Է��� ��� ����
			Node newNode = new Node(data);
			//�� ��尡 ����Ű�� ���� ���� ��尡 ����Ű�� �� ����
			newNode.link = indexNode.link;
			//���� ��尡 ����Ű�� ���� �� ��� ����
			indexNode.link = newNode;
		}
	}
	
	//�������� ����: ������ �Ű������� �޾� ������ ��ġ�� �����Ѵ�.
	public void insertLastNode(int data) {
		//������ �� ���
		Node newNode = new Node(data);
		
		//ó�� ��尡 ���� �� ���
		if(head == null) {
			//��� ����
			head = newNode;
			System.out.println("ó�� ����");
		}
		
		//��� ������ 2�� �̻� ���� �� ���
		else {
			//���� ��带 �ӽ� ����
			Node temp = head;
			//��尡 ����Ű�� �� ���� �� �� ����
			while(temp.link != null)
				//���� ��带 ����Ű�� ���� ��ũ ����
				temp = temp.link;
			//���� ���� ���� ������ ��� ����
			temp.link = newNode;	
		}
	}
	
	//���� : �ε����� �Է¹޾� ����
	public void deleteindex(int index) {
		//������ �ε��� ����
		Node indexNode = searchindex(index);
		//�ε��� ���� ��ȸ
		lengthList();
		//�����Ϸ��� �ε����� 1���� ���
		if(index == 0) {
			head = indexNode.link;
		}
		//�����Ϸ��� �ε����� 1���� �ƴ� ���
		else {
			//�ε����� ������ ���� �� ���
			if(getCount() <= index) {
				System.out.println("������ ������ϴ�.");
			}
			else {
				Node preNode = searchPreNode(indexNode);
				preNode.link = indexNode.link;
			}
		}
	}
	
	//���� : ������ ������ ����� �� ����� ���������� �Ű������� �޾Ƽ� �ش� ��ġ�� ��� ����
	public void deletedata(int data) {
		//������ ��� ����
		Node temp = searchdata(data);
		//��尡 ���� ���
		if(temp == null) {
			System.out.println("��带 ã�� �� �����ϴ�.");
		}
		//��尡 ���� ���
		else {
			System.out.println("��带 ã�ҽ��ϴ�.");
			//�����Ϸ��� ��尡 1�� ����� ���
			if(temp == head) {
				System.out.println("1�� ��� ����");
				//1���� ����Ű�� ���� 1������ ����
				head = temp.link;
			}
			else {
				//�����Ϸ��� ����� ���� ��� ����
				Node preNode = searchPreNode(temp);
				System.out.println("2�� �̻� ��� ����");
				//���� ��尡 ����Ű�� ���� �����Ϸ��� ��尡 ����Ű�� ������ ��ü
				preNode.link = temp.link;
			}
		}
	}
	
	//��� ��ȸ(index)
	public Node searchindex(int index) {
		//1��° ��� �ӽ� ����
		Node temp = head;
		//��� ° ������� ī��Ʈ �ϱ� ���� ����
		int count = 0;
		//��尡 ���� �� ���� �˻�
		while(temp != null) {
			//�ε����� ī��Ʈ ���� ���ٸ�
			if(index == count)
				//���� ��� ��ȯ
				return temp;
			else {
				//���� ��� ������ ���� ��ũ
				temp = temp.link;
				//ī��Ʈ ����
				count++;
			}
		}
		//���� ��� ��ȯ
		return temp;
	}
	
	//���� ��带 ã�Ƽ� ��ȯ
	public Node searchPreNode(Node node) {
		//1�� ��� ����
		Node temp = head;
		//��尡 ����Ű�� ���� ���� �� ����
		while (temp.link != null) {
			//����� ������ �����ϴ°� ã������ ���� ���� ���
			if (temp.link == node)
				return temp;
			//���� ����
			else
				temp = temp.link;
		}
		//��� ��ȯ
		return temp;
	}
	
	//��� ��ȸ(data)
	public Node searchdata(int data) {
		//���� ��� �ӽ� ����
		Node temp = head;
		//��尡 ���� �� ���� �˻�
		while(temp != null) {
			//�ε����� ī��Ʈ ���� ���ٸ�
			if(data == temp.getData())
				//���� ��� ��ȯ
				return temp;
			else {
				//���� ��� ������ ���� ��ũ
				temp = temp.link;
			}
		}
		//���� ��� ��ȯ
		return temp;
	}
	
	//������ȸ: ����Ʈ�� ���̸� ����
	public void lengthList() {
		//��� ī��Ʈ �ʵ� �ʱ�ȭ
		setCount(1);
		int c = 1;
		//ù ��� ����
		Node temp = head;
		//��尡 ����Ű�°� ���� �� ����
		while(temp != null) {
			//��ũ ����
			temp = temp.link;
			if(temp != null)
				//ī��Ʈ 
				c++;
		}
		setCount(c);
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

public class hw6_2 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//�޴� ���� ����
				int menu;
				//�Է� ���� ����
				int num;
				//�ε��� �Է� ����
				int index;
				//�޴� ���� �Է� ��ü ����
				Scanner scan = new Scanner(System.in);
				//LinkedList��ü ����
				LinkedList node = new LinkedList();
				//�ݺ�, ������ ó�� 1���� ����
				do{
					System.out.println("1: �ε����� ���� 2: �ε����� ���� 3: ���� �޾Ƽ� ���� 4:��ü��� 5:����");
					menu = scan.nextInt();
					//�޴� ����
					switch(menu) {
					case 1 : 
						//1 ���ý� ����ڷκ��� �ε����� ������ �Է¹޾� ����  
						do{
							System.out.println("�ε��� �Է�");
							System.out.println("������ 0���� ����");
							index = scan.nextInt();
						}while(index<0);
						System.out.println("������ ���� �Է�");
						num = scan.nextInt();
						//��� �߰� �޼ҵ� ȣ��
						//���� ù ��ġ�� ���� �ֱ⸦ ���� ���
						if(index == 0)
							node.insertFirstNode(num);
						//ù ��ġ�� ���� �ֱ⸦ ��ġ ���� ���
						else
							node.insertMiddleNode(index, num);
						break;
					case 2 :
						//2 ���ý� ����ڷκ��� �ε����� �޾Ƽ� ����
						do{
							System.out.println("�ε��� �Է�");
							System.out.println("������ 0���� ����");
							index = scan.nextInt();
						}while(index<0);
						//��� �߰� �޼ҵ� ȣ��
						node.deleteindex(index);
						break;
					case 3 :
						//3 ���ý� ����ڷκ��� ������ �Է¹޾� ����(�ߺ��� �տ� �͸� ����) 
						System.out.println("������ ���� �Է�");
						num = scan.nextInt();
						//��� �߰� �޼ҵ� ȣ��
						node.deletedata(num);
						break;
					case 4 :
						//��� ���� ��� �޼ҵ� ȣ��
						System.out.println(node.toString());
						node.lengthList();
						System.out.println("����Ʈ ���̴� " + node.getCount() + " �Դϴ�.");
						break;
					case 5 :
						System.out.println("����");
						break;
					default :
						System.out.println("�޴��� �߸� �Է��ϼ̽��ϴ�.");
						break;
					}
				}while(menu != 5); //�޴��� 3�̸� ����
			}
	}