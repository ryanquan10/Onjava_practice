//import Make;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

public class DemoApplicationTests {
//	@Rule
//	public final StandardOuptuptStreamLog log =new StandardOuptuptStreamLog();
	@Autowired
      private Make make;

	@Test
	public void contextLoads() {
		make.getDesssert();

	}




}
