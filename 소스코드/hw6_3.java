//***************************
// ���ϸ�: hw6_3.java
// �ۼ���: ��ٽ�
// �ۼ���: 10�� 11��
// ����: ���� ���� ����Ʈ
//***************************

package hw6_3;

import java.util.Scanner;
//���� ���� ���
class doublyNode {
	//���� ���� �ʵ�
	int data;
	//���� ��ũ ���� �ʵ�(Node Ÿ��)
	doublyNode llink;
	//������ ��ũ ���� �ʵ�(Node Ÿ��)
	doublyNode rlink;
	//������ 1(�Ű����� x)
	public doublyNode() {
		data = 0;
		llink = null;
		rlink = null;
	}
	//������ 2(�Ű����� ������)
	public doublyNode(int data) {
		this.data = data;
		this.llink = null;
		this.rlink = null;
	}
	//������ 3(�Ű����� ������, ��ũ��)
	public doublyNode(int data, doublyNode llink, doublyNode rlink) {
		this.data = data;
		this.llink = llink;
		this.rlink = rlink;
	}
	//������
	public int getData() {
		return this.data;
	}
}

class doublyLinkedList {
	//ù ��� ����
	private doublyNode head;
	//��� �� �ʵ�
	private int count;
	//������
	public doublyLinkedList() {
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
		doublyNode newNode = new doublyNode(data);
		//���� ���Ե� ���� 1������̹Ƿ� ���ʸ�ũ null
		newNode.llink = null;
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
			newNode.rlink = head;
			//�� ��带 1�� ���� ����
			head = newNode;
			//������ ��尡 �ƴ϶��
			if(newNode.rlink != null) {
				//2��°�� �� ��尡 1�� ��带 ����Ű�� ����
				newNode.rlink.llink = newNode;
			}
		}
	}
	
	//�߰��� ���� : ������ ���� ��ġ�� �� ����� ���������� �Ű������� �޾Ƽ� �ش� ��ġ�� ����
	public void insertMiddleNode(int index, int data) {
		//�ε��� �˻��� ���� ������ ����� ���� ��� ����
		doublyNode indexNode = searchdata(index);
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
			doublyNode newNode = new doublyNode(data);
			//�� ��尡 ����Ű�� ���� ���� ��尡 ����Ű�� �� ����
			newNode.rlink = indexNode.rlink;
			//���� ��尡 ����Ű�� ���� �� ��� ����
			indexNode.rlink = newNode;
			//�� ����� ���� ��ũ�� ���� ��� ����
			newNode.llink = indexNode;
			//���� ���Ե� ��尡������ ��尡 �ƴ϶��
			if(newNode.rlink != null) {
				//���� ��尡 ���� ���Ե� ��带 �����ϰ� ����
				newNode.rlink.llink = newNode;
			}
		}
	}
	
	//�������� ����: ������ �Ű������� �޾� ������ ��ġ�� �����Ѵ�.
	public void insertLastNode(int data) {
		//������ �� ���
		doublyNode newNode = new doublyNode(data);
		//ó�� ��尡 ���� �� ���
		if(head == null) {
			//ó�� ������ �����Ƿ� null
			newNode.llink = null;
			//��� ����
			head = newNode;
			System.out.println("ó�� ����");
		}
		
		//��� ������ 2�� �̻� ���� �� ���
		else {
			//���� ��带 �ӽ� ����
			doublyNode temp = head;
			//��尡 ����Ű�� �� ���� �� �� ����
			while(temp.rlink != null)
				//���� ��带 ����Ű�� ���� ��ũ ����
				temp = temp.rlink;
			//���� ���� ���� ������ ��� ����
			temp.rlink = newNode;
			//�������� ���Ե� ����� ������ ����
			newNode.llink = temp;
		}
	}
	
	//���� : �ε����� �Է¹޾� ����
	public void deleteindex(int index) {
		//������ �ε��� ����
		doublyNode indexNode = searchindex(index);
		//�ε��� ���� ��ȸ
		lengthList();
		//�����Ϸ��� �ε����� 1���� ���
		if(index == 0) {
			head = indexNode.rlink;
			//1���� �� ����� ���� ��帵ũ null
			indexNode.rlink.llink = null;
		}
		//�����Ϸ��� �ε����� 1���� �ƴ� ���
		else {
			//�ε����� ������ ���� �� ���
			if(getCount() <= index) {
				System.out.println("������ ������ϴ�.");
			}
			else {
				//���� ��� ����
				doublyNode preNode = indexNode.llink;
				//���� ����� ������ �����Ϸ��� ����� �������� ����
				preNode.rlink = indexNode.rlink;
				//�����Ϸ��� ��尡������ ��尡 �ƴ϶��
				if(indexNode.rlink != null) {
					//���� ��尡 ���� ��带 �����ϰ� ����
					indexNode.rlink.llink = preNode;
				}
			}
		}
	}
	
	//���� : ������ ������ ����� �� ����� ���������� �Ű������� �޾Ƽ� �ش� ��ġ�� ��� ����
	public void deletedata(int data) {
		//������ ��� ����
		doublyNode temp = searchdata(data);
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
				head = temp.rlink;
				//1���� �� ����� ���� ��帵ũ null
				temp.rlink.llink = null;
			}
			else {
				//�����Ϸ��� ����� ���� ��� ����
				doublyNode preNode = temp.llink;
				System.out.println("2�� �̻� ��� ����");
				//���� ��尡 ����Ű�� ���� �����Ϸ��� ��尡 ����Ű�� ������ ��ü
				preNode.rlink = temp.rlink;
				//�����Ϸ��� ��尡������ ��尡 �ƴ϶��
				if(temp.rlink != null) {
					//���� ��尡 ���� ��带 �����ϰ� ����
					temp.rlink.llink = preNode;
				}
			}
		}
	}
	
	//��� ��ȸ(index)
	public doublyNode searchindex(int index) {
		//1��° ��� �ӽ� ����
		doublyNode temp = head;
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
				temp = temp.rlink;
				//ī��Ʈ ����
				count++;
			}
		}
		//���� ��� ��ȯ
		return temp;
	}
	
	//��� ��ȸ(data)
	public doublyNode searchdata(int data) {
		//���� ��� �ӽ� ����
		doublyNode temp = head;
		//��尡 ���� �� ���� �˻�
		while(temp != null) {
			//�ε����� ī��Ʈ ���� ���ٸ�
			if(data == temp.getData())
				//���� ��� ��ȯ
				return temp;
			else {
				//���� ��� ������ ���� ��ũ
				temp = temp.rlink;
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
		doublyNode temp = head;
		//��尡 ����Ű�°� ���� �� ����
		while(temp != null) {
			//��ũ ����
			temp = temp.rlink;
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
		doublyNode temp = head;
		//��尡 ����Ű�°� ���� �� ����
		while(temp.rlink != null) {
			//stringBuffer ��ü�� ����
			s.append(temp.data);
			//��ũ ����
			temp = temp.rlink;
			if(temp != null)
				//������ ���� ��ǥ ����
				s.append(",");
		}
		//������ ����� ���� ���� �߰�, �迭�� �� ����� ã�� �� ����.
		s.append(temp.data + "\n���� ���\n");
		//��尡 ����Ű�°� ���� �� ����
		while(temp != null) {
			//stringBuffer ��ü�� ����
			s.append(temp.data);
			//��ũ ����
			temp = temp.llink;
			if(temp != null)
				//������ ���� ��ǥ ����
				s.append(",");
			}
		//����
		return "doublyLinkedList\n" + s;
	}
}

public class hw6_3 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//�޴� ���� ����
		System.out.println("hw6_3 : 201232016 ��ٽ�");
		int menu;
		//�Է� ���� ����
		int num;
		//�ε��� �Է� ����
		int index;
		//�޴� ���� �Է� ��ü ����
		Scanner scan = new Scanner(System.in);
		//LinkedList��ü ����
		doublyLinkedList node = new doublyLinkedList();
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
				
			System.out.println("����Ʈ ���� ���");
			//����Ʈ ���� ��� �޼ҵ�
			System.out.println(node.toString());
			}
	}