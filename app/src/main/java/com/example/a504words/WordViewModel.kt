package com.example.a504words

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.a504words.data.Words


class WordViewModel : ViewModel() {

    private val words = Words.wordsArrays
    private var currentWord = words.words[0]

    fun prevWord(wordTv: TextView, wordTranslateTv: TextView, wordNumberTv: TextView) {
        //** get index from words array minus 1 **//
        val currentIndex = words.words.indexOf(currentWord)
        val index = if (currentIndex > 0) currentIndex - 1 else 503
        setCurrentWord(index)

        //** find word in words array with index **//
        wordTv.text = words.words.elementAt(index)
        wordTranslateTv.text = words.persianTranslate.elementAt(index)
        wordNumberTv.text = (index + 1).toString()
    }

    fun nextWord(wordTv: TextView, wordTranslateTv: TextView, wordNumberTv: TextView) {
        //** get index from words array plus 1 **//
        val currentIndex = words.words.indexOf(currentWord)
        val index = if (currentIndex < 503) currentIndex + 1 else 0
        setCurrentWord(index)

        //** find word in words array with index **//
        wordTv.text = words.words.elementAt(index)
        wordTranslateTv.text = words.persianTranslate.elementAt(index)
        wordNumberTv.text = (index + 1).toString()
    }

    //** find current showing word **//
    private fun setCurrentWord(index: Int) {
        currentWord = words.words.elementAt(index)
    }

    //** open google translate website and get word translate **//
    fun goToGoogleTranslate(word: String,context: Context) {
        val url = "https://translate.google.com/?sl=auto&tl=fa&text=${word}%0A&op=translate"
        val uri: Uri = Uri.parse(url)

        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(context,intent,null)
    }

//    fun showDialog(context: Context) {
//
//        val dialog = Dialog(context)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setCancelable(true)
//        dialog.setContentView(R.layout.menu_dialog)
//        dialog.show()
//
//        val savedWords = dialog.findViewById<Button>(R.id.savedWordsButton)
//        val remainWords = dialog.findViewById<Button>(R.id.remainWordsButton)
//    }

}