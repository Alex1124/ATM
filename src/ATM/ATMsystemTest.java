package ATM;


import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class ATMsystemTest {

	ATM a;
	

	//-----------�b�K�n�J�\�����-----------//
	@Test
	public void test() {
		Scanner keyin = new Scanner("1111\n1234\n4\n");
		a = new ATM(keyin);
		assertEquals("�n�J���\",a.Key_in("1111","1234"));	//�b���K�X���T
	}
	
	@Test
	public void test2() {
		Scanner keyin = new Scanner(System.in);
		a = new ATM(keyin);
		assertEquals("�n�J���~",a.Key_in("0","1234"));		//�b�����~�A�K�X���T
		assertEquals("�n�J���~",a.Key_in("1111","0"));		//�b�����T�A�K�X���~
		assertEquals("�n�J���~",a.Key_in("0","0"));		//�b�����~�A�K�X���~
	
	}

	
	//-----------���ڥ\�����-----------//
	@Test
	public void test3() {
		Scanner keyin = new Scanner("500\n1\n3\n1\n1111\n1234\n");
		a = new ATM(keyin);
		a.accountMoney = 50000;   
		assertEquals(49500,a.getMoney(500)); 			//accountMoney > getMoney	
	}
	
	@Test
	public void test4() {
		Scanner keyin = new Scanner("50000\n1\n3\n1\n1111\n1234\n");
		a = new ATM(keyin);
		a.accountMoney = 50000;   
		assertEquals(0,a.getMoney(50000)); 				//accountMoney == getMoney
	}
	
	@Test
	public void test5() {
		Scanner keyin = new Scanner("50001\n1\n3\n1\n1111\n1234\n");
		a = new ATM(keyin);
		a.accountMoney = 50000;    
		assertEquals(-1,a.getMoney(50001)); 			//accountMoney < getMoney
	}
	
	@Test
	public void test6() {
		Scanner keyin = new Scanner("-10000\n1\n3\n1\n1111\n1234\n");
		a = new ATM(keyin);
		a.accountMoney = 50000;    
		assertEquals(-1,a.getMoney(-10000)); 			// getMoney < 0
	}
	
	
	//-----------�\��C�����-----------//
		@Test
		public void test7() {
			Scanner keyin = new Scanner("1\n500\n1\n3\n1\n1111\n1234\n");
			a = new ATM(keyin);
			assertEquals("���\",a.Show()); 				//��J 1~4
		}
																								
		@Test
		public void test8() {
			Scanner keyin = new Scanner("10\n-1\n");
			a = new ATM(keyin);
			assertEquals("����",a.Show()); 				//��J >4
			assertEquals("����",a.Show()); 				//��J <1
		}
		
		@Test
		public void test9() {
			Scanner keyin = new Scanner("3\n3\n2\n4\n");
			a = new ATM(keyin);
			assertEquals("���\",a.Show()); 				//��J =3>>���վl�B�d��
			assertEquals("�n�J���\",a.Key_in("1111","1234"));	//�b���K�X���T
			
		}
	

	//-----------�s�ڥ\�����-----------//
		
		@Test
		public void test10() {
			Scanner keyin = new Scanner("5000\n1\n3\n1\n1111\n1234\n");
			a = new ATM(keyin);
			assertEquals(55000,a.saveMoney(5000)); 				//saveMoney >0
		}
		
		@Test
		public void test11() {
			Scanner keyin = new Scanner("-10000\n1\n");
			a = new ATM(keyin);
			assertEquals(-1,a.saveMoney(-10000)); 				//saveMoney <0
		}
		
		// System.out.println("2017/5/28����");
		
//-------------------------------*/
}
