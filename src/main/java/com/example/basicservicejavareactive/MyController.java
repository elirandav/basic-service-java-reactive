package com.example.basicservicejavareactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class MyController {

	@GetMapping(value = "/basic-java-reactive")
	public Mono<Boolean> rule() {
		System.out.println("got request " + threadName());
		System.out.println("start sleep request " + threadName());
		WebClient webClient = WebClient.create("http://localhost:8090/task");
		Mono<Boolean> booleanMono = webClient.get().retrieve().bodyToMono(Boolean.class);
		System.out.println("return mono " + threadName());
		return booleanMono;
	}

	private String threadName() {
		return Thread.currentThread().getName();
	}
}
