package cn.e3mall.po;

import java.util.Date;

/**
 * ��Ʒ������
 * 
 * @author wcyong
 * 
 * @date 2020-06-11
 */
public class TbItemDesc {
    /**
     * ��ƷID
     */
    private Long itemId;

    /**
     * ��Ʒ����
     */
    private String itemDesc;

    /**
     * ����ʱ��
     */
    private Date created;

    /**
     * ����ʱ��
     */
    private Date updated;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
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