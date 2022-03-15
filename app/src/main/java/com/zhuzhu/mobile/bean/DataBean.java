package com.zhuzhu.mobile.bean;

import java.util.List;

/**
 * 第一个数据类，分为两个Bean  2
 */
public class DataBean {
    private FeaturedBean featured;
    private List<BannersBean> banners;

    public FeaturedBean getFeatured() {
        return featured;
    }

    public void setFeatured(FeaturedBean featured) {
        this.featured = featured;
    }

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }
}
