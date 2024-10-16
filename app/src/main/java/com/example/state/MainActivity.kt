package com.example.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    private val rusList = listOf("Яйца", "Хлеб", "Молоко", "Лук", "Картошка", "Бананы", "Яблоки", "Сыр")
    private val engList = listOf("Eggs", "Bread", "Milk", "Onion", "Potato", "Bananas", "Apples", "Cheese")
    private var check: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val count = rememberSaveable{mutableStateOf("Переключить язык")}
            val countTitle = rememberSaveable{mutableStateOf("Список продуктов")}
            val (list, setList) = rememberSaveable{mutableStateOf(rusList)}

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 38.dp, start = 5.dp, end = 5.dp)
                    .background(Color.DarkGray)
            ) {
                Text(
                    text = countTitle.value,
                    fontSize = 32.sp,
                    color = Color.White
                )
            }
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                contentPadding = PaddingValues(vertical = 8.dp),
                modifier = Modifier
                    .padding(top = 76.dp, start = 5.dp, end = 5.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ) {
                items(list) { foods ->
                Text(
                    text = foods,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .size(width = 400.dp, height = 30.dp)
                        .clip(shape = CircleShape)
                        .background(Color.White)
                        .border(2.dp, Color.White),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(8.dp))
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 460.dp, start = 5.dp, end = 5.dp)
            ) {
                Text(
                    text = count.value,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable (
                        onClick = {
                            if (check == true) {
                                setList(rusList)
                                count.value = "Переключить язык"
                                countTitle.value = "Список продуктов"
                                check = false
                            }
                            else{
                                setList(engList)
                                count.value = "Change language"
                                countTitle.value = "List of product"
                                check = true
                            }


                        }

                    )
                )
            }

        }
    }
}

