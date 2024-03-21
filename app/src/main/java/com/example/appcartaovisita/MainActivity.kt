package com.example.appcartaovisita

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcartaovisita.ui.theme.AppCartaoVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCartaoVisitaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Cartaovisita(name = "Victor", titulo = "Dev Kotlin", telefone = "(14) 99744-6802", redesocial = "@VictorMarinelli", email = "victor@gmail.com")
                }
            }
        }
    }
}


@Composable
fun Cartaovisita(name: String, titulo: String, telefone: String, redesocial: String, email: String, modifier: Modifier = Modifier) {
    val imagem = painterResource(id = R.drawable._05116245)
    Box (
        modifier = Modifier.background(Color(red = 204, green = 208, blue = 248, alpha = 255))
            .padding(20.dp, 0.dp, 20.dp, 0.dp)

    ){
        Descricao(imagem = imagem, name = name, titulo = titulo)
        Contato(telefone = telefone, redesocial = redesocial, email = email)
    }
}


@Composable
fun Descricao(imagem: Painter, name: String, titulo: String,  modifier: Modifier = Modifier) {
    Box(Modifier) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Row (){
                Image(
                    painter = imagem,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                )
            }
            Row {
                Text(
                    text = name,
                    fontSize = 50.sp,
                    lineHeight = 50.sp,
                    textAlign = TextAlign.Center,
                )
            }
            Row {

                Text(
                    text = titulo,
                    fontSize = 20.sp,
                    lineHeight = 34.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
@Composable
fun Contato(telefone: String, redesocial: String, email: String, modifier: Modifier = Modifier) {
    val phone = painterResource(id = R.drawable.call_in_svgrepo_com)
    val rede = painterResource(id = R.drawable.share_svgrepo_com)
    val iconMail = painterResource(id = R.drawable.mail_svgrepo_com)
    Box (modifier){
        Column (
            modifier = Modifier.fillMaxSize().padding(0.dp, 0.dp, 0.dp, 30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,

        ){
            Column {
                Row() {
                    Icon(
                        painter = phone,
                        contentDescription = null,
                        modifier = Modifier.requiredSize(20.dp),
                    )
                    Text(text = telefone)
                    Spacer(modifier = Modifier.height(20.dp))
                }
                Row {
                    Icon(
                        painter = rede,
                        contentDescription = null,
                        modifier = Modifier.requiredSize(20.dp),
                    )
                    Text(text = redesocial)
                    Spacer(modifier = Modifier.height(20.dp))
                }
                Row {
                    Icon(
                        painter = iconMail,
                        contentDescription = null,
                        modifier = Modifier.requiredSize(20.dp),
                    )
                    Text(text = email)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppCartaoVisitaTheme {
        Cartaovisita(name = "Victor M. Montanari", titulo = "Dev Kotlin", telefone = "(14) 99744-6802", redesocial = "@VictorMarinelli", email = "victor@gmail.com")
    }
}