package com.delphi.portlet.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;
import java.util.SortedSet;



final public class ProductLine implements Serializable,Comparable<ProductLine> {

	private static final long serialVersionUID = 9147586022297899575L;
	private NameId nameId;
	private SortedSet<ExpenseDetail> expenseDetails;
	private ExpenseDetail total;

	public ExpenseDetail getTotal() {
		return total;
	}

	public void setTotal(ExpenseDetail total) {
		this.total = total;
	}

	private int rpdpId; //always exits

	public NameId getNameId() {
		return nameId;
	}

	public void setNameId(NameId nameId) {
		this.nameId = nameId;
	}


	public SortedSet<ExpenseDetail> getExpenseDetails() {
		return expenseDetails;
	}

	public void setExpenseDetails(SortedSet<ExpenseDetail> expenseDetails) {
		this.expenseDetails = expenseDetails;
	}

	public int getRpdpId() {
		return rpdpId;
	}

	public void setRpdpId(int rpdpId) {
		this.rpdpId = rpdpId;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" ProductLine [");
		sb.append(nameId.toString());
		sb.append("  rpdpId=").append(rpdpId);
		if(total!= null)sb.append("  total =").append(total.toString());
		if(expenseDetails != null){
			for(ExpenseDetail ed : expenseDetails){
				sb.append("\n"+ed.toString());
			}
		}	
		sb.append(" ]");
		return sb.toString();
	}
	
	public JSONObject toJSON(){
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("id", nameId.getId());
		json.put("name", nameId.getName());
		json.put("rpdpId", rpdpId);
		if(total!= null)json.put("total", total.toJSON());
		JSONArray jsonArray  = 	JSONFactoryUtil.createJSONArray();
		if(expenseDetails != null){
			for(ExpenseDetail ed : expenseDetails){
				jsonArray.put(ed.toJSON());
			}
		}	
		json.put("expenseDetails", jsonArray);
		return json;
	}

	@Override
	public int compareTo(ProductLine o) {		
		return this.nameId.compareTo(o.getNameId());
	}

}
