package com.devmasterteam.tasks.helper

import android.content.Context
import android.os.Build
import androidx.biometric.BiometricManager

class BiometricHelper {
    companion object{
        fun isBiometricAvailable(context: Context): Boolean{

            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
                return false
            }
            val biometricManager = BiometricManager.from(context)
            when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) {
                //define se a confereência com a digital cadastrada será
                //forte(strong) ou aceitará menos compatilibilidade(weak)
                BiometricManager.BIOMETRIC_SUCCESS -> return true  //sucesso
                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> return false   //travamento no hw
                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> return false  //hw não suporta
                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> return false   // biometria não cadastrada
            }
            return false
        }
    }

}