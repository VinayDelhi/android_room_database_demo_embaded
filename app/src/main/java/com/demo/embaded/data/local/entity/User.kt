package com.demo.embaded.data.local.entity

import androidx.room.*

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo
    var companyName: String,

    @Ignore
    var isSelected: Boolean = false,

    /**
     *
     * If Address Pojo is not annotated with @Entry
     * than @Embaded annotation will create more column
     * as number of variable in Address obj.
     * */

    @Embedded
    var address: Address?

)

{
    constructor():this(0, "", "", false,Address(city = "",country = "",code = 0))
}