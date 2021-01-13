import core.RuleCenter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linjiabao001
 * @date 2021/1/13
 * @description
 */
public class ClusterTest {
    @Test
    public void test() throws InterruptedException {
        RuleCenter center = new RuleCenter();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                String cluster = center.getCluster("B");
                map.put(cluster, map.getOrDefault(cluster, 0) + 1);
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(map);
    }
}
