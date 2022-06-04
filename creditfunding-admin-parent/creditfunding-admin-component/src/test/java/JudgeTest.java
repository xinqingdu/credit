//import com.itxiaodu.credit.utill.JudgeUtill;
import com.itxiaodu.credit.entity.Admin;
import com.itxiaodu.credit.entity.AdminExample;
import com.itxiaodu.credit.mapper.AdminMapper;
import com.itxiaodu.credit.util.JudgeUtil;
import org.junit.Test;
//import com.itxiaodu.credit.util.*;
public class JudgeTest {
    public JudgeTest() {

    }
    @Test
    public void judge(){
//        JudgeUtill judgeUtill = new JudgeUtill();
//        System.out.println(JudgeUtill.judgeRequestType(null));
    }
    @Test
    public void md5(){
        String source="12345678";
        String encode= JudgeUtil.md5Password(source);
        System.out.println(encode);
    }
    public static void main(String[] args) {
//        JudgeUtill judgeUtill = new JudgeUtill();
//        System.out.println(JudgeUtill.judgeRequestType(null));
    }

}
