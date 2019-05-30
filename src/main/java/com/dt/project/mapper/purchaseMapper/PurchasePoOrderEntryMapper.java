package com.dt.project.mapper.purchaseMapper;

import com.dt.project.model.purchasePo.PurchasePoOrderEntry;

import java.util.List;

import com.dt.project.provider.PurchasePoOrderEntrySqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface PurchasePoOrderEntryMapper {
    @SelectProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "countByExample")
    int countByExample(PurchasePoOrderEntry example);

    @DeleteProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "deleteByExample")
    int deleteByExample(PurchasePoOrderEntry example);

    /**
     * 存入采购订单子表
     *
     * @param record
     * @return
     */
    @InsertProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "insertPoOrderEntry")
    int insertPoOrderEntry(@Param("recordList") List<PurchasePoOrderEntry> record);

    /**
     * 查询  一对多 采购订单表体
     *
     * @param record
     * @return
     */
    @SelectProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "selectByPoOrderEntry")
    @Results({
            @Result(property = "poeRemark", column = "e_remark")
    })
    List<PurchasePoOrderEntry> selectByPoOrderEntry(PurchasePoOrderEntry record);

    @UpdateProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchasePoOrderEntry record);

    @UpdateProvider(type = PurchasePoOrderEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchasePoOrderEntry record);
}