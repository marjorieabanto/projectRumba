import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectrumba.R

class DeviceAdapter (private val ipAddresses: List<String>) : RecyclerView.Adapter<DeviceAdapter.IPViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IPViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_device_near, parent, false)
        return IPViewHolder(view)
    }

    override fun onBindViewHolder(holder: IPViewHolder, position: Int) {
        val addresses = ipAddresses[position]
        holder.ipTextView.text = addresses.toString();
    }

    override fun getItemCount(): Int {
        return ipAddresses.size
    }

    class IPViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ipTextView: TextView = view.findViewById(R.id.ipText)
    }
}
