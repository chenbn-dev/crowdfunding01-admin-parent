package cn.chenbonian.crowdfunding.test;

import cn.chenbonian.crowdfunding.util.CrowdUtil;
import org.junit.Test;

/**
 * @author chbn
 * @create 2020-05-06 23:03
 */

public class StringTest {

    @Test
    public void testMd5(){
        String source = "123";
        String encoded = CrowdUtil.md5(source);
         System.out.println(encoded);
    }

}
