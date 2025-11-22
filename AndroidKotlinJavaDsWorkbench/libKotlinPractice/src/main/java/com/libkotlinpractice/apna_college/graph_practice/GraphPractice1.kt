package com.libkotlinpractice.apna_college.graph_practice

class GraphPractice1 {
    fun createGraph(graph: Array<ArrayList<Edge>>) {
        for (i in graph.indices) {
            graph[i] = ArrayList()
        }


    }

}

class Edge(val s: Int, val d: Int)


fun main() {

    val a1: Array<Edge> = Array(3) { Edge(1,2); Edge(2,3) }
    val a2: Array<Edge> = Array(4) { t ->
        Edge(t, t+1)

    }

    val a3 = Array<Edge?> (3) { null }
    a3[0] = Edge(1, 2)
    a3[1] = Edge(2, 3)
    val a4: Array<Edge> = emptyArray()


    println(a3.size)
}