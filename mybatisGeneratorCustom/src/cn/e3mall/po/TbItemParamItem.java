package cn.e3mall.po;

import java.util.Date;

/**
 * ��Ʒ������Ʒ�Ĺ�ϵ��
 * 
 * @author wcyong
 * 
 * @date 2020-06-11
 */
public class TbItemParamItem {
    private Long id;

    /**
     * ��ƷID
     */
    private Long itemId;

    /**
     * �������ݣ���ʽΪjson��ʽ
     */
    private String paramData;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}