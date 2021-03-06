package com.study.chapter.Four_Graph.Four_ShortestPathTree;

import com.study.chapter.Four_Graph.Sec_DiGraph.Toplogical;
import edu.princeton.cs.algs4.Stack;

public class AcyclicLP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicLP(EdgeWeightedDigraph g, int s,boolean doReverse) {
        this.edgeTo = new DirectedEdge[g.getV()];
        distTo = new double[g.getV()];
        for (int i = 0; i < g.getV(); i++) {
            distTo[i] = Double.NEGATIVE_INFINITY;
        }
        distTo[s] = .0;
        Toplogical top = new Toplogical(g);
        for (Integer integer : top.getOrder()) {
            relax(g, integer);
        }
    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge directedEdge : g.adj(v)) {
            int w = directedEdge.to();
            if (distTo[w] <= distTo[v] + directedEdge.getWeight()) {
                distTo[w] = distTo[v] + directedEdge.getWeight();
                edgeTo[w] = directedEdge;
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo(v) > Double.NEGATIVE_INFINITY;
    }

    public Iterable<DirectedEdge> path(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()])
            path.push(edge);
        return path;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph g = EdgeWeightedDigraph.tinyEWDAG();
//        Digraph digraph = Digraph.getDAG();
        int s = 5;
        AcyclicLP lp = new AcyclicLP(g, s,true);
        for (int i = 0; i < g.getV(); i++) {
            if (lp.hasPathTo(i)) {
                System.out.println(s + " to " + i + " ");
                for (DirectedEdge edge : lp.path(i)) {
                    System.out.println(edge);
                }
            }
        }
//        new AcyclicSP(digraph,0);
    }

}
