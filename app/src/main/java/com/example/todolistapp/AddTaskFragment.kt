package com.example.todolistapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class AddTaskFragment : Fragment() {
    private lateinit var viewModel:TaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_fragment_layout, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        val titleInputField: EditText = view.findViewById(R.id.titleInputField)
        val descriptionInputField:EditText = view.findViewById(R.id.descriptionInputField)
        val addButton: Button = view.findViewById(R.id.addButton)
        addButton.setOnClickListener {
            val title = titleInputField.text.toString()
            val description = descriptionInputField.text.toString()
            viewModel.addTask(title, description)
            parentFragmentManager.popBackStack()
        }
    }
}