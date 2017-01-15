package hw8_1;

class CircularQueue {
	//���� �迭 ����
	private int[] array;
	//�뷮, �� �迭 ũ��
	private int capacity;
	//ť�� ����� ���� ���� ���� ����
	private int count;
	//�� ��
	private int front;
	//�� ��
	private int rear;
	//������
	public CircularQueue(int n) {
		//�뷮 �Ҵ�
		this.capacity = n;
		front = 0;
		rear = 0;
		array = new int[capacity];
	}
	//ť�� ������� �Ǵ�
	public boolean isEmpty() {
		return (count == 0);
	}
	//ť�� ��á���� �Ǵ�
	public boolean isFull() {
		return (count == capacity);
	}
	//ť�� ����
	public void enQueue(int n) {
		//ť�� ��á�� ���
		if(isFull()) {
			System.out.println("Inserting fail! Circular Queue is full!!");
		}
		//ť�� �ڸ��� ���� ���
		else{
			//�� �� �ڸ� �̵�
			rear = (rear+1) % capacity;
			//�ǵڿ� ����
			array[rear] = n;
			//�ȳ� ���� ���
			System.out.println("ť�� " + array[rear] + " ����");
			//ũ��+1
			count++;
		}
	}
	//ť���� ����
	public void deQueue() {
		//ť�� ����� ���
		if(isEmpty()) {
			System.out.println("Deleting fail! Circular Queue is empty!!");	
		}
		//ť�� �����Ͱ� ���� ���
		else {
			//�� �� �ڸ� �̵�
			front = (front+1) % capacity;
			//�ȳ� ���� ���
			System.out.println(array[front] + " ť���� ����");
			//ũ��-1
			count--;
		}
	}
}

public class CircularQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw8_1: ��ٽ�");
		//ť ��ü ����
		CircularQueue q1 = new CircularQueue(5);
		//ť ����
		q1.enQueue(1);
		q1.enQueue(3);
		q1.enQueue(5);
		q1.enQueue(7);
		q1.enQueue(9);
		//ť ����
		q1.deQueue();
		q1.deQueue();
		//ť ����
		q1.enQueue(2);
		q1.enQueue(5);
		q1.enQueue(6);
		//ť ���� ����
		while(!q1.isEmpty()) {
			q1.deQueue(); 
		}
		//ť ����
		q1.deQueue();
	}

}

