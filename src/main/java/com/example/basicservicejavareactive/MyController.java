package com.example.basicservicejavareactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class MyController {

	static WebClient webClient = WebClient.create("http://localhost:8090/task");

	@GetMapping(value = "/basic-java-reactive")
	public Mono<Boolean> run() {
		return webClient.get().retrieve().bodyToMono(Boolean.class);
	}
}
