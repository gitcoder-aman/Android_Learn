package com.example.practicews.Model;

import java.util.List;

public class InstagramItemDetailModel {

    private String code;

    public InstagramItemDetailModel(String code) {
        this.code = code;
    }

    public InstagramItemDetailModel() {
    }
//    private List<InstagramVideoList> video_versions;

    public String getVideoCode() {
        return code;
    }

    public void setVideoCode(String videoCode) {
        this.code = code;
    }

//    public List<InstagramVideoList> getVideo_versions() {
//        return video_versions;
//    }
//
//    public void setVideo_versions(List<InstagramVideoList> video_versions) {
//        this.video_versions = video_versions;
//    }
}
