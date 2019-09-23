package com.thzhima.blog;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thzhima.blog.bean.RegUser;
import com.thzhima.blog.mapper.RegUserMapper;

@SpringBootApplication
public class SbatisApplication implements CommandLineRunner{

	private RegUserMapper mapper;
	
	public static void main(String[] args) {
		SpringApplication.run(SbatisApplication.class, args);
	}

	public SbatisApplication(RegUserMapper mapper) {
		this.mapper = mapper;
		System.out.println("in Constructor, mapper is: " + this.mapper);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//int count = this.mapper.add(new RegUser(null, "谢大侠", "abc","女"));
		//System.out.println("affect : "+count);
//		System.out.println(this.mapper.update("LaLa", "abc", 2));
//		
//		RegUser u = this.mapper.findByID(2);
//		System.out.println(u);
//		
//		List<RegUser> list = this.mapper.listAll();
//		System.out.println(list);
//		System.out.println("===============");
//		System.out.println(this.mapper.list(1));
//		RegUser u =new RegUser();
//		u.setRegName("Xie");
//		u.setPwd("123456");
//		List li = this.mapper.select(u);
//		System.out.println(li);
		
		//System.out.println(this.mapper.list2(new String[] {"wang","Xie"}));
		//this.mapper.updateExample(new RegUser(10,"xie","123456","男"));
		
		RegUser u = new RegUser(12, "Xie", "123", "女");
		System.out.println(this.mapper.insert(u));
	}

}
