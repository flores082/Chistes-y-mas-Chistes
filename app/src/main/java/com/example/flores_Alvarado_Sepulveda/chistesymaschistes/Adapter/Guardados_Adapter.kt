import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.DataBase.DataBase
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.Entity.Chiste
import com.example.flores_Alvarado_Sepulveda.chistesymaschistes.R

class Guardados_Adapter(private val chistesList: MutableList<Chiste>, private val context: Context) :
    RecyclerView.Adapter<Guardados_Adapter.ProductoViewHolder>() {

    var baseDatos = Room.databaseBuilder(context, DataBase::class.java, "database").allowMainThreadQueries().build()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_chiste_mostrado, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val item = chistesList[position]
        holder.bin(item, position + 1)
    }

    override fun getItemCount(): Int {
        return chistesList.size
    }

    inner class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textView4)
        val guardar = itemView.findViewById<AppCompatImageButton>(R.id.imageButton)

        fun bin(chiste: Chiste, numeroUnico: Int) {
            val textoMostrado = "${chiste.chisteText} - $numeroUnico"
            textView.text = textoMostrado

            guardar.setOnClickListener {
                val prodDao = baseDatos.productoDao()
                //val newChiste = Chiste(prodDao.getAll().size.toLong() + 1, textoMostrado)
                //prodDao.insertAll(newChiste)
                prodDao.delete(prodDao.findByName(textoMostrado))

            }
        }
    }
}
