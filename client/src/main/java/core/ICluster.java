package core;

/**
 * @author linjiabao001
 * @date 2021/1/13
 * @description
 */
public interface ICluster {
    /**
     * 用于进行集群划分的时候，不需要计算概率，直接返回请求应该去的集群
     * @param target 目标服务的appID
     * @return 返回此次请求对应的 集群
     */
    String getCluster(String target);
}
