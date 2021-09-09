package my.edu.tarc.roomdbdemo.data



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import my.edu.tarc.roomdbdemo.R

class Adapter(private val productList: List<Product>) : RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val productName : TextView = itemView.findViewById(R.id.tvName)
        val productPrice  : TextView = itemView.findViewById(R.id.tvPrice)
        val productNo : TextView = itemView.findViewById(R.id.tvNo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.product_itemlist,parent,false)

        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentProduct = productList[position]
        holder.productName.text = currentProduct.name
        holder.productPrice.text = currentProduct.price.toString()
        holder.productNo.text= currentProduct.id.toString()
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}