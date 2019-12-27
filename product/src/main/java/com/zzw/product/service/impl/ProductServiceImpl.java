package com.zzw.product.service.impl;

import com.zzw.product.DTO.CartDTO;
import com.zzw.product.dataobject.ProductInfo;
import com.zzw.product.enums.ProductStatusEnum;
import com.zzw.product.enums.ResultEnum;
import com.zzw.product.exception.ProductException;
import com.zzw.product.repository.ProductInfoRepository;
import com.zzw.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Daydreamer
 * @date 2019/12/19 17:33
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 查询所有在架商品
     *
     * @return
     */
    @Override
    public List<ProductInfo> findUpstageAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 根据订单信息查询商品列表
     *
     * @param productIdList
     * @return
     */
    @Override
    public List<ProductInfo> findProductListForOrder(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    /**
     * 扣库存
     *
     * @param cartDTOList
     */
    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            // 判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PROUDCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            // 判断库存是否还有
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            // 成功扣库存
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
