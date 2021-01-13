package core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author linjiabao001
 * @date 2021/1/13
 * @description
 */
public class RuleCenter implements ICluster {
    /**
     * key=target,value=cluster-generator
     */
    Map<String, ClusterGenerator> rules = new ConcurrentHashMap<>();

    public RuleCenter() {
        initRules();
    }

    /**
     * 初步先写死，后续SpringBoot-Starter的时候在从yml文件引入
     */
    private void initRules() {
        String targetB = "B";
        Map<String, Integer> ruleMapB = new HashMap<>();
        ruleMapB.put("prod", 8);
        ruleMapB.put("gray", 1);
        ruleMapB.put("gray2", 1);
        addRule(targetB, ruleMapB);

        String targetC = "C";
        Map<String, Integer> ruleMapC = new HashMap<>();
        ruleMapB.put("prod", 8);
        ruleMapB.put("gray", 2);
        addRule(targetC, ruleMapC);
    }

    private void addRule(String target, Map<String, Integer> ruleMap) {
        ClusterGenerator clusterGenerator = new ClusterGenerator(ruleMap);
        rules.put(target, clusterGenerator);
    }

    @Override
    public String getCluster(String target) {
        return rules.get(target).getCluster();
    }
}
