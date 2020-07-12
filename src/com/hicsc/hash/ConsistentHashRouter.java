package com.hicsc.hash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 路由器
 */
public class ConsistentHashRouter<T extends Node> {

    private SortedMap<Long, VirtualNode<T>> ring = new TreeMap<>();
    private HashFunction hashFunction;

    public ConsistentHashRouter(Collection<T> nodes, int virtualNodeNum) {
        this(nodes, virtualNodeNum, new MD5Hash());
    }

    public ConsistentHashRouter(Collection<T> nodes, int virtualNodeNum, HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        nodes.stream().forEach(node -> addNode(node, virtualNodeNum));
    }

    // 添加节点
    public void addNode(T node, int virtualNodeNum) {
        int existingReplicas = getVirtualNodeCount(node);
        for (int i = 0; i < virtualNodeNum; i++) {
            VirtualNode vNode = new VirtualNode(node, i + existingReplicas);
            ring.put(hashFunction.hash(vNode.getKey()), vNode);
        }
    }

    // 删除节点
    public void removeNode(T node) {
        ring.values().removeIf(vNode -> vNode.isVirtualNodeOf(node));
    }

    // 路由过程，得到物理节点
    public T route(String key) {
        Long hash = hashFunction.hash(key);
        // 返回比hash大的sortedMap
        SortedMap<Long, VirtualNode<T>> tailMap = ring.tailMap(hash);
        Long nodeHash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
        return ring.get(nodeHash).getPhysicalNode();
    }

    // 获取指定节点的虚拟节点数
    public int getVirtualNodeCount(Node node) {
        int replicas = 0;
        for (VirtualNode vn : ring.values()) {
            if (vn.isVirtualNodeOf(node)) {
                replicas++;
            }
        }
        return replicas;
    }
}
