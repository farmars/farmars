package gov.nasa.farmars.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Created by igor on 29.05.16.
 */
public class FarmHttpServer {

    public static int SERVER_PORT = 8085;

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/info", new InfoHandler());
        server.createContext("/d", new GetDataHandler());
        server.createContext("/c", new GetCommandHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Farm server is running");
    }

    static class InfoHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {
            String response = "Use /d - to recive data from devices.\n Use /c - to get commands for devices";
            FarmHttpServer.writeResponse(httpExchange, response.toString());
        }
    }

    static class GetDataHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {
            Map<String,String> parms = FarmHttpServer.queryToMap(httpExchange.getRequestURI().getQuery());
            FarmHttpServer.writeResponse(httpExchange, printParams(parms));
        }
    }

    static class GetCommandHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {

            Map<String,String> parms = FarmHttpServer.queryToMap(httpExchange.getRequestURI().getQuery());
            FarmHttpServer.writeResponse(httpExchange, printParams(parms));
        }
    }

    public static void writeResponse(HttpExchange httpExchange, String response) throws IOException {
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    /**
     * returns the url parameters in a map
     * @param query
     * @return map
     */
    public static Map<String, String> queryToMap(String query){
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length>1) {
                result.put(pair[0], pair[1]);
            }else{
                result.put(pair[0], "");
            }
        }
        return result;
    }

    private static String printParams(Map<String,String> parms) {
        StringBuilder response = new StringBuilder();
        for (Map.Entry<String, String> par : parms.entrySet()) {
            response.append(String.format("%s : %s", par.getKey(), par.getValue()));
        }

        return response.toString();
    }
}
