package com.human.notice.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.notice.vo.NoticeVO;
import com.human.notice.vo.SearchVO;

@Repository
public class NoticeDAO {

    private final SqlSession sqlSession;

    @Autowired
    public NoticeDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public static final String MAPPER = "com.human.notice.mapper.NoticeMapper";

    // 공지사항 전체 목록 조회
    public List<NoticeVO> selectAllNotices() {
        return sqlSession.selectList(MAPPER + ".selectAllNotices");
    }

    // 검색된 공지사항 조회
    public List<NoticeVO> searchNotices(SearchVO searchVO) {
        return sqlSession.selectList(MAPPER + ".searchNotices", searchVO);
    }

    // 공지사항 상세 조회 (ID로 조회)
    public NoticeVO selectNoticeById(int n_idx) {
        return sqlSession.selectOne(MAPPER + ".selectNoticeById", n_idx);
    }
}