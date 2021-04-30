package com.company.namingserver;

import java.lang.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class fileHandler {

    public static ConcurrentHashMap<Integer, File> filesMap = new ConcurrentHashMap<>();

    public static void addFile(String filename, ConcurrentHashMap<Integer, String> nodesMap){
        System.out.println("Adding the following file to the files hashmap: " +filename);
        File temp = new File(filename, nodesMap);
        filesMap.put(temp.getHash(),temp);
        System.out.println("File added to node with nodeID: "+temp.getNodeID());
    }

    public static void removeFile(String filename){
        System.out.println("The following file will be removed from the files hashmap: "+filename);
        for (Map.Entry<Integer, File> entry : filesMap.entrySet()){
            if (filename.equals(entry.getValue().getFilename())){
                filesMap.remove(entry.getKey());
            }
        }
    }

    public String searchFile(String filename){
        int hash = Hasher.hashCode(filename);

        if(!filesMap.containsKey(hash)){
            return "error 404: File not found";
        }

        for (Map.Entry<Integer, File> entry : filesMap.entrySet()){

        }

    }



    public static fileHandler instance;
    public static fileHandler getInstance()
    {
        if(instance==null)
            instance = new fileHandler();
        return instance;
    }
}
