package bassem.udacity.session4.ui.words

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import bassem.udacity.session4.R
import bassem.udacity.session4.WordsApplication
import bassem.udacity.session4.databinding.FragmentWordsBinding
import bassem.udacity.session4.ui.WordViewModelFactory
import bassem.udacity.session4.ui.WordsViewModel

class WordsFragment : Fragment() {

    private val viewModel: WordsViewModel by viewModels {
        WordViewModelFactory((requireActivity().application as WordsApplication).repository)
    }

    private var _binding: FragmentWordsBinding? = null
    private lateinit var adapter: WordAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWordsBinding.inflate(inflater, container, false)

        adapter = WordAdapter()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel.words.observe(viewLifecycleOwner){
                adapter.submitList(it)
            }
            fab.setOnClickListener {
                findNavController().navigate(R.id.action_WordsFragment_to_AddWordFragment)
            }

            recyclerviewWords.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}