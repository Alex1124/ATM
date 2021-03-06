package  ATM;

import java.util.*;
import java.text.SimpleDateFormat;

class ATM {                 //提款機類別

	String id = "1111";//設定卡片帳號
    String password = "1234";//設定卡片密碼
    static int accountMoney = 50000;    //帳號內有5萬塊

    String key_id = " ";  //輸入帳號
    String key_pw = " ";  //輸入密碼
    int getMoney = 0; //提款金額
    int saveMoney = 0; //存款金額
    boolean loginsuccess = false;
  
    java.util.Scanner s ;
    
    public ATM(Scanner keyin){
    	s = keyin;
    }

    public String Key_in(String key_id,String key_pw) {      //密碼輸入介面
        int count = 0;   //錯誤計數器
        
        do {
            System.out.print("請輸入帳號：");
            //key_id = s.next();
            System.out.print("請輸入密碼：");
            //key_pw = s.next();
            
            if (key_id.equals(id) && key_pw.equals(password)) {          //比對密碼是否相同
                System.out.println("登入成功");
                loginsuccess = true;
            	//return "登入成功";
                Show();
                
            } else {
                System.out.print("帳號密碼錯誤!!!\n");
                
                count++;                        //密碼比對錯誤count累加一次
                
                return "登入錯誤";  
            }
        } while (count == 1);
      
		return "登入成功";
        
    }

    //顯示操作頁面
    public String Show() {
    	/*if(loginsuccess==false){
    		return "尚未登入成功";
    	}*/
        System.out.println("請選擇要使用的功能：");
        System.out.println("1.提款  2.存款  3.餘額查詢 4.離開");
        switch (s.nextInt()) {
            case 1:
                this.getMoney(getMoney);  //呼叫提款功能
                return "成功";
                //break;
            case 2:
                this.saveMoney(saveMoney);  //呼叫存款功能
                return "成功";
                //break;
            case 3:                     //餘額查詢
                System.out.println("帳戶還有" + accountMoney + "元。");
                final_Money();
                return "成功";
                //break;
            default:
                System.out.println("謝謝光臨,歡迎再度使用" + "\n");
                
                return "失敗";
                //break;
        }
    }

    //提款功能
    public int getMoney(int getMoney) {
        System.out.println("請輸入提領金額");
        this.getMoney = s.nextInt();
        System.out.println("您欲提領" + this.getMoney + "元。正確請按1，錯誤請按2");
        switch (s.nextInt()) {
            case 1:
                if (accountMoney < getMoney) {
                    System.out.println("餘額不足,無法提領");
                    //assert accountMoney > getMoney;				//防呆
                    return -1;
                	}else if(getMoney < 0){
                		System.out.println("金額輸入錯誤,無法提領");  //防呆
                		//assert getMoney > 0;					//防呆
                		return -1;
                	} else {
                    accountMoney -= this.getMoney;
                    //return accountMoney;//
                	}
                break;
            default:
                System.out.println("取消提款...");
        }
       
        getListCheck();
        //use_again();
        return accountMoney;//
    }

    //存款功能
    public int saveMoney(int saveMoney) {
        System.out.print("請輸入存入金額：");
        this.saveMoney = s.nextInt();
        System.out.println("辨鈔中");
        try {                 //延遲時間設定
                    Thread.sleep(3000);//延遲3秒
                } catch (InterruptedException ex) {
                }
        System.out.println("您欲存入金額為：" + this.saveMoney + "元。正確請按1，錯誤請按2");
      
        if (s.nextInt() == 1) {
        	
        	if(saveMoney < 0){
        		System.out.println("金額輸入錯誤,無法提領"); //防呆
        		//assert saveMoney > 0;				  //防呆
        		return -1;
        	}else{
            accountMoney += this.saveMoney;
            //return accountMoney;
            saveListCheck();
            //use_again();
             			}
        
        } else {
            System.out.print("取消操作");
        }
		return accountMoney;
    }

    

    //提款交易明細表 
    public void getListCheck() {
        System.out.println("是否列印明細表？ 1.列印 2.不列印 3.螢幕顯示");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("明細表列印中，請稍候...");
                try {                 //延遲時間設定
                    Thread.sleep(3000);//延遲3秒
                } catch (InterruptedException ex) {
                }
                System.out.println("________________________________________");
                System.out.println("|\t交易\t明細表\t\t\t|");
                System.out.println("|時間:\t\t" + getTime() + "\t|");
                System.out.println("|提領\t金額:\t" + getMoney + "\t\t元\t|");
                System.out.println("|餘額:\t\t" + accountMoney + "\t\t元\t|");
                System.out.println("________________________________________");
                break;
            case 2:
                break;
            case 3:
                System.out.println("時間:" + getTime());
                System.out.println("提領金額:" + getMoney + "元");
                System.out.println("帳戶餘額：" + accountMoney + "元");
                break;
            default:
                break;
        }
        use_again();
    }

    //存款交易明細表 
    public void saveListCheck() {
        System.out.println("是否列印明細表？ 1.列印 2.不列印 3.螢幕顯示");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("明細表列印中，請稍候...");
                try {                 //延遲時間設定
                    Thread.sleep(3000);//延遲3秒
                } catch (InterruptedException ex) {
                }
                System.out.println("________________________________________");
                System.out.println("|\t交易\t明細表\t\t\t|");
                System.out.println("|時間:\t\t" + getTime() + "\t|");
                System.out.println("|存款\t金額:\t" + saveMoney + "\t\t元\t|");
                System.out.println("|餘額:\t\t" + accountMoney + "\t\t元\t|");
                System.out.println("________________________________________");
                break;
            case 2:
                break;
            case 3:
                System.out.println("時間:" + getTime());
                System.out.println("存款金額:" + saveMoney + "元");
                System.out.println("帳戶餘額：" + accountMoney + "元");
                break;
            default:
                break;
        }
        use_again();
    }

   

    //餘額查詢明細表 
    public void final_Money() {
        System.out.println("是否列印明細表？ 1.列印 2.不列印 3.螢幕顯示");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("明細表列印中，請稍候...");
                try {                 //延遲時間設定
                    Thread.sleep(3000);//延遲3秒
                } catch (InterruptedException ex) {
                }
                System.out.println("________________________________________");
                System.out.println("|\t交易\t明細表\t\t\t|");
                System.out.println("|時間:\t\t" + getTime() + "\t|");
                System.out.println("|餘額:\t\t" + accountMoney + "\t\t元\t|");
                System.out.println("________________________________________");
                break;
            case 2:
                break;
            case 3:
                System.out.println("時間:" + getTime());
                System.out.println("存款金額:" + saveMoney + "元");
                System.out.println("帳戶餘額：" + accountMoney + "元");
                break;
            default:
                break;
        }
        use_again();
    }

    //取得現在時間
    public String getTime() {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date date = new Date();
        String strDate = sdFormat.format(date);
        return strDate;
    }

    //是否繼續使用
    public void use_again() {
        System.out.println("請選擇是否繼續使用 1:是(請插入金融卡) 2:否");
        //Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        if (choice == 1) {
        	
            Key_in(key_id,key_pw);
        } else {
        	
        	 try {                 //延遲時間設定
        		 System.out.println("晶片經融卡已退出，請取回");
                 Thread.sleep(3000);//延遲3秒
             } catch (InterruptedException ex) {
             }
        	 Key_in(key_id,key_pw);
            
            
            
        }
    }

}

public class ATMsystem {

    public static void main(String[] args) {
        // TODO code application logic here
    	
    	 String key_id = "1111";  //輸入帳號
    	 String key_pw = "1234";  //輸入密碼
    	 int getMoney = 0; //提款金額
    	 int saveMoney = 0; //存款金額
    	 Scanner keyin = new java.util.Scanner(System.in);
    	    
        ATM a = new ATM(keyin);
        a.Key_in(key_id,key_pw);
        
        System.out.println("2017/5/28版本");
        
    }
}