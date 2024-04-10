package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.req.ArticleCreateRequest;
import com.example.demo.dto.res.ArticleCreateResponse;
import com.example.demo.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {

	private final HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@PostMapping("/article/create")
	public ArticleCreateResponse createArticle(@RequestBody ArticleCreateRequest req) {
		log.info("게시글 작성 요청 받음: {}", req);
		return helloService.createArticle(req);
	}
}
