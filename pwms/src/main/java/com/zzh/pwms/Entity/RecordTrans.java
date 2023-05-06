package com.zzh.pwms.Entity;

import lombok.Data;

@Data
public class RecordTrans extends Record{
    //多一个userName和paintName
    private String userName;
    private String paintName;
}
