package com.zhuzhu.mobile.bean;

import java.util.List;

/**
 *  编号3
 */
public class FeaturedBean {
    private String sid;
    private boolean hasMore;
    private List<ListBean> list;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "FeaturedBean{" +
                "sid='" + sid + '\'' +
                ", hasMore=" + hasMore +
                ", list=" + list +
                '}';
    }
}
