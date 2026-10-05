package com.example.lab5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab5.databinding.FragmentLedgerDetailBinding

class LedgerDetailFragment : Fragment() {

    private var _binding: FragmentLedgerDetailBinding? = null
    private val binding get() = _binding!!

    private var title: String = ""
    private var amount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE, "")
            amount = it.getInt(ARG_AMOUNT, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLedgerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = "品名：$title"
        binding.tvAmount.text = "金額：$amount"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_TITLE = "title"
        private const val ARG_AMOUNT = "amount"

        @JvmStatic
        fun newInstance(title: String, amount: Int): LedgerDetailFragment {
            val fragment = LedgerDetailFragment()
            val args = Bundle().apply {
                putString(ARG_TITLE, title)
                putInt(ARG_AMOUNT, amount)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
