package com.zzw.product.controller;

import com.zzw.product.dto.CartDTO;
import com.zzw.product.dataobject.ProductCategory;
import com.zzw.product.dataobject.ProductInfo;
import com.zzw.product.enums.ResultEnum;
import com.zzw.product.service.CategoryService;
import com.zzw.product.service.ProductService;
import com.zzw.product.vo.ProductInfoVO;
import com.zzw.product.vo.ProductVO;
import com.zzw.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Daydreamer
 * @date 2019/12/19 16:45
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> listProduct() {
        // 查询所有商品
        List<ProductInfo> productInfoList = productService.findUpstageAll();

        // 获取类目的 type 列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        // 从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = new ResultVO<>();
        resultVO.setData(productVOList);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        return resultVO;
    }

    /**
     * 根据订单信息获取商品列表（给订单服务用）
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listProductForOrder")
    public List<ProductInfo> listProductForOrder(@RequestBody List<String> productIdList) {
        return productService.findProductListForOrder(productIdList);
    }

    /**
     * 减库存
     *
     * @param cartDTOList
     */
    @PostMapping("/decreaseStock")
    public void decreaseProductStock(@RequestBody List<CartDTO> cartDTOList) {
        productService.decreaseStock(cartDTOList);
    }
}
