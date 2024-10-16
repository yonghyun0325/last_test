package com.human.notice.vo;

public class SearchVO {
    private String searchType;
    private String keyword;

    public SearchVO() {}

    public SearchVO(String searchType, String keyword) {
        this.searchType = searchType;
        this.keyword = keyword;
    }

    // Getters and Setters
    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
