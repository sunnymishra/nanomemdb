package org;

import org.db.Connection;
import org.db.Database;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn=new Connection();
        String connectionId = conn.add( "localhost");

        Database db = Database.getInstance();

        Scanner scanner = new Scanner(System.in);
        String line = "";
        while (!(line = scanner.nextLine()).equalsIgnoreCase("END")){
            db.execute(connectionId, line);
        }

        conn.remove(connectionId);
    }
}
