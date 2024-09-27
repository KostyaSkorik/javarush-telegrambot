package com.github.javarushcommunity.javarush_telegrambot.javarushclient.dto;


import lombok.Data;

@Data
public class GroupInfo {
    private Integer id;
    private String avatarUrl;
    private String createTime;
    private String key;
    private Integer levelToEditor;
    private MeGroupInfo meGroupInfo;
    private String pictureUrl;
    private String title;
    private GroupInfoType type;
    private Integer userCount;
    private GroupVisibilityStatus visibilityStatus;
}
