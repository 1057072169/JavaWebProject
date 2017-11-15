package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @ClassName: SuperAction.java
 * @Description: 所有action动作的父类
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年10月29日 上午9:40:57
 */
public class SuperAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, ServletContextAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;// 请求对象
	protected HttpServletResponse response;// 响应对象
	protected HttpSession session;// 会话对象
	protected ServletContext applContext;

	@Override
	public void setServletContext(ServletContext applContext) {
		this.applContext = applContext;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = this.request.getSession();
	}

}
