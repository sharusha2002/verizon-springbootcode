package com.verizon.springbootjdbc;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class TestController {

	@GetMapping("/name")
	Mono<String> getName(){
		return Mono.just("sharusha");
	}
	
	@GetMapping("/names")
	Flux<Student> getNames(){
//		return Flux.just("sharusha", "Meha", "Sandy").delayElements(Duration.ofMillis(1000));
		return Flux.just(
				new Student(10, "Sharusha"),
				new Student(20, "MEha"),
				new Student(30, "Sandhiya"),
				new Student(40, "Ranjith"))
				.delayElements(Duration.ofMillis(1000));
	}
	
	private record Student(int id, String name) {}
}
