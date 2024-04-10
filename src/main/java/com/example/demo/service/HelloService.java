package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.req.ArticleCreateRequest;
import com.example.demo.dto.res.ArticleCreateResponse;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class HelloService {

	private final ArticleRepository articleRepository;

	@Transactional
	public ArticleCreateResponse createArticle(ArticleCreateRequest req) {
		try {
			Article article = new Article();
			article.setTitle(req.getTitle());
			article.setContent(req.getContent());

			article = articleRepository.save(article);  // Make sure to reassign to capture the returned persisted entity

			log.info("저장된 게시글의 pk 받아오기: {}", article.getArticleId());  // Use getArticleId() instead of getId()
			return new ArticleCreateResponse(ArticleCreateResponse.SUCCESS_CODE, ArticleCreateResponse.SUCCESS_MSG);
		} catch (Exception e) {
			log.error("게시글 저장 실패: {}", e.getMessage());
			return new ArticleCreateResponse(ArticleCreateResponse.FAILURE_CODE, ArticleCreateResponse.FAILURE_MSG);
		}
	}
}
