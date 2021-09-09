package my.edu.tarc.roomdbdemo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName= "product_table")
data class Product (

    @PrimaryKey(autoGenerate = true)
    var id:Int=0,

    @ColumnInfo
    var name:String,

    @ColumnInfo
    var price:Double
)

