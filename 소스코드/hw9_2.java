//***************************
// 파일명: main.java
// 작성자: 배다슬
// 작성일: 11월 23일
// 프로그램 설명:이진탐색트리 삭제
//***************************

package hw9_2;

import java.util.Scanner;

class TreeNode {
	//키값
	int key;
	//빈도수
	int freq;
	//왼쪽 트리
	TreeNode left;
	//오른쪽 트리
	TreeNode right;
	//노드 생성자
	public TreeNode(int data) {
		this.key = data;
		this.freq = 1;
		left = right = null;
	}
}

class IntegerBinarySearchTree {
	
	private TreeNode root = null;
	
	public void add (int data) {
		//현재 노드 선언 및 시작
		TreeNode p = root;
		TreeNode q = null;
		//새로 삽입하려는 노드 생성
		TreeNode newNode = new TreeNode(data);
		while(p != null) {
			//삽입하려는 정수가 트리에 존재
			if(data == p.key) {
				//정수와 빈도수를 출력. (키값:빈도수)
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
		//삽입값이 작은 경우
		else if(data < q.key) {
			//왼쪽에 노드 연결
			q.left = newNode;
		}
		//오른쪽에 노드 연결
		else q.right = newNode;
		System.out.println(newNode.key + ":" + newNode.freq);
	}
	
	public void remove(int data) {
		
		TreeNode p = searchNode(data);
		TreeNode parent = searchParentNode(data);

		if (p == null) {
			System.out.println("삭제 실패!");
		}
		
		//경우1, 삭제 노드가 단말노드인 경우
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
		
		//경우2, 삭제 노드가 하나의 자식노드를 가진 경우
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
		
		//경우3, 삭제 노드가 두개의 자식노드를 가진 경우
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
				return p; // 탐색 성공
		}
		return null; // 탐색 실패
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
				return parent; // 탐색 성공
		}
		return null; // 탐색 실패
	}
	
	public void search(int data) {
		TreeNode p = searchNode(data);
		if(p != null)
		System.out.println("Searching Success! Searched key : "+ data);
		else
		System.out.println("Searching fail! There is no " + data);
	}
	
	// 중위 순회를 위한 서비스 메소드
	public void inorder() {
		//서비스 시작
		inorder(root);
	}
	// 중위 순회 메소드
	private void inorder(TreeNode root) { 
		if (root != null) {
			//왼쪽 탐사
			inorder(root.left);
			System.out.println(root.key + ":" + root.freq);
			//오른쪽 탐사
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
		System.out.println("hw9_2 : 201232016 배다슬");
		do{
			System.out.println("1:트리에 삽입 2:트리에서 삭제 3:트리에서 검색 4:중위순회 5:종료");
			menu = scan.nextInt();
			switch(menu) {
			case 1 : 
				System.out.println("1:트리에 삽입");
				System.out.print("삽입할 데이터 입력: ");
				data = scan.nextInt();
				bst.add(data);
				break;
			case 2 :
				System.out.println("2:트리에서 삭제");
				System.out.print("삭제할 데이터 입력: ");
				data = scan.nextInt();
				bst.remove(data);
				break;
			case 3 :
				System.out.println("3:트리에서 검색");
				System.out.print("검색할 데이터 입력: ");
				data = scan.nextInt();
				bst.search(data);
				break;
			case 4 :
				System.out.println("4:중위순회");
				bst.inorder();
				break;
			default :
				System.out.println("종료");
				break; 
			}
		}while(menu != 5);
	}
}
