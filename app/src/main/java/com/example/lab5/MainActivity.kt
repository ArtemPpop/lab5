package com.example.lab5

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

  
    private var savedText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_reverse -> {
                showReverseDialog()
                return true
            }
            R.id.action_about -> {
                showAboutDialog()
                return true
            }
            R.id.action_exit -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showAboutDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("About")
            .setMessage("Разработчик: Попов  Артём ")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showReverseDialog() {
        val dialogView = layoutInflater.inflate(R.layout.reverse, null)


        val inputEditText: EditText = dialogView.findViewById(R.id.input_edit_text)
        val upperCaseCheckBox: CheckBox = dialogView.findViewById(R.id.upper_case_check)
        val reverseCheckBox: CheckBox = dialogView.findViewById(R.id.reverse_check)


        inputEditText.setText(savedText)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Reverse")
            .setView(dialogView)
            .setPositiveButton("OK") { dialog, button ->

                var inputText = inputEditText.text.toString()


                if (upperCaseCheckBox.isChecked) {
                    inputText = inputText.uppercase()
                }
                if (reverseCheckBox.isChecked) {
                    inputText = inputText.reversed()
                }


                savedText = inputText


                inputEditText.setText(inputText)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
