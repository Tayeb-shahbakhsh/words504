package com.example.a504words

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a504words.data.Words.wordsArrays
import com.example.a504words.databinding.WordFragmentBinding


class WordFragment : Fragment() {

    private lateinit var binding: WordFragmentBinding
    private lateinit var viewModel: WordViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WordFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        val wordNumberTv = binding.wordNumber
        val wordTv = binding.word
        val wordTranslateTv = binding.wordTranslate
        val prevWordTv = binding.prevWord
        val nextWordTv = binding.nextWord
        val menuButton = binding.menuButton
        val googleTranslateButton = binding.googleTranslateButton

        //** add first index of words array to text view as a start parameter **//
        wordTv.text = wordsArrays.words[0]
        wordTranslateTv.text = wordsArrays.persianTranslate[0]
        wordNumberTv.text = (wordsArrays.words.indexOf(wordTv.text) + 1).toString()

        prevWordTv.setOnClickListener {
            viewModel.prevWord(wordTv,wordTranslateTv,wordNumberTv)
        }

        nextWordTv.setOnClickListener {
            viewModel.nextWord(wordTv,wordTranslateTv,wordNumberTv)
        }

        googleTranslateButton.setOnClickListener {
            viewModel.goToGoogleTranslate(wordTv.text.toString(),requireContext())
        }

//        menuButton.setOnClickListener {
//            viewModel.showDialog(requireContext())
//        }
    }
}