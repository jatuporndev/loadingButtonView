package com.pandadev.loadingbuttonlibary

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.pandadev.loadingbuttonlibary.databinding.LoadingButtonViewBinding


class LoadingButton(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private var binding: LoadingButtonViewBinding

    // Attributes
    var textButton: String? = null
        set(value) {
            field = value
            updateAttributes()
        }

    var borderRadius: Float = 32f
        set(value) {
            field = value
            updateAttributes()
        }

    var buttonColor: Int = Color.BLACK
        set(value) {
            field = value
            updateAttributes()
        }

    var textColor: Int = Color.WHITE
        set(value) {
            field = value
            updateAttributes()
        }

    var state: ButtonLoadingState = ButtonLoadingState.Text
        set(value) {
            field = value
            updateAttributes()
        }

    init {
        binding = LoadingButtonViewBinding.inflate(LayoutInflater.from(context), this, true)
        val typedArray: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.LoadingButton)
        try {
            textButton = typedArray.getString(R.styleable.LoadingButton_textButton)
            borderRadius = typedArray.getDimension(R.styleable.LoadingButton_borderRadius, 0f)
            buttonColor = typedArray.getColor(R.styleable.LoadingButton_buttonColor, Color.BLACK)
            textColor = typedArray.getColor(R.styleable.LoadingButton_textColor, Color.WHITE)
        } finally {
            typedArray.recycle()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        updateAttributes()
        //binding.yourView.setBackgroundColor(customColor)
    }

    private fun updateAttributes() {
        if (state == ButtonLoadingState.Text) {
            binding.viewFlipper.displayedChild = 1
        } else {
            binding.viewFlipper.displayedChild = 0
        }

        binding.loading.progressTintList = ColorStateList.valueOf(textColor)
        binding.cardView.radius = borderRadius
        binding.cardView.setCardBackgroundColor(buttonColor)
        binding.buttonText.text = textButton ?: "submit"
        binding.buttonText.setTextColor(textColor)

    }

}