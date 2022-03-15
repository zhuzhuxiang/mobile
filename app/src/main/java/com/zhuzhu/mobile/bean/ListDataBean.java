package com.zhuzhu.mobile.bean;

import java.util.List;

/**
 * 编号5
 */
public class ListDataBean {
    private List<ListAppBean> listApp;

    public List<ListAppBean> getListApp() {
        return listApp;
    }



    public void setListApp(List<ListAppBean> listApp) {
        this.listApp = listApp;
    }

    @Override
    public String toString() {
        return "ListDataBean{" +
                "listApp=" + listApp +
                '}';
    }
}
