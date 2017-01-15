//***************************
// ���ϸ�: hw5_4.java
// �ۼ���: ��ٽ�
// �ۼ���: 9�� 23��
// ����: ���� �ڷᱸ��
//***************************

package hw5_4;

class Polynomial {
	//���� �ʵ�
	private int degree;
	//��� �ʵ�
	private double coef[] = new double[20];
	//������1
	Polynomial(int degree, double coef[]) {
		this.degree = degree;
		this.coef = coef;
	}
	//������2
	Polynomial(int degree) {
		this.degree = degree;
		for(int i=0; i<=degree; i++) {
			this.coef[i] = 0;
		}
	}
	//���� ������
	public int getDegree() {
		return this.degree;
	}
	//��� ������
	public double getCoef(int i) {
		return this.coef[i];
	}
	//��� ������
	public double setCoef(int i, double coef) {
		return this.coef[i] = coef;
	}
	//��� ���
	public void printPoly(){
		
		for(int i=0; i<=this.degree; i++)
		{
			System.out.printf("%3.01f ", this.coef[i]);
		}

		System.out.println();
	}
	
}
//addPoly ���� Ŭ����
class OperatePoly {
	//���� �ʵ�
	private int degree_A = 0;
	private int degree_B = 0;
	private int degree_C = 0;
	//��� ���� 
	private int index_A = 0;
	private int index_B = 0;
	private int index_C = 0;
	//���
	private int expo_A;
	private int expo_B;
	
	private double coef_A;
	private double coef_B;
	private double coef_C;
	//���׽� ����
	public Polynomial addPoly(Polynomial A, Polynomial B) {
		//���� ����
		degree_A = A.getDegree();
		degree_B = B.getDegree();
		//addPoly�� ���� ���� ����
		expo_A = degree_A;
		expo_B = degree_B;
		//���� ����
		if(degree_A >= degree_B) {
			//a������ b���� Ŭ ��� a�� ����
			degree_C = degree_A;
		}
		else
			//b������ a���� Ŭ ��� b�� ����
			degree_C = degree_B;
		//C ��ü ����
		Polynomial C = new Polynomial(degree_C);
		/*a�� ��������� a�� ���������� ���ų� �۰� 
		b�� ��� �������� b�� ������ ���� ���� �� ���� �ݺ�*/
		while(index_A <= degree_A && index_B <= degree_B) {
			//a�� �������� b�� ������ �� Ŭ���
			if(expo_A > expo_B) {
				C.setCoef(index_C++, A.getCoef(index_A++));
				expo_A--;
			}
			//a�� b�� ������ ���� ���
			else if(expo_A == expo_B) {
				C.setCoef(index_C++, A.getCoef(index_A++)+B.getCoef(index_B++));
				expo_A--;
				expo_B--;
			}
			//b�� ������ �� Ŭ���
			else {
				C.setCoef(index_C++, B.getCoef(index_B++));
				expo_B--;
			}
		}
		//��ü c ��ȯ
		return C;
	}
}

public class hw5_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw5_4: ��ٽ�");
		
		//��� ����
		double a1[]= new double[] {9, 4, 5, 0};
		double b1[]= new double[] {8, 1, -3, 2.5, 1.8};
		double a2[]= new double[] {3, 4, 5, 6, 7};
		double b2[]= new double[] {-3, -4, 4, 6, 0};
		double a3[]= new double[] {7, -6, 5, 3, 3, 1.5, 2.5};
		double b3[]= new double[] {6, 3, 2, 1, 0, 7, -2.5};
		//���� ����
		Polynomial A1 = new Polynomial(3, a1);
		Polynomial B1 = new Polynomial(4, b1);
		Polynomial A2 = new Polynomial(4, a2);
		Polynomial B2 = new Polynomial(4, b2);
		Polynomial A3 = new Polynomial(6, a3);
		Polynomial B3 = new Polynomial(6, b3);
		//addPoly�� ���� ��ü ����
		OperatePoly optPoly = new OperatePoly();
		//C�� addPoly�� �Ҵ�
		Polynomial C1 = optPoly.addPoly(A1, B1);
		Polynomial C2 = optPoly.addPoly(A1, B1);
		Polynomial C3 = optPoly.addPoly(A1, B1);
		
		//���
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
