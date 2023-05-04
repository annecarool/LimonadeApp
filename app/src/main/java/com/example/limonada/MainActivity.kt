package com.example.limonada

import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    AppLimonade()
                }
            }
        }
    }
}
@Preview
@Composable
    fun AppLimonade() { A
    var tela by remember { mutableStateOf(1) }

    when (tela) {
        1 -> AppContent(
            R.string.limoeiro,
            R.drawable.lemon_tree,
            onImagemClick = {
                tela = 2
            }
        )

        2 -> AppContent(
            R.string.limão,
            R.drawable.lemon_squeeze
        )

            ,

        3 -> AppContent(
            R.string.copo_de_limonada,
            R.drawable.lemon_drink
        )

        4 -> AppContent(
            R.string.copo_vazio,
            R.drawable.lemon_restart
        )
    }
}


@Composable
    fun AppContent(painter: Painter, text: String, onImagemClick:()->Unit) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = Color(0, 0, 0),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraLight,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
            Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .clickable(onClick = onImagemClick)
                .size(200.dp)
                .border(
                    width = (1.dp),
                    color = Color(105, 205, 216),
                    RoundedCornerShape(6.dp)
                )
                .clip(CircleShape)
            )
        }

}