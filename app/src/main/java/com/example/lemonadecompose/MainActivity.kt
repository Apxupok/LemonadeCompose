package com.example.lemonadecompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadecompose.ui.theme.LemonadeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    screen()
                }
            }
        }
    }
}

var image = R.drawable.lemon_tree
var string = R.string.tree


@Composable
fun screen(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)){

    var imageCondition by remember {
        mutableStateOf(1)
    }

    when (imageCondition){
            1 ->  {image = R.drawable.lemon_tree
                string = R.string.tree }
            2 -> {image = R.drawable.lemon_squeeze
                string = R.string.squeeze }
            3 -> {image = R.drawable.lemon_drink
                string = R.string.drink }
            4 -> {image = R.drawable.lemon_restart
                string = R.string.restart}
            else -> imageCondition = 1
    }

    fun random(number: Int): Int {
        if (number==2){
            var i = 0
            while (i != (0..2).random()){
                return 0
            }
                i++
        }
        return 1
    }


    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .clickable(onClick = { imageCondition += random(imageCondition)})
                .border(width = 2.dp, color = Color(105,205,216))
                .padding(16.dp))
        Spacer(modifier = Modifier.height(16.dp))

        Text( text = stringResource(id = string),
            fontSize = 18.sp
        )
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    screen()
}