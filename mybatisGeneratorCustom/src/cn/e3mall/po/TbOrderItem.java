package cn.e3mall.po;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2020-06-11
 */
public class TbOrderItem {
    private String id;

    /**
     * ��Ʒid
     */
    private String itemId;

    /**
     * ����id
     */
    private String orderId;

    /**
     * ��Ʒ��������
     */
    private Integer num;

    /**
     * ��Ʒ����
     */
    private String title;

    /**
     * ��Ʒ����
     */
    private Long price;

    /**
     * ��Ʒ�ܽ��
     */
    private Long totalFee;

    /**
     * ��ƷͼƬ��ַ
     */
    private String picPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }
}