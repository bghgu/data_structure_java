//***************************
// 파일명: hw5_4.java
// 작성자: 배다슬
// 작성일: 9월 23일
// 설명: 순차 자료구조
//***************************

package hw5_4;

class Polynomial {
	//차수 필드
	private int degree;
	//계수 필드
	private double coef[] = new double[20];
	//생성자1
	Polynomial(int degree, double coef[]) {
		this.degree = degree;
		this.coef = coef;
	}
	//생정자2
	Polynomial(int degree) {
		this.degree = degree;
		for(int i=0; i<=degree; i++) {
			this.coef[i] = 0;
		}
	}
	//차수 접근자
	public int getDegree() {
		return this.degree;
	}
	//계수 접근자
	public double getCoef(int i) {
		return this.coef[i];
	}
	//계수 설정자
	public double setCoef(int i, double coef) {
		return this.coef[i] = coef;
	}
	//계수 출력
	public void printPoly(){
		
		for(int i=0; i<=this.degree; i++)
		{
			System.out.printf("%3.01f ", this.coef[i]);
		}

		System.out.println();
	}
	
}
//addPoly 연산 클래스
class OperatePoly {
	//차수 필드
	private int degree_A = 0;
	private int degree_B = 0;
	private int degree_C = 0;
	//계수 순서 
	private int index_A = 0;
	private int index_B = 0;
	private int index_C = 0;
	//계수
	private int expo_A;
	private int expo_B;
	
	private double coef_A;
	private double coef_B;
	private double coef_C;
	//다항식 덧셈
	public Polynomial addPoly(Polynomial A, Polynomial B) {
		//차수 저장
		degree_A = A.getDegree();
		degree_B = B.getDegree();
		//addPoly을 위한 차수 저장
		expo_A = degree_A;
		expo_B = degree_B;
		//차수 설정
		if(degree_A >= degree_B) {
			//a차수가 b보다 클 경우 a로 설정
			degree_C = degree_A;
		}
		else
			//b차수가 a보다 클 경우 b로 설정
			degree_C = degree_B;
		//C 객체 생성
		Polynomial C = new Polynomial(degree_C);
		/*a의 계수순서가 a의 차수값보다 같거나 작고 
		b의 계수 순서값이 b의 차수값 보다 작을 때 까지 반복*/
		while(index_A <= degree_A && index_B <= degree_B) {
			//a의 차수보다 b의 차수가 더 클경우
			if(expo_A > expo_B) {
				C.setCoef(index_C++, A.getCoef(index_A++));
				expo_A--;
			}
			//a와 b의 차수가 같을 경우
			else if(expo_A == expo_B) {
				C.setCoef(index_C++, A.getCoef(index_A++)+B.getCoef(index_B++));
				expo_A--;
				expo_B--;
			}
			//b의 차수가 더 클경우
			else {
				C.setCoef(index_C++, B.getCoef(index_B++));
				expo_B--;
			}
		}
		//객체 c 반환
		return C;
	}
}

public class hw5_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_4: 배다슬");
		
		//계수 선언
		double a1[]= new double[] {9, 4, 5, 0};
		double b1[]= new double[] {8, 1, -3, 2.5, 1.8};
		double a2[]= new double[] {3, 4, 5, 6, 7};
		double b2[]= new double[] {-3, -4, 4, 6, 0};
		double a3[]= new double[] {7, -6, 5, 3, 3, 1.5, 2.5};
		double b3[]= new double[] {6, 3, 2, 1, 0, 7, -2.5};
		//차수 선언
		Polynomial A1 = new Polynomial(3, a1);
		Polynomial B1 = new Polynomial(4, b1);
		Polynomial A2 = new Polynomial(4, a2);
		Polynomial B2 = new Polynomial(4, b2);
		Polynomial A3 = new Polynomial(6, a3);
		Polynomial B3 = new Polynomial(6, b3);
		//addPoly를 위한 객체 선언
		OperatePoly optPoly = new OperatePoly();
		//C에 addPoly값 할당
		Polynomial C1 = optPoly.addPoly(A1, B1);
		Polynomial C2 = optPoly.addPoly(A1, B1);
		Polynomial C3 = optPoly.addPoly(A1, B1);
		
		//출력
		System.out.print("A1(x)= "); A1.printPoly(); 
		System.out.print("B1(x)= "); B1.printPoly(); 
		System.out.print("C1(x)= "); C1.printPoly(); 
		System.out.print("A2(x)= "); A2.printPoly(); 
	 	System.out.print("B2(x)= "); B2.printPoly(); 
	 	System.out.print("C2(x)= "); C2.printPoly(); 
	 	System.out.print("A3(x)= "); A3.printPoly(); 
	 	System.out.print("B3(x)= "); B3.printPoly(); 
	 	System.out.print("C3(x)= "); C3.printPoly(); 
	}

}
