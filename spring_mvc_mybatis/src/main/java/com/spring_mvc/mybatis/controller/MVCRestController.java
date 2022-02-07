package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_mvc.mybatis.model.ProductVO;
import com.spring_mvc.mybatis.service.ProductService;

@RestController 
public class MVCRestController {
	@Autowired
	ProductService service;
	
	//상품 검색3
	@RequestMapping("/product/productSearch3")
	public ArrayList<ProductVO> productSearch3(@RequestParam HashMap<String, Object> param, 
																			    Model model){
		System.out.println("a");
		ArrayList<ProductVO> prdList = service.productSearch(param);
		model.addAttribute("prdList", prdList);	
		
		// prdList로 제대로 반화되었는지 확인하기 위한 코드
		for(int i =0; i < prdList.size(); i++) {
			ProductVO prd = (ProductVO) prdList.get(i);
			System.out.println(prd.getPrdNo());
		}
		
		return prdList;
	}
	
}
