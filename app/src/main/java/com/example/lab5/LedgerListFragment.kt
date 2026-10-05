package com.example.lab5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab5.databinding.FragmentLedgerListBinding

class LedgerListFragment : Fragment() {

    private var _binding: FragmentLedgerListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLedgerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLunch.setOnClickListener {
            navigateToDetail("午餐", 120)
        }

        binding.btnMrt.setOnClickListener {
            navigateToDetail("捷運", 35)
        }

        binding.btnBook.setOnClickListener {
            navigateToDetail("書籍", 450)
        }
    }

    private fun navigateToDetail(title: String, amount: Int) {
        val detailFragment = LedgerDetailFragment.newInstance(title, amount)
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, detailFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
