package ir.alirahimi.hilt.room

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.alirahimi.hilt.databinding.ItemRecyclerBinding
import ir.alirahimi.hilt.room.db.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserAdapter @Inject constructor() : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var binding: ItemRecyclerBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            binding.title.text = "${user.id} - ${user.name}"

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(user)
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    private var onItemClickListener: ((User) -> Unit)? = null

    fun setOnItemClickListener(listener: ((User) -> Unit)) {
        onItemClickListener = listener
    }
}