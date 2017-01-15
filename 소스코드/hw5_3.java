//***************************
// ���ϸ�: hw5_3.java
// �ۼ���: ��ٽ�
// �ۼ���: 9�� 23��
// ����: ���� �ڷᱸ��
//***************************

package hw5_3;

import java.util.Arrays;
import java.util.Scanner;
//�迭 ���� Ŭ����
class StringList {
	
	int size = 0;
	
	String array[] = new String[100];
	
	/*����: �ε����� ���ڿ��� �Ű������� �޾� 
	�ش� ��ġ�� �����Ѵ�.*/
	public void insert(int num, String word) {
		size++;
		array[num] = word;
	}
	
	/*����: ���ڿ��� �Ű������� �޾� 
	�ش� ���Ҹ� �����Ѵ�.(�ߺ��� �տ� �͸� ����)*/
	public void delete(int num) {
		size--;
		array[num] = null;
	}
	
	/*��ȸ: �ε����� �Ű������� �޾�
	�ش� ��ġ�� ���Ҹ� �����Ѵ�.*/
	public String search(int num) {
		return array[num];
	}
	
	/*������ȸ: ����Ʈ�� ���̸� ����*/
	public int size() {
		return size;
	}
	
	/*������ȸ: ����Ʈ ������ ���ڿ��� 
	����� ����(toString �������̵�)*/
	@Override
	public String toString() {
		
		for(int i=0; i<100; i++)
		{
			if(array[i] != null)
				return "array=" + Arrays.toString(array);
		}
		return "���� �����ϴ�.";
	}
}

public class hw5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringList array = new StringList();
		
		int a;
		//�Է¹��� �ε���
		int num;
		int size = 0;
		//�Է¹��� �ܾ�
		String word;
		
		//�Է°��� �ޱ����� scan��ü ����
		Scanner scan = new Scanner(System.in);
		
		System.out.println("hw5_3: ��ٽ�");
		do{
			System.out.println("1:�ε����λ���\n2:����\n3:�ε�������ȸ\n4:��ü���\n5:����");
			System.out.print("�޴� ���� : ");
			a =scan.nextInt();
			//����ġ���� ���� �޴�����
			switch(a)
			{
				case 1 : 
				{
					System.out.println("1. �ε����� ����");
					System.out.print("0~99 ������ �ε����� �Է��� �ּ���.");
					System.out.print("�ε��� ���� : ");
					num=scan.nextInt();
					//�ݺ�
					if(num<0 || num>99) {
						do{
							System.out.println("������ ������ϴ�.");
							System.out.print("0~99 ������ �ε����� �Է��� �ּ���.");
							System.out.print("�ε��� ���� : ");
							num=scan.nextInt();
						}while(num<0 || num>99);
					}
					System.out.print("�ܾ� �Է� : ");
					word=scan.next();
					//�޼ҵ� ȣ��
					array.insert(num, word);
					break;
				}
				case 2 : 
				{
					System.out.println("2. ����");
					System.out.print("0~99 ������ �ε����� �Է��� �ּ���.");
					System.out.print("�ε��� ���� : ");
					num=scan.nextInt();
					//�ݺ�
					if(num<0 || num>99) {
						do{
							System.out.println("������ ������ϴ�.");
							System.out.print("0~99 ������ �ε����� �Է��� �ּ���.");
							System.out.print("�ε��� ���� : ");
							num=scan.nextInt();
						}while(num<0 || num>99);
					}
					//�޼ҵ� ȣ��
					array.delete(num);
					break;
				}
				case 3 : 
				{
					System.out.println("3. �ε����� ��ȸ");
					System.out.print("0~99 ������ �ε����� �Է��� �ּ���.");
					System.out.print("�ε��� ���� : ");
					num=scan.nextInt();
					//�ݺ�
					if(num<0 || num>99) {
						do{
							System.out.println("������ ������ϴ�.");
							System.out.print("0~99 ������ �ε����� �Է��� �ּ���.");
							System.out.print("�ε��� ���� : ");
							num=scan.nextInt();
						}while(num<0 || num>99);
					}
					System.out.println(array.search(num));
					break;
				}
				case 4 : 
				{
					System.out.println("4. ��ü ���");
					System.out.println(array.toString());
					System.out.println("������ : " + array.size());
					break;
				}
			}
			
		}while(a != 5);
		System.out.println("����");
	}

}
