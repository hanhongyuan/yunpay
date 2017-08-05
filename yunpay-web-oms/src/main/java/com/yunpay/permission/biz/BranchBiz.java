package com.yunpay.permission.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yunpay.permission.entity.Branch;
import com.yunpay.permission.entity.BranchTree;
import com.yunpay.permission.entity.LookupBranchTree;
import com.yunpay.permission.entity.TsysAreaTree;
import com.yunpay.permission.service.BranchService;

/**
 * @author System
 * 
 * @since 2013-11-12
 */
@Component("branchBiz")
public class BranchBiz {

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(BranchBiz.class);

	@Autowired
	private BranchService sysMenuService;

	/**
	 * 获取用于编制部门时的树.
	 */
	public List<BranchTree> getTreeBranch(Branch branch) {
		List<Branch> branchList = sysMenuService.listByBranch(branch);
		List<BranchTree> branchTreeList = new ArrayList<BranchTree>();
		for(Branch model : branchList){
			BranchTree branchTree = new BranchTree(model);
			if(model.getChildNum()>0){
				branchTree.setChildBranch(getTreeBranch(model));
			}
			branchTreeList.add(branchTree);
		}
		return branchTreeList;
	}
	
	/**
	 * 拼接部门的页面
	 * @param treeList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public StringBuilder createTreeHtml(List<BranchTree> treeList){
		StringBuilder treeHtml = new StringBuilder();
		if(treeList!=null && treeList.size()>0){
			for(BranchTree branchTree : treeList){
				treeHtml.append("<li data-id="+branchTree.getInstId()+" id=treeId"+ branchTree.getInstId() +" onc data-pid="+branchTree.getInstUp()+" data-url=\"sys/branch/view?instUp="+branchTree.getInstId()+"\" data-callback=\"navTabAjax\" data-divid=\"#layout_branch_list\" data-faicon=\"rss-square\">"+branchTree.getInstName()+"");
				treeHtml.append(createTreeHtml(branchTree.getChildBranch()));
				treeHtml.append("</li>");
			}
			
		}
		return treeHtml;
	}
	
	/**
	 * 获取树形选择数据.
	 */
	public List<LookupBranchTree> lookupBranchTree(Branch branch){
		List<LookupBranchTree> branchTreeList = new ArrayList<LookupBranchTree>();	
		List<Branch> lookupBranchTreeList = sysMenuService.lookupBranchTree(branch);
		for(Branch model : lookupBranchTreeList){
			LookupBranchTree branchTree = new LookupBranchTree(model);
			if(model.getChildNum()>0){
				branchTree.setChildBranch(lookupBranchTree(model));
			}
			branchTreeList.add(branchTree);
		}
		
		return branchTreeList;
	}
	
	/**
	 * 获取部门的树
	 * @param treeList
	 * @return
	 */
	public StringBuilder treeHtml(List<LookupBranchTree> treeList){
		StringBuilder treeHtml = new StringBuilder();
		if(treeList!=null && treeList.size()>0){
			//treeHtml.append("<ul>");
			for(LookupBranchTree branchTree : treeList){
				treeHtml.append("<li data-id="+branchTree.getInstId()+" data-pid="+branchTree.getInstUp()+" ");//<a data-args=\"{}\" data-toggle=\"lookupback\" onclick=\"javascript:branchBringBack({branchId:'");
				/*treeHtml.append(branchTree.getInstId());
				treeHtml.append("', branchName:'");*/
				treeHtml.append("data-url=\"##/view?instUp=");
				if(branchTree.getLongInstName()!=null && !"".equals(branchTree.getLongInstName().trim())){
					treeHtml.append(branchTree.getLongInstName());
					treeHtml.append("-");
				}
				treeHtml.append(branchTree.getInstName());
				treeHtml.append("\">");
				treeHtml.append(branchTree.getInstName());
				/*treeHtml.append("</a>");*/	
				
				treeHtml.append(treeHtml(branchTree.getChildBranch()));
				treeHtml.append("</li>");
			}
		//	treeHtml.append("</ul>");
		}
		return treeHtml;
	}
	
	/**
	 * 拼接区域管理的页面
	 * @param treeList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public StringBuilder createTreeAreaHtml(List<TsysAreaTree> treeList){
		StringBuilder treeHtml = new StringBuilder();
		if(treeList!=null && treeList.size()>0){
			for(TsysAreaTree areaTree : treeList){
				treeHtml.append("<li data-id="+areaTree.getAreaCode()+" data-pid="+areaTree.getParentId()+" data-url=\"sys/area/view?parentId="+areaTree.getAreaCode()+"&areaType="+areaTree.getAreaType()+"\" data-callback=\"navTabAjax\" data-divid=\"#layout_area_list\" data-faicon=\"rss-square\">"+areaTree.getAreaName()+"");
				treeHtml.append(createTreeAreaHtml(areaTree.getChildArea()));
				treeHtml.append("</li>");
			}
			
		}
		return treeHtml;
	}
	
}	