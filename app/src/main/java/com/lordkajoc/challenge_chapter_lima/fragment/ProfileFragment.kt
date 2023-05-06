package com.lordkajoc.challenge_chapter_lima.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.lordkajoc.challenge_chapter_lima.R
import com.lordkajoc.challenge_chapter_lima.databinding.FragmentProfileBinding
import com.lordkajoc.challenge_chapter_lima.databinding.FragmentRegisterBinding

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var firebaseAuth: FirebaseAuth

    //lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)


        binding.btnupdateprofile.setOnClickListener {
            var getUsername = binding.etUsernameprofile.text.toString()
            var getNamaLengkap = binding.etNameprofile.text.toString()
            var getTglLahir = binding.etTgllahirprofile.text.toString()
            var getAlamat = binding.etAddressprofile.text.toString()
            var addUser = sharedPreferences.edit()
            addUser.putString("user", getUsername)
            addUser.apply()
            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signOut()
            Toast.makeText(context, "Update Berhasil", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment2)
        }

        binding.btnLogout.setOnClickListener {
            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signOut()
            Toast.makeText(context, "Keluar Berhasil", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }


//            binding.pro.setOnClickListener {
//                firebaseAuth = FirebaseAuth.getInstance()
//                firebaseAuth.signOut()
//                Toast.makeText(context, "Keluar Berhasil", Toast.LENGTH_SHORT).show()
//                findNavController().navigate(R.id.action_profileFragment_to_loginFragment,)
//
////                getActivity().getFragmentManager().popBackStack();
//            }


//            addUser.putString("email", getEmail)
//            addUser.putString("password", getPass)
//            addUser.putString("repeadPassword", getRepeatPass)
//            if (getPass == getRepeatPass) {
//                addUser.apply()
//                Toast.makeText(context, "Register Berhasil", Toast.LENGTH_SHORT).show()
//                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
//            } else {
//                Toast.makeText(
//                    context,
//                    "Ulangi password yang anda masukan tidak sama",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }


    }

    private fun signout() {
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()
    }
}