package com.hicsc.hash;

public class VirtualNode<T extends Node> implements Node {
    // 此虚拟节点关联物理节点
    private T physicalNode;
    // 由于一个物理节点关联多个虚拟节点
    // 增加一个索引值来区分虚拟节点
    // 取值可以很随意，只要保证同一个物理节点下的虚拟节点索引不一样即可
    private int replicaIndex;

    public VirtualNode(T physicalNode, int replicaIndex) {
        this.physicalNode = physicalNode;
        this.replicaIndex = replicaIndex;
    }
    @Override
    public String getKey() {
        return physicalNode.getKey() + "-" + replicaIndex;
    }
    // 判断虚拟节点是否与指定物理节点相关联
    public boolean isVirtualNodeOf(T node) {
        return physicalNode.getKey().equals(node.getKey());
    }
    // 获取物理节点
    public T getPhysicalNode() {
        return physicalNode;
    }
}
