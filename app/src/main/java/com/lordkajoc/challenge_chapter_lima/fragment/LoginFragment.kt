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
import com.lordkajoc.challenge_chapter_lima.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    //lateinit var sharedLogin: SharedPreferences
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //sharedLogin = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.tvBelumPunyaAkun.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnLogin.setOnClickListener {
//            var getDataUser = sharedLogin.getString("email", "")
//            var getDataPass = sharedLogin.getString("password", "")
            var email = binding.etEmaillogin.text.toString()
            var pass = binding.etPasswordlogin.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                        } else{
                            Toast.makeText(context,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(context, "Kata Sandi Tidak Sesuai", Toast.LENGTH_SHORT).show()
            }

//            if (email.isEmpty() || pass.isEmpty()) {
//                Toast.makeText(context, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT)
//                    .show()
//            } else if (email == getDataUser.toString() && pass == getDataPass.toString()) {
//
//                findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
//                Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
//            } else if (email != getDataUser.toString() || pass != getDataPass.toString()) {
//                Toast.makeText(context, "Email dan Pasword anda salah", Toast.LENGTH_SHORT).show()
//            }

        }
    }

}