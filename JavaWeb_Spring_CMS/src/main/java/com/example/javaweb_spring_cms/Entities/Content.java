package com.example.javaweb_spring_cms.Entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "content", schema = "cms", catalog = "")
public class Content {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cid")
    private int cid;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "brief")
    private String brief;
    @Basic
    @Column(name = "body")
    private String body;
    @ManyToOne
    @JoinColumn(name = "id")
    private Member member;
    @Basic
    @Column(name = "createdate")
    private Date createdate;
    @Basic
    @Column(name = "updatetime")
    private Date updatetime;

    public Content(String title, String brief, String body, Member member, Date createdate, Date updatetime) {
        this.title = title;
        this.brief = brief;
        this.body = body;
        this.member = member;
        this.createdate = createdate;
        this.updatetime = updatetime;
    }

    public Content(String title, String brief, String body, Member member, Date createdate) {
        this.title = title;
        this.brief = brief;
        this.body = body;
        this.member = member;
        this.createdate = createdate;
    }

    public Content() {

    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content that = (Content) o;

        if (cid != that.cid) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (createdate != null ? !createdate.equals(that.createdate) : that.createdate != null) return false;
        if (updatetime != null ? !updatetime.equals(that.updatetime) : that.updatetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        result = 31 * result + (updatetime != null ? updatetime.hashCode() : 0);
        return result;
    }

}
