package bassem.udacity.session4.ui.words

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bassem.udacity.session4.databinding.WordItemBinding
import bassem.udacity.session4.model.Word

class WordAdapter : ListAdapter<Word, WordAdapter.ViewHolder>(WordDiffCallback()) {

    class ViewHolder private constructor(val binding: WordItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Word) {
            binding.textviewWord.text = item.value
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = WordItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class WordDiffCallback : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.value == newItem.value
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem == newItem
    }

}