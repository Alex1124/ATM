package ATM;

import java.util.*;
import java.text.SimpleDateFormat;

class ATM {                 //���ھ����O

	String id = "1111";//�]�w�d���b��
    String password = "1234";//�]�w�d���K�X
    static int accountMoney = 50000;    //�b������5�U��

    String key_id = " ";  //��J�b��
    String key_pw = " ";  //��J�K�X
    int getMoney = 0; //���ڪ��B
    int saveMoney = 0; //�s�ڪ��B
   
  

    java.util.Scanner s = new java.util.Scanner(System.in);

    public void Key_in() {      //�b���K�X��J����
        int count = 0;   //���~�p�ƾ�
        
        do {
            System.out.print("�п�J�b���G");
            key_id = s.next();
            System.out.print("�п�J�K�X�G");
            key_pw = s.next();
            
            if (key_id.equals(id) && key_pw.equals(password)) {          //���K�X�O�_�ۦP
                System.out.println("�n�J���\");
                Show();
            } else {
                System.out.print("�b���K�X���~!!!\n");
                count++;                        //�K�X�����~count�֥[�@��
            }
        } while (count < 3);
        
        if (count == 3) {    //��3�����X��J����
            System.out.println("�K�X���~3���A�Ь��d�i�H��...");
            try {                 //����ɶ��]�w
                Thread.sleep(3000);//����3��
            } catch (InterruptedException ex) {
            }
            use_again();
        }
        
    }

    //��ܾާ@����
    public void Show() {
        System.out.println("�п�ܭn�ϥΪ��\��G");
        System.out.println("1.����  2.�s��    3.�l�B�d�� 4.���}");
        switch (s.nextInt()) {
            case 1:
                this.getMoney();  //�I�s���ڥ\��
                break;
            case 2:
                this.saveMoney();  //�I�s�s�ڥ\��
                break;
            case 3:                     //�l�B�d��
                System.out.println("�b���٦�" + accountMoney + "���C");
                final_Money();
                break;
            default:
                System.out.println("���¥��{,�w��A�רϥ�" + "\n");
                break;
        }
    }

    //���ڥ\��
    public void getMoney() {
        System.out.println("�п�J������B");
        this.getMoney = s.nextInt();
        System.out.println("�z������" + this.getMoney + "���C���T�Ы�1�A���~�Ы�2");
        switch (s.nextInt()) {
            case 1:
                if (accountMoney < getMoney) {
                    System.out.println("�l�B����,�L�k����");
                	}else if(getMoney < 0){
                		System.out.println("���B��J���~,�L�k����");  //���b
                	} else {
                    accountMoney -= getMoney;
                	}
                break;
            default:
                System.out.println("��������...");
        }
        getListCheck();
        use_again();
    }

    //�s�ڥ\��
    public void saveMoney() {
        System.out.print("�п�J�s�J���B�G");
        this.saveMoney = s.nextInt();
        System.out.println("��r��");
        try {                 //����ɶ��]�w
                    Thread.sleep(3000);//����3��
                } catch (InterruptedException ex) {
                }
        System.out.println("�z���s�J���B���G" + this.saveMoney + "���C���T�Ы�1�A���~�Ы�2");
      
        if (s.nextInt() == 1) {
        	
        	if(saveMoney < 0){
        		System.out.println("���B��J���~,�L�k����"); //���b
        	}else{
            accountMoney += this.saveMoney;
            saveListCheck();
            use_again();}
        
        } else {
            System.out.print("�����ާ@");
        }
    }


    //���ڥ�����Ӫ� 
    public void getListCheck() {
        System.out.println("�O�_�C�L���Ӫ�H 1.�C�L 2.���C�L 3.�ù����");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("���Ӫ�C�L���A�еy��...");
                try {                 //����ɶ��]�w
                    Thread.sleep(3000);//����3��
                } catch (InterruptedException ex) {
                }
                System.out.println("________________________________________");
                System.out.println("|\t���\t���Ӫ�\t\t\t|");
                System.out.println("|�ɶ�:\t\t" + getTime() + "\t|");
                System.out.println("|����\t���B:\t" + getMoney + "\t\t��\t|");
                System.out.println("|�l�B:\t\t" + accountMoney + "\t\t��\t|");
                System.out.println("________________________________________");
                break;
            case 2:
                break;
            case 3:
                System.out.println("�ɶ�:" + getTime());
                System.out.println("������B:" + getMoney + "��");
                System.out.println("�b��l�B�G" + accountMoney + "��");
                break;
            default:
                break;
        }
        use_again();
    }

    //�s�ڥ�����Ӫ� 
    public void saveListCheck() {
        System.out.println("�O�_�C�L���Ӫ�H 1.�C�L 2.���C�L 3.�ù����");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("���Ӫ�C�L���A�еy��...");
                try {                 //����ɶ��]�w
                    Thread.sleep(3000);//����3��
                } catch (InterruptedException ex) {
                }
                System.out.println("________________________________________");
                System.out.println("|\t���\t���Ӫ�\t\t\t|");
                System.out.println("|�ɶ�:\t\t" + getTime() + "\t|");
                System.out.println("|�s��\t���B:\t" + saveMoney + "\t\t��\t|");
                System.out.println("|�l�B:\t\t" + accountMoney + "\t\t��\t|");
                System.out.println("________________________________________");
                break;
            case 2:
                break;
            case 3:
                System.out.println("�ɶ�:" + getTime());
                System.out.println("�s�ڪ��B:" + saveMoney + "��");
                System.out.println("�b��l�B�G" + accountMoney + "��");
                break;
            default:
                break;
        }
        use_again();
    }


    //�l�B�d�ߩ��Ӫ� 
    public void final_Money() {
        System.out.println("�O�_�C�L���Ӫ�H 1.�C�L 2.���C�L 3.�ù����");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("���Ӫ�C�L���A�еy��...");
                try {                 //����ɶ��]�w
                    Thread.sleep(3000);//����3��
                } catch (InterruptedException ex) {
                }
                System.out.println("________________________________________");
                System.out.println("|\t���\t���Ӫ�\t\t\t|");
                System.out.println("|�ɶ�:\t\t" + getTime() + "\t|");
                System.out.println("|�l�B:\t\t" + accountMoney + "\t\t��\t|");
                System.out.println("________________________________________");
                break;
            case 2:
                break;
            case 3:
                System.out.println("�ɶ�:" + getTime());
                System.out.println("�s�ڪ��B:" + saveMoney + "��");
                System.out.println("�b��l�B�G" + accountMoney + "��");
                break;
            default:
                break;
        }
        use_again();
    }

    //���o�{�b�ɶ�
    public String getTime() {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date date = new Date();
        String strDate = sdFormat.format(date);
        return strDate;
    }

    //�O�_�~��ϥ�
    public void use_again() {
        System.out.println("�п�ܬO�_�~��ϥ� 1:�O(�д��J���ĥd) 2:�_");
        Scanner c = new Scanner(System.in);
        int choice = c.nextInt();
        if (choice == 1) {
            Key_in();
        } else {
        	
        	 try {                 //����ɶ��]�w
        		 System.out.println("�����g�ĥd�w�h�X�A�Ш��^");
                 Thread.sleep(3000);//����3��
             } catch (InterruptedException ex) {
             }
        	 Key_in();
            
            
            
        }
    }

}

public class ATMsystem {

    public static void main(String[] args) {
        // TODO code application logic here
        ATM a = new ATM();
        a.Key_in();
    }
}