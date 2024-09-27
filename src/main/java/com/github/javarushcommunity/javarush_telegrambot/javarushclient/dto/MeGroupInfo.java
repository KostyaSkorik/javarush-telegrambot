package com.github.javarushcommunity.javarush_telegrambot.javarushclient.dto;

import lombok.Data;

@Data
public class MeGroupInfo {
    private MeGroupInfoStatus status;
    private Integer userGroupId;
}
