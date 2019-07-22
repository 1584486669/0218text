package com.example.text;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.example.text.mapper")
@SpringBootApplication
public class TextApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextApplication.class, args);
	}

}
