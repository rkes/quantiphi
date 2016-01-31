package quantiphi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.app.db.DBUtils;
import com.app.db.dao.CourseDaoImpl;
public class TestWiring {

	public static void main(String[] args) {
		String configLocation="C:\\Users\\Rakesh\\Desktop\\eclipse_workspaces\\defualt_workspace\\hackerearth\\quantiphi\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		ApplicationContext appContext=new FileSystemXmlApplicationContext(configLocation);
		com.app.util.FileProcessor courseDaoImpl=(com.app.util.FileProcessor)appContext.getBean("fileProcessor",com.app.util.FileProcessor.class);
		//System.out.println(courseDaoImpl.getFileToCourseAdapter().getCourseDao().getDbUtils().getSessionFactory());

	}

}
