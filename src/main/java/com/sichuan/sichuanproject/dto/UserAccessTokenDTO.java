package com.sichuan.sichuanproject.dto;

import lombok.Data;

/**
 * @author
 */

@Data
public class UserAccessTokenDTO {
    private String access_token;
    private String token_type;
    private Integer expires_in;
    private String refresh_token;
}
