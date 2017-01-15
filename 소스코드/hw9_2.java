//***************************
// ���ϸ�: main.java
// �ۼ���: ��ٽ�
// �ۼ���: 11�� 23��
// ���α׷� ����:����Ž��Ʈ�� ����
//***************************

package hw9_2;

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
			else
				p = p.right;
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
	
	public void remove(int data) {
		
		TreeNode p = searchNode(data);
		TreeNode parent = searchParentNode(data);

		if (p == null) {
			System.out.println("���� ����!");
		}
		
		//���1, ���� ��尡 �ܸ������ ���
		else if(p.left == null && p.right == null) {
			if(parent == null) {
				System.out.println("1");
				root = null;
				return;
			}
			else if (parent.left == p) {
				System.out.println("2");
				parent.left = null;
			}
			else {
				System.out.println("3");
				parent.right = null;
			}
		}
		
		//���2, ���� ��尡 �ϳ��� �ڽĳ�带 ���� ���
		else if (p.left == null || p.right == null) {
			if(p.left != null) {
				if (parent == null) {
					root = p.left;
				}
				else if (parent.left == p) {
					parent.left = p.left;
				}
				else {
					parent.right = p.left;
				}
			}
			else {
				if (parent == null) {
					root = p.right;
				}
				else if (parent.left == p) {
					parent.left =  p.right;
				}
				else parent.right = p.right;
			}
		}
		
		//���3, ���� ��尡 �ΰ��� �ڽĳ�带 ���� ���
		else {
		TreeNode q = minNode(p.right);
		remove(q.key);
		p.key = q.key;
		}
	}
	
	private TreeNode minNode(TreeNode root) {
		TreeNode p = root;
		while (p.left != null)
			p = p.left;
		return p;
	}
	
	private TreeNode searchNode(int data) {
		TreeNode p = root;
		while(p != null) {
			if(data < p.key) 
				p = p.left;
			else if (data > p.key) 
				p = p.right;
			else 
				return p; // Ž�� ����
		}
		return null; // Ž�� ����
	}
	
	private TreeNode searchParentNode(int data) {
		TreeNode p = root;
		TreeNode parent = null;
		while(p != null) {
			if(data < p.key) {
				parent = p;
				p = p.left;
			}
			else if (data > p.key) {
				parent = p;
				p = p.right;
			}
			else 
				return parent; // Ž�� ����
		}
		return null; // Ž�� ����
	}
	
	public void search(int data) {
		TreeNode p = searchNode(data);
		if(p != null)
		System.out.println("Searching Success! Searched key : "+ data);
		else
		System.out.println("Searching fail! There is no " + data);
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
		System.out.println("hw9_2 : 201232016 ��ٽ�");
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
				System.out.print("������ ������ �Է�: ");
				data = scan.nextInt();
				bst.remove(data);
				break;
			case 3 :
				System.out.println("3:Ʈ������ �˻�");
				System.out.print("�˻��� ������ �Է�: ");
				data = scan.nextInt();
				bst.search(data);
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
