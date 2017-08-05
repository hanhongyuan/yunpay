package com.yunpay.serv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.yunpay.database.dao.BaseDao;
import com.yunpay.serv.model.RefundTranLs;

@Repository("refundTranLsDao")
public interface RefundTranLsDao extends BaseDao<RefundTranLs>{
	@Select("select * from t_refund_tran_ls where userRefundNo=#{userRefundNo} and merchantNo=#{merchantNo}")
	public RefundTranLs findLsByUserRefundNo(@Param("userRefundNo")String userRefundNo,@Param("merchantNo")String merchantNo);
	
	@Update("update t_refund_tran_ls set status=#{status} where id=#{id}")
	public int updRefundTranStatus(@Param("id")Integer id, @Param("status")Integer status);
	
	@Select("select * from t_refund_tran_ls where transNum=#{transNum}")
	public RefundTranLs findRefundLsByTransNum(String transNum);
	
	@Select("select * from t_refund_tran_ls t where  (t.status=1 or t.status=0) AND date_add(t.transTime, interval #{intervalTime} minute) > now() ")
	List<RefundTranLs> selectAllSynRefundLs(@Param("intervalTime")Integer intervalTime);
}
