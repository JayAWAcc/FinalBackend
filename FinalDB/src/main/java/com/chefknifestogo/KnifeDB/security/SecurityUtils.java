package com.chefknifestogo.KnifeDB.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.chefknifestogo.KnifeDB.http.Response;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SecurityUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void sendResponse(HttpServletResponse response, int status, String message, Exception exception) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(new Response(exception == null, status, message)));
        response.setStatus(status);
        writer.flush();
        writer.close();
    }

}
