package org.o2.registersvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o2.registersvc.beans.ErrorBean;
import org.o2.registersvc.beans.RegisterServletRes;
import org.o2.registersvc.builder.RegisterServletReqBuilder;
import org.o2.registersvc.client.beans.RegisterSvcWebReq;
import org.o2.registersvc.client.beans.RegisterSvcWebRes;
import org.o2.registersvc.client.exception.ApplicationExceptions;
import org.o2.registersvc.client.impl.RegisterSvcClientImpl;

public class RegisterServlet extends HttpServlet {
	String page = "result.jsp";

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RegisterSvcWebRes webRes = null;
		try {
			// Prepare Req for ServiceClient
			RegisterServletReqBuilder reqBuilder = new RegisterServletReqBuilder();
			RegisterSvcWebReq webReq = new RegisterSvcWebReq();

			// Call Client by passing webReq
			RegisterSvcClientImpl clientImpl = new RegisterSvcClientImpl();

			webRes = clientImpl.enrollment(webReq);

		} catch (ApplicationExceptions e) {
			page = "error.jsp";
			ErrorBean errorBean = new ErrorBean();
			errorBean.setRespCode(e.getRespCode());
			errorBean.setRespMsg(e.getRespMsg());

			webRes.setRespCode(errorBean.getRespCode());
			webRes.setRespMsg(errorBean.getRespMsg());
		}
		req.setAttribute("webRes", webRes);
		req.getRequestDispatcher("page").forward(req, resp);
	}
}
