package com.libjavapractice.hashing;

import java.util.LinkedList;
import java.util.List;

public class HashMapImplementationExample {
    static class HashMapImp<K, V> {
        private class Node{
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        List<Node> bucket[]; //N = buckets.length

        HashMapImp(){
            this.N = 4;
            this.bucket = new LinkedList[4];

            for (List eachArrayIndexLinkedList: bucket) {
                eachArrayIndexLinkedList = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            return 0;
        }

        private int searchInLinkedList(int bucketIndex, K key) {
            return bucketIndex;
        }

        V put(K key, V value) {
            V oldValue = null;
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLinkedList(bucketIndex, key);
            if (dataIndex == -1) {//key doesn't exist
                bucket[bucketIndex].add(new Node(key, value));
                n++;
            } else {
                Node node = bucket[bucketIndex].get(dataIndex);
                oldValue = node.value;
                node.value = value;
            }

            double lambda = (double) n/N;
            double K = 2.0; //Some constant value
            if (lambda > K) {
                //rehashing

            }
            return oldValue;
        }




    }
}
