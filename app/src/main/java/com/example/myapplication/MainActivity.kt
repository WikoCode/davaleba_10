package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var pickImageLauncher: ActivityResultLauncher<Unit>
    private lateinit var binding : ActivityMainBinding
    private var isDarkMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val switchDarkMode = binding.switchDarkMode

       switchDarkMode.setOnCheckedChangeListener{ _, isChecked ->
           isDarkMode = isChecked
           updateDrawables(isDarkMode)
       }

        Glide.with(this)
            .load(R.drawable.ic_default)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(binding.ivProfilePicture)

        pickImageLauncher = registerForActivityResult(PickImageContract()) { result: Uri? ->
            if (result != null) {
                Glide.with(this)
                    .load(result)
                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                    .into(binding.ivProfilePicture)
            }
        }

        binding.btnChangePicture.setOnClickListener {
            pickImageLauncher.launch(Unit)
        }


    }

    private fun updateDrawables(isDarkMode: Boolean) {
        val mainProfileDrawable = if (isDarkMode) R.drawable.ic_main_darkmode else R.drawable.ic_main_icon
        val threeDotsDrawable = if (isDarkMode) R.drawable.ic_threedots_darkmode else R.drawable.ic_threedots
        val pencilDrawable = if (isDarkMode) R.drawable.ic_pencil_darkmode else R.drawable.ic_pencil
        val profileDrawable = if (isDarkMode) R.drawable.ic_profile_darkmode else R.drawable.ic_profile
        val arrowDrawable = if (isDarkMode) R.drawable.ic_arrow_darkmode else R.drawable.ic_arrow
        val addressDrawable = if (isDarkMode) R.drawable.ic_address_darkmode else R.drawable.ic_address
        val notificationDrawable = if (isDarkMode) R.drawable.ic_notification_darkmode else R.drawable.ic_notification
        val walletDrawable = if (isDarkMode) R.drawable.ic_wallet_darkmode else R.drawable.ic_wallet
        val securityDrawable = if (isDarkMode) R.drawable.ic_security_darkmode else R.drawable.ic_security
        val darkModeDrawable = if (isDarkMode) R.drawable.ic_darkmode_darkmode else R.drawable.ic_darkmode
        val privacyDrawable = if (isDarkMode) R.drawable.ic_privacy_darkmode else R.drawable.ic_privacy
        val helpDrawable = if (isDarkMode) R.drawable.ic_infosquare_darkmode else R.drawable.ic_infobox
        val languageDrawable = if (isDarkMode) R.drawable.ic_language_darkmode else R.drawable.ic_language
        val multipleDrawable = if (isDarkMode) R.drawable.ic_multiple_darkmode else R.drawable.ic_multiple_user
        val logoutDrawable = if (isDarkMode) R.drawable.ic_logout_darkmode else R.drawable.ic_logout
        val backgroundColor = if (isDarkMode) R.color.kindaBlack else R.color.white
        val textColor = if (isDarkMode) R.color.white else R.color.black
        val textViews = listOf(
            binding.tvMainProfile,
            binding.tvFullName,
            binding.tvPhoneNumber,
            binding.tvEditProfile,
            binding.tvAddress,
            binding.tvNotification,
            binding.tvPayment,
            binding.tvSecurity,
            binding.tvLanguage,
            binding.tvSelectedLanguage,
            binding.switchDarkMode,
            binding.tvPrivacy,
            binding.tvHelp,
            binding.tvMultiple,
            binding.tvLogout
        )
        binding.tvMainProfile.setCompoundDrawablesWithIntrinsicBounds(mainProfileDrawable, 0, 0, 0)
        binding.btnThreeDots.setImageResource(threeDotsDrawable)
        binding.btnChangePicture.setImageResource(pencilDrawable)
        binding.tvEditProfile.setCompoundDrawablesWithIntrinsicBounds(profileDrawable, 0, arrowDrawable, 0)
        binding.tvAddress.setCompoundDrawablesWithIntrinsicBounds(addressDrawable, 0, arrowDrawable, 0)
        binding.tvNotification.setCompoundDrawablesWithIntrinsicBounds(notificationDrawable, 0, arrowDrawable, 0)
        binding.tvPayment.setCompoundDrawablesWithIntrinsicBounds(walletDrawable, 0, arrowDrawable, 0)
        binding.tvSecurity.setCompoundDrawablesWithIntrinsicBounds(securityDrawable, 0, arrowDrawable, 0)
        binding.tvSelectedLanguage.setCompoundDrawablesWithIntrinsicBounds(0, 0, arrowDrawable, 0)
        binding.switchDarkMode.setCompoundDrawablesWithIntrinsicBounds(darkModeDrawable, 0, 0, 0)
        binding.tvPrivacy.setCompoundDrawablesWithIntrinsicBounds(privacyDrawable, 0, arrowDrawable, 0)
        binding.tvHelp.setCompoundDrawablesWithIntrinsicBounds(helpDrawable, 0, arrowDrawable, 0)
        binding.tvLanguage.setCompoundDrawablesWithIntrinsicBounds(languageDrawable, 0, arrowDrawable, 0)
        binding.tvSelectedLanguage.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0 , 0)
        binding.tvMultiple.setCompoundDrawablesWithIntrinsicBounds(multipleDrawable, 0, arrowDrawable, 0)
        binding.tvLogout.setCompoundDrawablesWithIntrinsicBounds(logoutDrawable, 0, 0, 0)
        binding.clProfileSettings.setBackgroundColor(ContextCompat.getColor(this, backgroundColor))
        for (textView in textViews) {
          textView.setTextColor(ContextCompat.getColor(this, textColor))
       }


    }



}