package org.db;

import org.helper.Util;
import org.pojo.ConnectionVO;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Connection {
    private static Map<String, ConnectionVO> activeConnections = new HashMap<>();

    public static Map<String, ConnectionVO> getActiveConnections(){
        return activeConnections;
    }

    public String add(String clientHostname){
        String connectionId = Util.generateUUID()+clientHostname;

        ConnectionVO conn = new ConnectionVO();
        conn.setHostname(clientHostname);
        conn.setId(connectionId);

        activeConnections.put(connectionId, conn);
        return connectionId;
    }

    public void remove(String connectionId){
        if(activeConnections.containsKey(connectionId)){
            activeConnections.remove(connectionId);
        }

    }
}
