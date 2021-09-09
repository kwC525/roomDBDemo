package my.edu.tarc.roomdbdemo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    fun insert (productDao: Product) //insertProduct

    @Query("SELECT * FROM product_table")
    fun getAll(): List<Product>

    @Query("SELECT * FROM product_table where price< :priceRange")
    fun getPriceBelow(priceRange:Double): List<Product>
}