package com.suit.interfaces.controller;

import com.suit.interfaces.service.SuitService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class SuitController {

    @Resource
    private SuitService suitService;

    public static void main(String[] args) {
    }

}
