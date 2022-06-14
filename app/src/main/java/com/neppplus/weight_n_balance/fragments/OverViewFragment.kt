package com.neppplus.weight_n_balance.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neppplus.weight_n_balance.MainActivity
import com.neppplus.weight_n_balance.databinding.FragmentOverViewBinding
import com.neppplus.weight_n_balance.weightData.WeightData
import java.util.*

class OverViewFragment : Fragment() {

    lateinit var binding: FragmentOverViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var weightData = (requireContext() as MainActivity).mWeightData

        binding.pilotWeightTxt.text = weightData.pilotWeight
        binding.coPilotWeightTxt.text = weightData.coPilotWeight




    }
}