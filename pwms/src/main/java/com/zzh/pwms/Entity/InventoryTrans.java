package com.zzh.pwms.Entity;

import lombok.Data;

@Data
public class InventoryTrans extends MerchantsInventory{
    //多一个supplierName和paintName
    private String supplierName;
    private String paintName;
    private Integer userId;
}
