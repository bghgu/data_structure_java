//***************************
// ���ϸ�: hw5_2.java
// �ۼ���: ��ٽ�
// �ۼ���: 9�� 23��
// ����: ���� �ڷᱸ��
//***************************

package hw5_2;

import java.util.Scanner;

public class hw5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�迭 ũŰ 100 ����
		int[] array = new int[100];
		
		//�Է°� ����
		int num;
		
		//�迭�� ���̸� ���ϱ� ���� ����
		int size = 0;
		
		//���� �Է��� ���� ��ġ�� ���ϱ� ���� ����
		int x = -1;
		
		//�Է°��� �ޱ����� scan��ü ����
		Scanner scan = new Scanner(System.in);
		
		//�ʱ� ����Ʈ �� �Ҵ�
		for(int i=0; i<10; i++)
		{
			//�迭 �� �Ҵ�
			array[i] = i*11;
			//�迭�� ũ�� �� ���
			size++;
		}
		System.out.println("hw5_2: ��ٽ�");
		System.out.println("�ʱ� ����Ʈ");
		System.out.println("���� = " + size);
		System.out.print("���� = ");
		for(int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}
		//����� ���� ���� �ϱ� ���� ����
		System.out.println("");
		System.out.println("���� �����մϴ�.");
		
		//��Ȯ�� ������ ���� �Է� �ǵ��� �ݺ�
		do{
			System.out.println("��Ȯ�� ������ ���� �Է��� �ּ���.");
			System.out.print("������ �ε��� �Է�(0~9): ");
			num = scan.nextInt();
		}while(num<0 || num>9);
		
		//���� ������ ��ĭ�� �����
		for (int i=num; size>i; i++)
		{
			array[i] = array[i+1];
	    }
		
		//�迭�� ���� 1����
		size--;
		
		System.out.print("���� �� ����Ʈ");
		System.out.println("���� = " + size);
		System.out.print("���� = ");
		for(int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}	
	}

}
