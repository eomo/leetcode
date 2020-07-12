package com.hicsc.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsistentHashTestCase {

    public static void main(String[] args) {


        test(10);
        test(20);
        test(30);
        test(40);
        test(50);
        test(60);
        test(70);
        test(80);
        test(90);
        test(100);
        test(110);
        test(120);
        test(130);
        test(140);
        test(150);
        test(160);
        test(170);
        test(180);
        test(190);
    }


    public static void test(int vcount) {
        PhysicalNode node1 = new PhysicalNode("127.0.0.1", 8080);
        PhysicalNode node2 = new PhysicalNode("127.0.0.1", 8081);
        PhysicalNode node3 = new PhysicalNode("127.0.0.1", 8082);
        PhysicalNode node4 = new PhysicalNode("127.0.0.1", 8083);
        PhysicalNode node5 = new PhysicalNode("127.0.0.1", 8084);
        PhysicalNode node6 = new PhysicalNode("127.0.0.1", 8085);
        PhysicalNode node7 = new PhysicalNode("127.0.0.1", 8086);
        PhysicalNode node8 = new PhysicalNode("127.0.0.1", 8087);
        PhysicalNode node9 = new PhysicalNode("127.0.0.1", 8088);
        PhysicalNode node10 = new PhysicalNode("127.0.0.1", 8089);

        List<PhysicalNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);
        nodes.add(node7);
        nodes.add(node8);
        nodes.add(node9);
        nodes.add(node10);

        ConsistentHashRouter<PhysicalNode> router = new ConsistentHashRouter<>(nodes, vcount);

        for (int i = 0; i < 1000000; i++) {
            String value = getRandomString(2);
            PhysicalNode node = router.route(value);
            node.size++;
        }
        // 计算标准差
        double total = nodes.stream().mapToDouble(PhysicalNode::getOffset).sum();
        System.out.println("一致性哈希算法的标准差[虚拟节点数 " + vcount + "]：" + Math.sqrt(total / 10));
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
