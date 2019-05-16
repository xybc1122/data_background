package com.dt.project.store;

import com.dt.project.model.FinancialSalesBalance;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @ClassName FsbStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/12 14:20
 **/
public class FsbStore {


    /**
     * 判断TypeName 是否== xxxxx  计算一些数据
     */
    public static void setInfo(String typeName, FinancialSalesBalance fsb) {
        if (StringUtils.isNotEmpty(typeName)) {
            //促销费用（abs(运费)<abs(促销费用)）
            //返回值 -1 小于 0 等于 1 大于
            if (fsb.getShippingCredits().abs().compareTo(fsb.getPromotionalRebates().abs()) < 0) {
                fsb.setNewPromotionalRebates(fsb.getShippingCredits().add(fsb.getPromotionalRebates()));
            }
            //促销费用（abs(运费)>abs(促销费用)）
            if (fsb.getShippingCredits().abs().compareTo(fsb.getPromotionalRebates().abs()) > 0) {
                fsb.setNewShippingCredits(fsb.getShippingCredits());
                fsb.setNewPromotionalRebates(fsb.getPromotionalRebates());
            }
            //促销费用（abs(运费)=abs(促销费用)）
            if (fsb.getShippingCredits().abs().compareTo(fsb.getPromotionalRebates().abs()) == 0) {
                fsb.setNewShippingCredits(new BigDecimal(0.0));
                fsb.setNewPromotionalRebates(new BigDecimal(0.0));
            }
            if (fsb.getNewShippingCredits() == null) {
                fsb.setNewShippingCredits(new BigDecimal(0.0));
            }
            if (fsb.getFbaFee() == null) {
                fsb.setFbaFee(new BigDecimal(0.0));
            }
            fsb.setNewShippingFba(fsb.getNewShippingCredits().add(fsb.getFbaFee()));
            if (!typeName.equals("退货")) {
                fsb.setQuantity(fsb.getoQuantity());
            }
            if (typeName.equals("服务费")) {
                fsb.setServiceFee(fsb.getOtherTransactionFees());
            } else if (typeName.equals("转账")) {
                fsb.setTransfer(fsb.getTotal());
            } else if (typeName.equals("调整")) {
                fsb.setAdjustment(fsb.getOther());
                fsb.setAdjustmentQty(fsb.getoQuantity());
            } else if (typeName.equals("库存费")) {
                fsb.setFbaInventoryFee(fsb.getOther());
            } else if (typeName.equals("秒杀费")) {
                fsb.setLightningDealFee(fsb.getOtherTransactionFees());
            } else if (typeName.equals("退货")) {
                fsb.setRefundQuantity(fsb.getoQuantity());
            } else if (typeName.equals("订单")) {
                fsb.setOrderQty(fsb.getoQuantity());
            }
        } else {
            fsb.setQuantity(fsb.getoQuantity());
        }
    }

    /**
     * 设置广告税
     */
    public static void setAdTax(FinancialSalesBalance fsb) {
        System.out.println(StringUtils.isNotBlank(fsb.getDescription()));

        System.out.println(StringUtils.isNotBlank(fsb.getType()));

        System.out.println(fsb.getOther() != null);

        System.out.println(fsb.getOther().compareTo(BigDecimal.ZERO) != 0);
        System.out.println(fsb.getOther());

        System.out.println(fsb.getOtherTransactionFees().compareTo(BigDecimal.ZERO) != 0);
        System.out.println(fsb.getOtherTransactionFees());

        if (StringUtils.isNotBlank(fsb.getDescription()) &&
                StringUtils.isNotBlank(fsb.getType()) && fsb.getOther() != null
                && fsb.getOther().compareTo(BigDecimal.ZERO) != 0
                && fsb.getOtherTransactionFees().compareTo(BigDecimal.ZERO) != 0) {
            fsb.setServiceFeeTax(fsb.getOther());
        } else {
            fsb.setServiceFeeTax(new BigDecimal(0));
        }
    }

    /**
     * 计算
     *
     * @param fsb
     */
    public static void calculation(FinancialSalesBalance fsb) {
        //判断为空 设为0
        FinancialSalesBalance balance = conversionDecimal(fsb);
        BigDecimal resultFotTax = forTaxResult(balance);
        //设置 税前销售额
        balance.setSalesForTax(resultFotTax);
        BigDecimal resultVat = resultFotTax.subtract(balance.getSales());
        balance.setVat(resultVat);
        //更新 新其他
        balance.setNewOther(balance.getOther().subtract(balance.getServiceFeeTax()));

    }

    /**
     * 设置 setSalesForTax 计算结果
     *
     * @param balance
     */
    public static BigDecimal forTaxResult(FinancialSalesBalance balance) {
        return balance.getTotal().subtract(balance.getShippingCredits().add(balance.getGiftwrapCredits()).
                add(balance.getPromotionalRebates()).add(balance.getSalesTax()).add(balance.getMarketplaceFacilitatorTax()).
                add(balance.getSellingFees()).add(balance.getFbaFee()).add(balance.getOtherTransactionFees()).add(balance.getOther()).
                add(balance.getPointFee()).add(balance.getLowValueGoods()));
    }

    public static FinancialSalesBalance conversionDecimal(FinancialSalesBalance fsb) {
        if (fsb.getTotal() == null) {
            fsb.setTotal(new BigDecimal(0));
        }
        if (fsb.getSales() == null) {
            fsb.setSales(new BigDecimal(0));
        }
        if (fsb.getShippingCredits() == null) {
            fsb.setShippingCredits(new BigDecimal(0));
        }
        if (fsb.getGiftwrapCredits() == null) {
            fsb.setGiftwrapCredits(new BigDecimal(0));
        }
        if (fsb.getGiftwrapCredits() == null) {
            fsb.setGiftwrapCredits(new BigDecimal(0));
        }
        if (fsb.getPromotionalRebates() == null) {
            fsb.setPromotionalRebates(new BigDecimal(0));
        }
        if (fsb.getSalesTax() == null) {
            fsb.setSalesTax(new BigDecimal(0));
        }
        if (fsb.getMarketplaceFacilitatorTax() == null) {
            fsb.setMarketplaceFacilitatorTax(new BigDecimal(0));
        }
        if (fsb.getSellingFees() == null) {
            fsb.setSellingFees(new BigDecimal(0));
        }
        if (fsb.getFbaFee() == null) {
            fsb.setFbaFee(new BigDecimal(0));
        }
        if (fsb.getOtherTransactionFees() == null) {
            fsb.setOtherTransactionFees(new BigDecimal(0));
        }
        if (fsb.getOther() == null) {
            fsb.setOther(new BigDecimal(0));
        }
        if (fsb.getPointFee() == null) {
            fsb.setPointFee(new BigDecimal(0));
        }
        if (fsb.getLowValueGoods() == null) {
            fsb.setLowValueGoods(new BigDecimal(0));
        }
        return fsb;
    }
}
