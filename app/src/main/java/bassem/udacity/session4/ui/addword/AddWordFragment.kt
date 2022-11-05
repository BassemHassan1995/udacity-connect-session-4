package bassem.udacity.session4.ui.addword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import bassem.udacity.session4.R
import bassem.udacity.session4.WordsApplication
import bassem.udacity.session4.databinding.FragmentAddWordBinding
import bassem.udacity.session4.model.Word
import bassem.udacity.session4.ui.WordViewModelFactory
import bassem.udacity.session4.ui.WordsViewModel

class AddWordFragment : Fragment() {

    private val viewModel: WordsViewModel by viewModels {
        WordViewModelFactory((requireActivity().application as WordsApplication).repository)
    }

    private var _binding: FragmentAddWordBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddWordBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonSave.setOnClickListener {
                val word = edittextWord.text.toString()
                if (word.isNotBlank()) {
                    viewModel.addWord(Word(value = word))
                    findNavController().navigate(R.id.action_AddWordFragment_to_WordsFragment)
                }
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}