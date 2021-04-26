package com.company.namingserver;

import java.lang.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Database {

    private ConcurrentHashMap<Integer, String> db;

    public Database(){
        this.db = new ConcurrentHashMap<>();



    }


    public static Database instance;
    public static Database getInstance()
    {
        if(instance==null)
            instance = new Database();
        return instance;
    }
}
