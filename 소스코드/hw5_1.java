//***************************
// ���ϸ�: hw5_1.java
// �ۼ���: ��ٽ�
// �ۼ���: 9�� 22��
// ����:...
//***************************

package hw5_1;

import java.util.Scanner;

public class hw5_1 {

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
		
		System.out.println("�ʱ� ����Ʈ");
		System.out.println("���� = " + size);
		System.out.print("���� = ");
		for(int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}
		//����� ���� ���� �ϱ� ���� ����
		System.out.println("");
		
		System.out.println("���ο� ���� �����մϴ�.");
		System.out.print("������ ������ �Է� : ");
		num = scan.nextInt();
		
		//�� ����Ʈ ����
		for(int i=0; i<11; i++)
		{
			if(array[i] < num)
			{	
				//���� �Է��� ���� ���� �� ��ġ ����
				x++;
			}
		}
		//�迭�� ���� 1����
		size++;
		
		//�� ������ �迭 ������ �̵� ����
		//���� �Է��ؾ� �� �� ������ ���� ����
		for (int i=size; x<i; i--)
		{
			array[i] = array[i-1];
	    }
		
		//���������� ���� �Է�
		array[x]=num;

		System.out.print("���� �� ����Ʈ");
		System.out.println("���� = " + size);
		System.out.print("���� = ");
		for(int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}
		
	}

}
