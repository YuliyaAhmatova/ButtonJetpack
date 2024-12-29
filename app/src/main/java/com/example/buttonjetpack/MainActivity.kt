package com.example.buttonjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Buttons()
        }
    }
}

@SuppressLint("AutoboxingStateCreation")
@Composable
fun Buttons() {
    val buttonOneContainerColor = rememberSaveable {
        mutableStateOf(Color.Magenta.toArgb())
    }
    val buttonOneBorderThickness = rememberSaveable {
        mutableStateOf(4)
    }
    val buttonOneBorderColor = rememberSaveable {
        mutableStateOf(Color.White.toArgb())
    }
    val buttonTwoContainerColor = rememberSaveable {
        mutableStateOf(Color.LightGray.toArgb())
    }
    val buttonTwoBorderThickness = rememberSaveable {
        mutableStateOf(6)
    }
    val buttonTwoBorderColor = rememberSaveable {
        mutableStateOf(Color.DarkGray.toArgb())
    }
    val buttonThreeContainerColor = rememberSaveable {
        mutableStateOf(Color.Cyan.toArgb())
    }
    val buttonThreeBorderThickness = rememberSaveable {
        mutableStateOf(7)
    }
    val buttonThreeBorderColor = rememberSaveable {
        mutableStateOf(Color.Green.toArgb())
    }

    fun getRandomColor(): Int {
        return Color(
            Random.nextInt(225),
            Random.nextInt(225),
            Random.nextInt(225),
            225
        ).toArgb()
    }

    fun ChangeValue() {
        buttonOneContainerColor.value = getRandomColor()
        buttonOneBorderThickness.value = Random.nextInt(1, 9)
        buttonOneBorderColor.value = getRandomColor()
        buttonTwoContainerColor.value = getRandomColor()
        buttonTwoBorderThickness.value = Random.nextInt(1, 9)
        buttonTwoBorderColor.value = getRandomColor()
        buttonThreeContainerColor.value = getRandomColor()
        buttonThreeBorderThickness.value = Random.nextInt(1, 9)
        buttonThreeBorderColor.value = getRandomColor()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = {
                ChangeValue()
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(buttonOneContainerColor.value)
            ),
            border = BorderStroke(
                buttonOneBorderThickness.value.dp,
                Color(buttonOneBorderColor.value)
            )
        ) {
            Text(
                text = "One",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        }
        Button(
            onClick = {
                ChangeValue()
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(buttonTwoContainerColor.value)
            ),
            border = BorderStroke(
                buttonTwoBorderThickness.value.dp,
                Color(buttonTwoBorderColor.value)
            )
        ) {
            Text(
                text = "Two",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        }
        Button(
            onClick = {
                ChangeValue()
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(buttonThreeContainerColor.value)
            ),
            border = BorderStroke(
                buttonThreeBorderThickness.value.dp,
                Color(buttonThreeBorderColor.value)
            )
        ) {
            Text(
                text = "Three",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
