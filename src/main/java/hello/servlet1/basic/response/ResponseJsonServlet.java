package hello.servlet1.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet1.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * JSON 데이터로 응답하는 서블릿 테스트
 * http://localhost:8080/response-json
 *
 */
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Content-Type: application/json
        response.setHeader("content-type", "application/json");     //  응답으로 JSON을 반환할 경우 content-type을 application/json으로 지정
        response.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();
        data.setUsername("kim");
        data.setAge(20);
        //{"username":"kim","age":20}

        String result = objectMapper.writeValueAsString(data);      //  JACKSON 라이브러리가 제공하는 writeValueAsString 메소드로 객체를 JSON 문자로 변경할 수 있다.
        response.getWriter().write(result);

    }
}
