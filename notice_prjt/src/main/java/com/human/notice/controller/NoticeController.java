package com.human.notice.controller;

import java.text.DateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.human.notice.service.NoticeService;
import com.human.notice.vo.NoticeVO;
import com.human.notice.vo.SearchVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // 1. 공지사항 목록 페이지
    @GetMapping("/list")
    public String getNoticeList(Model model, 
                                @RequestParam(required = false) String searchType,
                                @RequestParam(required = false) String keyword) {
        List<NoticeVO> noticeList;

        // 검색어가 있는 경우 검색
        if (keyword != null && !keyword.isEmpty()) {
            SearchVO searchVO = new SearchVO(searchType, keyword);
            noticeList = noticeService.searchNotices(searchVO);
        } else {
            // 검색어가 없는 경우 전체 목록
            noticeList = noticeService.getNoticeList();
        }
        
        model.addAttribute("noticeList", noticeList);
        return "notice/notice_list"; // notice_list.jsp로 이동
    }

    // 2. 공지사항 작성 페이지
    @GetMapping("/write")
    public String showWriteForm() {
        return "notice/notice_write"; // notice_write.jsp로 이동
    }

    // 3. 공지사항 등록 처리
    @PostMapping("/write")
    public String writeNotice(@ModelAttribute NoticeVO noticeVO) {
        noticeService.insertNotice(noticeVO);
        return "redirect:/notice/list"; // 등록 후 목록으로 리다이렉트
    }
}
