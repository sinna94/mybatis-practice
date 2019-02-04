package mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.model.service.MyBatisService;

@WebServlet("/mybatis.do")
public class MybatisTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MyBatisService service = new MyBatisService();
	
    public MybatisTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = service.insertStudent();
		String msg = result > 0 ? "입력 완료" : "입력 실패";
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(msg);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
