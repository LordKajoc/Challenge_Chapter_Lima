package com.lordkajoc.challenge_chapter_lima.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.lordkajoc.challenge_chapter_lima.R
import com.lordkajoc.challenge_chapter_lima.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth

    //lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)
        val getUser = sharedPreferences.getString("user", "")
        binding.etUsernameprofile.setText(getUser)

        val getNama = sharedPreferences.getString("nama", "")
        binding.etNameprofile.setText(getNama)

        val getTgl = sharedPreferences.getString("tgl", "")
        binding.etTgllahirprofile.setText(getTgl)

        val getAlamat = sharedPreferences.getString("alamat", "")
        binding.etAddressprofile.setText(getAlamat)

        binding.btnupdateprofile.setOnClickListener {
            val getUsername = binding.etUsernameprofile.text.toString()
            val getNamaLengkap = binding.etNameprofile.text.toString()
            val getTglLahir = binding.etTgllahirprofile.text.toString()
            val getAlamat = binding.etAddressprofile.text.toString()
            val addUser = sharedPreferences.edit()
            addUser.putString("user", getUsername)
            addUser.putString("nama", getNamaLengkap)
            addUser.putString("tgl", getTglLahir)
            addUser.putString("alamat", getAlamat)
            addUser.apply()

            Toast.makeText(context, "Update Berhasil", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment2)
        }

        binding.btnLogout.setOnClickListener {
            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signOut()
            val addUser = sharedPreferences.edit()
            addUser.remove("nama")
            addUser.remove("tgl")
            addUser.remove("alamat")
            addUser.commit()
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

//    private fun signout() {
//        firebaseAuth = FirebaseAuth.getInstance()
//        firebaseAuth.signOut()
//    }
}