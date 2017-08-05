package com.yunpay.permission.entity;

/**
 * 字典基类
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */

public class DictcodeEntity extends PermissionBaseEntity{
    
	private static final long serialVersionUID = 1L;
	private Integer sid;            //编号
    private String typeCode;        //引用键值
    private String typeName;        //所属分类
    private String typeId;          //类别id
    private String remark;          //
    private String orderNo;         //
    
    public Integer getSid() {
        return sid;
    }
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    
    public String getTypeCode() {
        return typeCode;
    }
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getTypeId() {
        return typeId;
    }
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }    
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
}
