/*
 * Copyright (c) 2018-2999 广州市蓝海创新科技有限公司 All rights reserved.
 *
 * https://www.mall4j.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.yami.shop.bean.app.param;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @ lanhai
 */
@Schema(description = "购物车参数")
@Data
public class ShopCartParam {

    @Schema(description = "购物项id" )
    private Long basketId;

    @Schema(description = "活动id,传0则不参与该活动" )
    private Long discountId;
}
