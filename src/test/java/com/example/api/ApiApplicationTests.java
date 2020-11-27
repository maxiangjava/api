package com.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

	@Test
	void contextLoads() {
		Double aa = 12.35;
		Integer bb = aa.intValue();
		System.out.print(bb);
	}

}
