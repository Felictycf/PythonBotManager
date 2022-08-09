package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 自动化记录对象 even
 * 
 * @author ruoyi
 * @date 2022-08-09
 */
public class Even extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 修改事件编号 */
    private Long id;

    /** 修改前a用户邮箱 */
    @Excel(name = "修改前a用户邮箱")
    private String aBeforeUser;

    /** 修改前a用户密码 */
    @Excel(name = "修改前a用户密码")
    private String aBeforePassword;

    /** 修改前b用户邮箱 */
    @Excel(name = "修改前b用户邮箱")
    private String bBeforeUser;

    /** 修改前b用户密码 */
    @Excel(name = "修改前b用户密码")
    private String bBeforePassword;

    /** 事件触发时间 */
    @Excel(name = "事件触发时间")
    private String evenDate;

    /** 修改后a用户邮箱 */
    @Excel(name = "修改后a用户邮箱")
    private String aAfterUser;

    /** 修改后a用户密码 */
    @Excel(name = "修改后a用户密码")
    private String aAfterPassword;

    /** 修改后b用户邮箱 */
    @Excel(name = "修改后b用户邮箱")
    private String bAfterUser;

    /** 修改后b用户密码 */
    @Excel(name = "修改后b用户密码")
    private String bAfterPassword;

    /** 事件状态 */
    @Excel(name = "事件状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setaBeforeUser(String aBeforeUser) 
    {
        this.aBeforeUser = aBeforeUser;
    }

    public String getaBeforeUser() 
    {
        return aBeforeUser;
    }
    public void setaBeforePassword(String aBeforePassword) 
    {
        this.aBeforePassword = aBeforePassword;
    }

    public String getaBeforePassword() 
    {
        return aBeforePassword;
    }
    public void setbBeforeUser(String bBeforeUser) 
    {
        this.bBeforeUser = bBeforeUser;
    }

    public String getbBeforeUser() 
    {
        return bBeforeUser;
    }
    public void setbBeforePassword(String bBeforePassword) 
    {
        this.bBeforePassword = bBeforePassword;
    }

    public String getbBeforePassword() 
    {
        return bBeforePassword;
    }
    public void setEvenDate(String evenDate) 
    {
        this.evenDate = evenDate;
    }

    public String getEvenDate() 
    {
        return evenDate;
    }
    public void setaAfterUser(String aAfterUser) 
    {
        this.aAfterUser = aAfterUser;
    }

    public String getaAfterUser() 
    {
        return aAfterUser;
    }
    public void setaAfterPassword(String aAfterPassword) 
    {
        this.aAfterPassword = aAfterPassword;
    }

    public String getaAfterPassword() 
    {
        return aAfterPassword;
    }
    public void setbAfterUser(String bAfterUser) 
    {
        this.bAfterUser = bAfterUser;
    }

    public String getbAfterUser() 
    {
        return bAfterUser;
    }
    public void setbAfterPassword(String bAfterPassword) 
    {
        this.bAfterPassword = bAfterPassword;
    }

    public String getbAfterPassword() 
    {
        return bAfterPassword;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("aBeforeUser", getaBeforeUser())
            .append("aBeforePassword", getaBeforePassword())
            .append("bBeforeUser", getbBeforeUser())
            .append("bBeforePassword", getbBeforePassword())
            .append("evenDate", getEvenDate())
            .append("aAfterUser", getaAfterUser())
            .append("aAfterPassword", getaAfterPassword())
            .append("bAfterUser", getbAfterUser())
            .append("bAfterPassword", getbAfterPassword())
            .append("status", getStatus())
            .toString();
    }
}
