package com.example.hw2_calculatorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw2_calculatorapp.databinding.FragmentLastOperationsBinding


class LastOperationsFragment : Fragment() {

    private var _binding: FragmentLastOperationsBinding? = null
    private val binding get() = requireNotNull(_binding) { "View was destroyed" }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentLastOperationsBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(view.context)
            val history = HistoryStorage
            recyclerView.adapter = NotesAdapter(items = history.historyList ) {

                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}