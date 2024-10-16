package com.human.notice.service;

import com.human.notice.vo.NoticeVO;
import com.human.notice.vo.SearchVO;

import java.util.List;

public interface NoticeService {
    List<NoticeVO> getNoticeList(); // 공지사항 목록 가져오기
    List<NoticeVO> searchNotices(SearchVO searchVO); // 공지사항 검색
}