package com.yhp.studybbs.interceptors;

import com.yhp.studybbs.entities.BoardEntity;
import com.yhp.studybbs.services.BoardService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonInterceptor implements HandlerInterceptor {
    @Resource
    private BoardService boardService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getMethod().equalsIgnoreCase("GET") && !request.getMethod().equalsIgnoreCase("POST")) {
            return true;
        }
        BoardEntity[] boards = this.boardService.getBoards();
        request.setAttribute("boards", boards);
        return true;
    }
}