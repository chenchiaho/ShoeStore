package com.udacity.shoestore

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    val shoeViewModel : ShoeViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false)
        binding.shoeViewModel = shoeViewModel

        binding.buttonCancel.setOnClickListener { v: View ->
                findNavController().navigateUp()

        }
        shoeViewModel.detailReturnToList.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigateUp()
            }
        })

        shoeViewModel.formIncomplete.observe(viewLifecycleOwner, Observer { showError ->
            if (showError) {
                formIncompleteMessage()
            }

        })

        return binding.root
    }
        private fun formIncompleteMessage() {
            AlertDialog.Builder(requireContext())
                    .setTitle("Attention!")
                    .setMessage("Please enter all fields")
                    .setPositiveButton(requireContext().getString(android.R.string.ok)) {
                        dialogInterface, i -> dialogInterface.dismiss()
                    }
                    .setCancelable(true)
                    .create()
                    .show()


        }


    }
