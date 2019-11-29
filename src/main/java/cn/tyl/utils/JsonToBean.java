package cn.tyl.utils;

import cn.tyl.bean.Video;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonToBean {
    public static Video toVideo(JsonNode vidoeNode){

        Video video = new Video();
        video.setAid(Integer.parseInt(vidoeNode.get("aid").toString()));
        video.setTypeid(vidoeNode.get("typeid").toString());
        video.setTypename(vidoeNode.get("typename").toString());
        video.setTitle(vidoeNode.get("title").toString());
        video.setSubtitle(vidoeNode.get("subtitle").toString());
        video.setPlay(vidoeNode.get("play").toString());
        video.setReview(vidoeNode.get("review").toString());
        video.setFavorites(vidoeNode.get("favorites").toString());
        video.setCredit(vidoeNode.get("credit").toString());
        video.setCoins(vidoeNode.get("coins").toString());
        video.setMid(vidoeNode.get("mid").toString());
        video.setAuthor(vidoeNode.get("author").toString());
        video.setLink(vidoeNode.get("link").toString());
        video.setCreateTime(vidoeNode.get("create").toString());
        video.setVideoReview(vidoeNode.get("video_review").toString());
        video.setDuration(vidoeNode.get("duration").toString());
        video.setPic(vidoeNode.get("pic").toString());
        video.setStatus(vidoeNode.get("status").toString());
        video.setDescription(vidoeNode.get("description").toString());


       return video;
    }

}
