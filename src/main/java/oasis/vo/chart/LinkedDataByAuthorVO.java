package oasis.vo.chart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L.T
 * @version 1.0
 * @date 2020/04/10 09:03
 * @description 作者链接图所需数据 VO 类
 */
public class LinkedDataByAuthorVO {

    /**
     * 结点参数列表
     */
    private List<Node> nodes = new ArrayList<>();

    /**
     * 边参数列表
     */
    private List<Edge> edges = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(String name, Integer symbolSize, Integer id) {
        Node node = new Node(name, symbolSize, id);
        this.nodes.add(node);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Integer value, Integer source, Integer target) {
        Edge edge = new Edge(value, source, target);
        this.edges.add(edge);
    }

    public LinkedDataByAuthorVO() {
    }

    public LinkedDataByAuthorVO(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    /**
     * 结点参数
     */
    private class Node {

        /**
         * 作者姓名
         */
        private String name;

        /**
         * 作者权重【活跃度】
         */
        private Integer symbolSize;

        /**
         * 作者编号
         */
        private Integer id;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSymbolSize() {
            return symbolSize;
        }

        public void setSymbolSize(Integer symbolSize) {
            this.symbolSize = symbolSize;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Node() {
        }

        public Node(String name, Integer symbolSize, Integer id) {
            this.name = name;
            this.symbolSize = symbolSize;
            this.id = id;
        }

    }

    /**
     * 边参数
     */
    private class Edge {

        /**
         * 合作次数
         */
        private Integer value;

        /**
         * 起始结点【作者】编号
         */
        private Integer source;

        /**
         * 终止结点【作者】编号
         */
        private Integer target;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getSource() {
            return source;
        }

        public void setSource(Integer source) {
            this.source = source;
        }

        public Integer getTarget() {
            return target;
        }

        public void setTarget(Integer target) {
            this.target = target;
        }

        public Edge() {
        }

        public Edge(Integer value, Integer source, Integer target) {
            this.value = value;
            this.source = source;
            this.target = target;
        }

    }

}
