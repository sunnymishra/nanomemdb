package org.db;

import org.pojo.ConnectionVO;
import org.pojo.QueryVO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Database {

    private static Map<String, String> memStore = new HashMap<>();

    private static Database instance = null;
    private Database(){
        // Singleton pattern
    }

    synchronized public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }
    public void init(){
        // TBD
    }


    /**
     * User operation execute Handler method
     * @param operationStr
     */
    public void execute(String connectionId, String operationStr) {
        QueryVO queryVO = Query.parse(operationStr);
        if(queryVO==null){
            System.out.println("Empty input received. Stopping connection!");
            return;
        }

        switch (queryVO.getName().toUpperCase()){
            case "BEGIN":
                begin(connectionId);
                break;
            case "SET":
                set(connectionId, queryVO);
                break;
            case "UNSET":
                unset(connectionId, queryVO);
                break;
            case "GET":
                get(connectionId, queryVO);
                break;
            case "ROLLBACK":
                rollback(connectionId);
                break;
            case "COMMIT":
                commit(connectionId);
                break;
            default:
                System.out.println("Unknown operation received"+ queryVO);
        }
    }

    /**
     * Get key-value from the database
     * @param queryVO
     */
    public String get(String connectionId, QueryVO queryVO) {
        String value = memStore.getOrDefault(queryVO.getKey(), "NULL");
        System.out.println("key="+queryVO.getKey() + " value="+value);
        return value;
    }

    /**
     * Set the Key-value pair to the database
     * @param queryVO
     */
    public void set(String connectionId, QueryVO queryVO) {
        // If key present in HashMap it will overwrite value,
        // If key not present it will create new Key-value pair in HashMap
        memStore.put(queryVO.getKey(), queryVO.getValue());
    }

    /**
     * Unset the Key-Value pair from the database
     * @param queryVO
     */
    public void unset(String connectionId, QueryVO queryVO) {
        if (memStore.containsKey(queryVO.getKey())) {
            memStore.remove(queryVO.getKey());
        }
    }

    /**
     * Transaction Begin Handler method
     */
    private void begin(String connectionId) {
    }

    /**
     * Transaction Rollback Handler method
     */
    public void rollback(String connectionId) {
    }

    /**
     * Transaction Commit Handler method
     */
    public void commit(String connectionId) {
    }
}
