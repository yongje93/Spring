package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJuk sungJuk = (SungJuk) context.getBean("sungJukImpl");
		sungJuk.calcTot();
		sungJuk.calcAvg();
		sungJuk.display();
		
		System.out.println("\n수정");
		sungJuk.modify();
		sungJuk.calcTot();
		sungJuk.calcAvg();
		sungJuk.display();
		
		((AbstractApplicationContext) context).close();
	}

}
