package core;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author linjiabao001
 * @date 2021/1/13
 * @description
 */

public class ClusterGenerator {
    int index = 0;
    List<String> clusters = new ArrayList<>();
    int length;

    public ClusterGenerator(Map<String, Integer> ruleMap) {
        ruleMap.forEach((k, v) -> {
            for (int i = 0; i < v; i++) {
                clusters.add(k);
            }
        });
        length = clusters.size();
    }

    public synchronized String getCluster() {
        String cluster = clusters.get(index);
        index++;
        if (index % length == 0) {
            index = 0;
        }
        return cluster;
    }
}
