package com.human.notice.service;

import com.human.notice.repository.NoticeDAO;
import com.human.notice.vo.NoticeVO;
import com.human.notice.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDAO noticeDAO;

    @Override
    public List<NoticeVO> getNoticeList() {
        return noticeDAO.selectAllNotices();
    }

    @Override
    public List<NoticeVO> searchNotices(SearchVO searchVO) {
        return noticeDAO.searchNotices(searchVO);
    }

    @Override
    public NoticeVO getNoticeById(int n_idx) {
        return noticeDAO.selectNoticeById(n_idx);
    }
}
