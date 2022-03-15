package com.zhuzhu.mobile.bean;
/**
 * 编号4
 */
public class ListBean {
    private String type;
    private ListDataBean data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ListDataBean getData() {
        return data;
    }

    public void setData(ListDataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListBean{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
