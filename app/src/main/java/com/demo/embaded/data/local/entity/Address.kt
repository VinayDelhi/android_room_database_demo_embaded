package com.demo.embaded.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Address(

    @ColumnInfo(name = "city")
    var city: String,

    @ColumnInfo(name = "country")
    var country: String,

    @ColumnInfo(name = "code")
    var code: Int
  )
{

}
