//***************************
// ���ϸ�: main.java
// �ۼ���: ��ٽ�
// �ۼ���: 11�� 22��
// ���α׷� ����:����Ž��Ʈ��
//***************************

package hw9_1;

import java.util.Scanner;

class TreeNode {
	//Ű��
	int key;
	//�󵵼�
	int freq;
	//���� Ʈ��
	TreeNode left;
	//������ Ʈ��
	TreeNode right;
	//��� ������
	public TreeNode(int data) {
		this.key = data;
		this.freq = 1;
		left = right = null;
	}
}

class IntegerBinarySearchTree {
	
	private TreeNode root = null;
	
	public void add (int data) {
		//���� ��� ���� �� ����
		TreeNode p = root;
		TreeNode q = null;
		//���� �����Ϸ��� ��� ����
		TreeNode newNode = new TreeNode(data);
		while(p != null) {
			//�����Ϸ��� ������ Ʈ���� ����
			if(data == p.key) {
				//������ �󵵼��� ���. (Ű��:�󵵼�)
				System.out.println(p.key + ":" + ++p.freq);
				return ;
			}
			q = p;
			if(data < p.key) {
				p = p.left;
			}
			else p = p.right;
		}
		if(root == null) {
			root = newNode;
		}
		//���԰��� ���� ���
		else if(data < q.key) {
			//���ʿ� ��� ����
			q.left = newNode;
		}
		//�����ʿ� ��� ����
		else q.right = newNode;
		System.out.println(newNode.key + ":" + newNode.freq);
	}
	
	// ���� ��ȸ�� ���� ���� �޼ҵ�
	public void inorder() {
		//���� ����
		inorder(root);
	}
	// ���� ��ȸ �޼ҵ�
	private void inorder(TreeNode root) { 
		if (root != null) {
			//���� Ž��
			inorder(root.left);
			System.out.println(root.key + ":" + root.freq);
			//������ Ž��
			inorder(root.right);
		}
	}
}

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu;
		int data;
		Scanner scan = new Scanner(System.in);
		IntegerBinarySearchTree bst = new IntegerBinarySearchTree();
		System.out.println("hw9_1 : 201232016 ��ٽ�");
		do{
			System.out.println("1:Ʈ���� ���� 2:Ʈ������ ���� 3:Ʈ������ �˻� 4:������ȸ 5:����");
			menu = scan.nextInt();
			switch(menu) {
			case 1 : 
				System.out.println("1:Ʈ���� ����");
				System.out.print("������ ������ �Է�: ");
				data = scan.nextInt();
				bst.add(data);
				break;
			case 2 :
				System.out.println("2:Ʈ������ ����");
				break;
			case 3 :
				System.out.println("3:Ʈ������ �˻�");
				break;
			case 4 :
				System.out.println("4:������ȸ");
				bst.inorder();
				break;
			default :
				System.out.println("����");
				break; 
			}
		}while(menu != 5);
	}
}
