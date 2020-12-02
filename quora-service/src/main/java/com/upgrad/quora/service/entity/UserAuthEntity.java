package com.upgrad.quora.service.entity;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.ZonedDateTime;

@Entity
@Table(name = "user_auth",schema = "quora")
@NamedQueries({
        @NamedQuery(name = "userAuthTokenByAccessToken",query = "select u from UserAuthEntity u where u.accessToken " +
                "=: accessToken"),
        @NamedQuery(name = "userAuthTokenByUuid",query = "select u from UserAuthEntity u where u.uuid " +
                "=: uuid")
})
public class UserAuthEntity implements Serializable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "uuid")
    @NotNull
    @Max(200)
    private String uuid;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "user_id")
    @NotNull
    private UserEntity userId;

    @Column(name = "access_token")
    @NotNull
    @Max(500)
    private String accessToken;


    @Column(name = "expires_at")
    @NotNull
    private ZonedDateTime expiresAt;

    @Column(name = "login_at")
    @NotNull
    private ZonedDateTime loginAt;


    @Column(name = "logout_at")
    private ZonedDateTime logoutAt;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public ZonedDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(ZonedDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public ZonedDateTime getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(ZonedDateTime loginAt) {
        this.loginAt = loginAt;
    }

    public ZonedDateTime getLogoutAt() {
        return logoutAt;
    }

    public void setLogoutAt(ZonedDateTime logoutAt) {
        this.logoutAt = logoutAt;
    }


    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
