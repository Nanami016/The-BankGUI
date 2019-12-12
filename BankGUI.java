import javax.swing.JOptionPane ;
//import java.util.Arrays ;
public class BankGUI extends BankAccount {
    private static String[] passwd1 = new String[ 10000 ] ;
    private static String[] cardID1 = new String[ 10000 ] ;
    private static String[] passwd2 = new String[ 10000 ] ;
    private static String[] cardID2 = new String[ 10000 ] ;
    private static Object[] s0 = { "注册账户", "已有账户登陆", "退出" } ;
    private static Object[] s1 = { "查询余额", "存款" , "取款", "退出" } ;
    private static Object[] s2 = { "确认", "取消" } ;
    private static Object[] s3 = { "存款类型", "支票类型" } ;
    private int i = 0 ;                                                     // i 用于存放储蓄账户     
    private int c = 0 ;                                                     // c 用于存放支票账户
    private double interestRate = 0.02 ;                                    // 当前存款利率

    public BankGUI(  ) {
        //super(id) = cardID1[i];
        //super.getId() = this.cardID1[i];
    }

    public String getId() {                                             // 用cardID1覆盖父类中的id（更新ID）
        return BankGUI.cardID1[ i ] ;
    }

    public void cover() {                                                   // 回主界面
        int op1 = JOptionPane.showOptionDialog( null, 
                "欢迎您选择XX银行", "XX银行登陆界面",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, s0, null );                                                         
        if( op1 == JOptionPane.YES_OPTION ) {
            types();
        }
        else if( op1 == JOptionPane.NO_OPTION ) {
            login();
        }
        else
            System.exit( 0 );
    }

    public void types() {                                                   // 选择开户类型
        int op = JOptionPane.showOptionDialog( null, 
        "欢迎您选择XX银行", "XX银行登陆界面",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, s3, null );  
        if( op == JOptionPane.YES_OPTION )
            Adduser_save();
        if( op == JOptionPane.NO_OPTION )
            Adduser_check();
    }

    public void Adduser_save() {                                              // 添加新储蓄账户
        cardID1[ i ] = "A" + i ;
        passwd1[ i ] = JOptionPane.showInputDialog( "设置您的密码" ) ;         // 读取输入的字符串作为密码
        JOptionPane.showMessageDialog( null, "您的卡号是:" + cardID1[ i ] ) ;  // 告知客户卡号
        i++ ;                                                                // 更新id往后推移避免覆盖
        int op = JOptionPane.showOptionDialog( null,                         // 选择是否回到主界面
                "回到主界面？", "XX银行登陆界面",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, s2, null ) ;                          
        if( op == JOptionPane.YES_OPTION )                                   // 跳转，进入登陆界面
            cover() ;
        else                                                                 // 退出
            System.exit( 0 );
    }

    public void Adduser_check() {                                               // 添加新支票账户
        cardID2[ c ] = "B" + c ;
        passwd2[ c ] = JOptionPane.showInputDialog( "设置您的密码" ) ;         // 读取输入的字符串作为密码
        JOptionPane.showMessageDialog( null, "您的卡号是:" + cardID2[ c ] ) ;  // 告知客户卡号
        c++ ;                                                                // 更新id往后推移避免覆盖
        int op = JOptionPane.showOptionDialog( null,                         // 选择是否回到主界面
                "回到主界面？", "XX银行登陆界面",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, s2, null ) ;                          
        if( op == JOptionPane.YES_OPTION )                                   // 跳转，进入登陆界面
            cover() ;
        else                                                                 // 退出
            System.exit( 0 );
    
    }
    
    private int j ;                                                          // 用来记录一对一账户 独立进行功能
    
    public void login() {                                                    // 登陆窗口
        String inputID, inputpasswd ;
        inputID = JOptionPane.showInputDialog( "请输入您的卡号" ) ;
        inputpasswd = JOptionPane.showInputDialog( "请输入你的密码" ) ;
        for( j = 0 ; j >= 0 ; j++ ) {                                        // 在卡号库中进行扫描是否存在
            if( inputID.compareTo( cardID1[ j ] ) == 0 ) 
                if( inputpasswd.compareTo( passwd1[ j ] ) == 0 ) {           // 账号与密码无误后进入主系统
                    JOptionPane.showMessageDialog( null, "登陆成功" ) ;
                    insystem_save( cardID1[ j ] );
                }
            if( inputID.compareTo( cardID2[ j ] ) == 0 )
                if( inputpasswd.compareTo( passwd2[ j ] ) == 0 ) {          // 账号与密码无误后进入主系统
                    JOptionPane.showMessageDialog( null, "登陆成功" ) ;
                    insystem_check( cardID2[ j ] );
                }    
            else {                                                            // 错误返回错误信息
                JOptionPane.showMessageDialog( null, "账户名或密码错误" ) ;
            }
        }login();
    }

    /*public void judge( String id ) {                                         // 判断账户类型
        if( Arrays.asList( id ).contains( "A" ) )
            insystem_save( id );
        if( Arrays.asList( id ).contains( "B" ) )
            insystem_check( id );
    }*/

    public void insystem_save( String id  ) {                                  // 主系统功能界面
        int flash = JOptionPane.showOptionDialog( null,                      
                "功能", "XX银行登陆界面",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, s1, null ) ;
        
            SavingsAccount a = new SavingsAccount( id, interestRate ) ;
        
            if( flash == 0 )                                                     // 查询余额 
                JOptionPane.showMessageDialog( null, getBalance() ) ;   
                    
            if( flash == 1 ) {                                                   // 存款
                String M ;
                M = JOptionPane.showInputDialog( "请输入您要存的金额" ) ;           
                int m ;
                m = Integer.parseInt( M ) ;                                       
                deposit( m ) ;
                a.addInterest( interestRate );                                      // 加息
            }
            if( flash == 2 ) {                                                   // 取款
                String N ;
                N = JOptionPane.showInputDialog( "请输入您要取的金额" ) ;
                int n ;
                n = Integer.parseInt( N ) ;
                if( getBalance() >= n )
                    withdraw( n ) ;
                else
                    JOptionPane.showMessageDialog( null, "您的余额不足" );
            }
            if( flash == 3 )                                                     // 退出
                System.exit( 0 ) ;
            Return_save();
    }

    public void insystem_check( String id ) {
        int flash = JOptionPane.showOptionDialog( null,                      
                "功能", "XX银行登陆界面",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, s1, null ) ;
            
        CheckingAccount b = new CheckingAccount( id );        

        if( flash == 0 )                                                     // 查询余额 
            JOptionPane.showMessageDialog( null, getBalance() ) ;   
                
        if( flash == 1 ) {                                                   // 存款
            String M ;
            M = JOptionPane.showInputDialog( "请输入您要存的金额" ) ;           
            int m ;
            m = Integer.parseInt( M ) ;                                       
            deposit( m ) ;
        }
        if( flash == 2 ) {                                                   // 取款
            String N ;
            N = JOptionPane.showInputDialog( "请输入您要取的金额" ) ;
            int n ;
            n = Integer.parseInt( N ) ;
            if( getBalance() >= n )
                withdraw( n ) ;
            else
                JOptionPane.showMessageDialog( null, "您的余额不足" ) ;
        }
        if( flash == 3 )                                                     // 退出
            System.exit( 0 ) ;
        b.deductFees();                                                     // 扣除手续费
        Return_check();
    }
    public void Return_save() {                                             // 进入选项后返回上一级界面
        insystem_save( cardID1[ j ] );
    }
    public void Return_check() {                                            // 进入选项后返回上一级界面
        insystem_check( cardID2[ j ] );
    }
}
