package com.vaibhav142.listmaker

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    lateinit var todoListRecyclerView: RecyclerView
    lateinit var adapter: TodoListAdapter
    lateinit var listDataManager: ListDataManager

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_second, container, false)

        todoListRecyclerView = view.findViewById(R.id.lists_recyclerview)
        todoListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        todoListRecyclerView.adapter = TodoListAdapter()

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            adapter = todoListRecyclerView.adapter as TodoListAdapter
            createAndShowDialogForNewItem()
        }
        return view
    }

    private fun createAndShowDialogForNewItem() {
        val dialog = AlertDialog.Builder(requireContext())
        val todoItemEditText = EditText(requireContext())
        todoItemEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS

        val dialogTitle = "Insert the new Item"
        val positiveButtonTitle = "Add"

        dialog.setView( todoItemEditText)
        dialog.setTitle(dialogTitle).setPositiveButton(positiveButtonTitle){
            dialog, _  ->
               adapter.addItem(todoItemEditText.text.toString())
        }
        dialog.create().show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}