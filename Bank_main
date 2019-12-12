import javax.swing.JOptionPane ;
public class Bank_main extends BankGUI {
    private static  Object[] s0 = { "注册账户", "已有账户登陆", "退出" } ;
    public static void main(String[] args) {
        Bank_main a = new Bank_main();
        int op1 = JOptionPane.showOptionDialog( null, 
                "欢迎您选择XX银行", "XX银行登陆界面",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, s0, null );                                                         
        if( op1 == JOptionPane.YES_OPTION ) {
            a.types();
        }
        else if( op1 == JOptionPane.NO_OPTION ) {
            a.login();
        }
        else
            System.exit( 0 );
    }
}
