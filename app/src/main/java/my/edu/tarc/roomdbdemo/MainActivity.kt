package my.edu.tarc.roomdbdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import my.edu.tarc.roomdbdemo.data.Adapter
import my.edu.tarc.roomdbdemo.data.Product
import my.edu.tarc.roomdbdemo.data.ProductDB
import my.edu.tarc.roomdbdemo.data.ProductDao

class MainActivity : AppCompatActivity() {

    lateinit var dao: ProductDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dao = ProductDB.getInstance(application).productDao

        val btnInsert :Button = findViewById(R.id.btnInsert)
        btnInsert.setOnClickListener(){

            val name :String  = findViewById<TextView>(R.id.tfName).text.toString()
            val price:Double =  findViewById<TextView>(R.id.tfPrice).text.toString().toDouble()

            val p = Product(0, name, price)

            CoroutineScope(IO).launch {
                dao.insert(p)
            }

        }
        val btnGet:Button=findViewById(R.id.btnGet)
        btnGet.setOnClickListener(){

            CoroutineScope(IO).launch {
                val productList: List<Product> = dao.getAll()
                //val productList = dao.getAll()
                /*val productList:List<Product> = dao.getPriceBelow(1000.00)

                var nameList = ""
                for(product:Product in productList){

                    nameList += product.name +"\n"

                }
                 */
                CoroutineScope(Dispatchers.Main).launch {
                    //val tvResult: TextView = findViewById(R.id.tvResult)

                    //tvResult.text = nameList
                    val productAdapter = Adapter(productList)
                    val recycleView : RecyclerView = findViewById(R.id.productRecycleView)
                    recycleView.adapter = productAdapter
                    recycleView.setHasFixedSize(true)
                }
            }
        }
    }
}