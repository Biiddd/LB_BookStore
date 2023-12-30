

package com.yami.shop.bean.enums;

/**
 * 商品规格参数、属性类型
 * @ lgh
 */
public enum ProdPropRule {

	// 规格属性 (用于商品商品发布时，关联sku)
	SPEC(1),
	
	// 规格参数(用于商品搜索时，与分类关联搜索)
	ATTRIBUTE(2);
	
	private Integer num;
	
	public Integer value() {
		return num;
	}
	
	ProdPropRule(Integer num){
		this.num = num;
	}
	
	public static ProdPropRule instance(Integer value) {
		ProdPropRule[] enums = values();
		for (ProdPropRule statusEnum : enums) {
			if (statusEnum.value().equals(value)) {
				return statusEnum;
			}
		}
		return null;
	}
}
