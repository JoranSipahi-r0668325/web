package controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JsonWriter {
    public static String createResult(HttpServletRequest request, HttpServletResponse response, boolean result, int statusCode, String errorMessage, Object returnObject){
        if(errorMessage == null) errorMessage = "";
        errorMessage = errorMessage.replaceAll("\"", "'");

        PrintWriter out = null;
        try{
            response.setContentType("application/json");
            out = response.getWriter();
        }catch(Exception e){}
        response.setStatus(statusCode);
        if(result){
            if(returnObject == null){
                out.print("{\"result\":\"OK\"}");
            }else{
                ObjectMapper mapper = new ObjectMapper();
                String res = "Error [ObjectMapper]: Couldn't convert object to String";
                try{
                    res = mapper.writeValueAsString(returnObject);
                }catch(Exception e){}
                out.print(res);
            }
        }else{
            out.print("{\"result\":\"ERROR\",\"error_message\":\"" + errorMessage + "\"}");
        }
        out.flush();
        return null;
    }

    public static String createResult(HttpServletRequest request, HttpServletResponse response, boolean result, int statusCode, String errorMessage){
        return createResult(request, response, result, statusCode, errorMessage, null);
    }

    public static String createResult(HttpServletRequest request, HttpServletResponse response, boolean result, int statusCode){
        return createResult(request, response, result, statusCode, "", null);
    }

    public static String createResult(HttpServletRequest request, HttpServletResponse response, String object_str){
        int statusCode = 200;
        PrintWriter out = null;
        try{
            response.setContentType("application/json");
            out = response.getWriter();
        }catch(Exception e){}
        response.setStatus(statusCode);
            if(object_str == null){
                out.print("{\"result\":\"OK\"}");
            }else{
                out.print(object_str);
            }
        out.flush();
        return null;
    }
}
