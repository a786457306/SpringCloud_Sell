package com.zzw.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品类目与商品信息属性
 *
 * @author Daydreamer
 * @date 2019/12/20 10:28
 */

@Data
public class ProductVO {

    /**
     * 设置返回的json属性名称
     */
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
}
