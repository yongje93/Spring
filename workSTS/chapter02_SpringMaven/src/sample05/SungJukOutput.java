package sample05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.conf")
public class SungJukOutput implements SungJuk {
	@Qualifier("list")
	@Autowired
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		System.out.println("\n이름\t국어\t영어\t수학\t총점\t평균");
		for (SungJukDTO2 sungJukDTO2 : list) {
			System.out.println(sungJukDTO2);
		}
	}

}