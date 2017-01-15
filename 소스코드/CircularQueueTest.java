package hw8_1;

class CircularQueue {
	//정수 배열 저장
	private int[] array;
	//용량, 즉 배열 크기
	private int capacity;
	//큐에 저장된 정수 개수 세는 변수
	private int count;
	//맨 앞
	private int front;
	//맨 뒤
	private int rear;
	//생성자
	public CircularQueue(int n) {
		//용량 할당
		this.capacity = n;
		front = 0;
		rear = 0;
		array = new int[capacity];
	}
	//큐가 비었는지 판단
	public boolean isEmpty() {
		return (count == 0);
	}
	//큐가 꽉찼는지 판단
	public boolean isFull() {
		return (count == capacity);
	}
	//큐에 삽입
	public void enQueue(int n) {
		//큐가 꽉찼을 경우
		if(isFull()) {
			System.out.println("Inserting fail! Circular Queue is full!!");
		}
		//큐에 자리가 있을 경우
		else{
			//맨 뒤 자리 이동
			rear = (rear+1) % capacity;
			//맨뒤에 삽입
			array[rear] = n;
			//안내 문구 출력
			System.out.println("큐에 " + array[rear] + " 삽입");
			//크기+1
			count++;
		}
	}
	//큐에서 삭제
	public void deQueue() {
		//큐가 비었을 경우
		if(isEmpty()) {
			System.out.println("Deleting fail! Circular Queue is empty!!");	
		}
		//큐에 데이터가 있을 경우
		else {
			//맨 앞 자리 이동
			front = (front+1) % capacity;
			//안내 문구 출력
			System.out.println(array[front] + " 큐에서 삭제");
			//크기-1
			count--;
		}
	}
}

public class CircularQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw8_1: 배다슬");
		//큐 객체 생성
		CircularQueue q1 = new CircularQueue(5);
		//큐 삽입
		q1.enQueue(1);
		q1.enQueue(3);
		q1.enQueue(5);
		q1.enQueue(7);
		q1.enQueue(9);
		//큐 삭제
		q1.deQueue();
		q1.deQueue();
		//큐 삽입
		q1.enQueue(2);
		q1.enQueue(5);
		q1.enQueue(6);
		//큐 전부 삭제
		while(!q1.isEmpty()) {
			q1.deQueue(); 
		}
		//큐 삭제
		q1.deQueue();
	}

}

