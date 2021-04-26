package com.company.namingserver;

import java.util.concurrent.ConcurrentHashMap;

public class File {

    private String filename;
    private int nodeID;
    private int hash;

    public File(String filename, ConcurrentHashMap<Integer, String> nodes){
        this.filename = filename;
        this.hash = Hasher.hashCode(filename); //key van file Hashmap
        this.nodeID = setNodeID(nodes); //Key van nodes hashMap
    }

    public String getFilename() {
        return filename;
    }

    public int getHash() {
        return hash;
    }

    public int getNodeID() {
        return nodeID;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        this.hash = Hasher.hashCode(filename);
    }

    public int setNodeID(ConcurrentHashMap<Integer, String> nodes) {
        int array[] = new int[nodes.size()];
        int i = 0, temp = 1000000, temp2 = 0; //zal tussen een van deze 2 liggen

        for (ConcurrentHashMap.Entry<Integer, String> entry : nodes.entrySet()) {
            int key = entry.getKey();
            if (key > temp2) {
                temp2 = entry.getKey();
            }
            if (key < hash) {
                array[i] = entry.getKey();
                i++;
            }
        }

        for (int j = 0; j < array.length; j++) {
            if (hash - array[j] < temp){
                temp = array[j];
            }
        }

        if (temp == 0){
            return temp2;
        }
        else {
            return temp;
        }
    }
}