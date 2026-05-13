package com.example.worldskills001.screens

import android.R.attr.text
import android.icu.number.Scale
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskills001.Mybutton.Backbutton
import com.example.worldskills001.Mybutton.Nextbutton
import com.example.worldskills001.R

@Composable
fun Setupscreen(
    startStep: Int = 1
){
    var visible by remember { mutableStateOf(false) }
    var step by remember { mutableStateOf(startStep) }

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(R.drawable.bg_day_lake),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 20.dp)
                .align(alignment = Alignment.TopCenter)
        )
        Image(
            painter = painterResource(R.drawable.img2),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 90.dp)
                .align(alignment = Alignment.TopCenter)
        )
        when(step){
            1 -> Nickname { step = 2 }
            2 -> Exp {step = 3}
            3 -> Person { step = 4 }
            4 -> Pretype { step = 5 }
            5 -> Checkin { step = 6 }
        }
    }
}
@Composable
fun Nickname(onNext: () -> Unit){
    var text by remember { mutableStateOf("") }
    var context = LocalContext.current
    var step by remember { mutableStateOf(2) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(250.dp))
        Image(
            painter = painterResource(R.drawable.img3),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text("캠핑 닉네임을 입력해주세요.")
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = text,
            onValueChange = {text = it},
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,

            ),
            placeholder = { Text("닉네임을 입력하세요") } // ?
        )
        Spacer(modifier = Modifier.height(130.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Backbutton() { }
            Spacer(modifier = Modifier.width(120.dp))
            if(text.isNotEmpty()){
                Nextbutton(onClick = {
                    if(text.length < 2 || text.length > 12){
                        Toast.makeText(context,"2글자 이상 12글자 미만",Toast.LENGTH_SHORT)

                    }
                    else{
                        onNext()

                    }
                })

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        progressbar(progress = 0.25f)
    }

}
@Composable
fun Exp(onNext: () -> Unit){
    var select by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Text("캠핑 경험을 선택해주세요.", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(50.dp))
        Column(
        ) {
            Button(
                modifier = Modifier
                    .width(300.dp)
                    .height(90.dp),
                onClick = {
                    select = 1
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(select == 1) Color.Black else Color.White
                ),
            ) {
                Image(
                    painter = painterResource(R.drawable.img3),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text("캠핑 초보", color = Color.Black)
            }
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                modifier = Modifier
                    .width(300.dp)
                    .height(90.dp),
                onClick = {
                    select = 2
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(select == 2) Color.Black else Color.White
                ),
            ) {
                Image(
                    painter = painterResource(R.drawable.img3),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text("캠핑 보통", color = Color.Black)
            }
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                modifier = Modifier
                    .width(300.dp)
                    .height(90.dp),
                onClick = {
                    select = 3
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(select == 3) Color.Black else Color.White
                ),
            ) {
                Image(
                    painter = painterResource(R.drawable.img3),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text("캠핑 숙련",color = Color.Black)
            }

        }
        Spacer(modifier = Modifier.height(70.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

        ) {
            Backbutton() { }
            Spacer(modifier = Modifier.width(120.dp))
            if(select > 0){
                Nextbutton() {
                    onNext()
                }
            }


        }
        Spacer(modifier = Modifier.height(40.dp))
        progressbar(progress = 0.25F)
    }

}


@Composable
fun Person(onNext: () -> Unit){
    var count by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(220.dp))
        Text("동반 인원을 선택해주세요.", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Button(
                onClick = {
                    if(count > 1){
                        count--
                    }
                },
                modifier = Modifier
                    .height(230.dp)
                    .width(90.dp)
            ) {
                Column(
                ) {
                    Image(
                        painter = painterResource(R.drawable.img3),
                        contentDescription = null,
                    )
                    Text("감소", fontSize = 20.sp, color = Color.Black)
                }
            }
            Column(
                modifier = Modifier
                    .height(250.dp)
                    .width(190.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(count.toString(), fontSize = 50.sp)
                Text("인원 수 표시", fontSize = 20.sp)
                Text("텍스트", fontSize = 20.sp)
            }
            Button(
                onClick = {
                    if(count < 6){
                        count++
                    }
                },
                modifier = Modifier
                    .height(230.dp)
                    .width(90.dp)
            ) {
                Column(
                ) {
                    Image(
                        painter = painterResource(R.drawable.img3),
                        contentDescription = null,
                    )
                    Text("증가", fontSize = 20.sp, color = Color.Black)
                }
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Backbutton() { }
            Nextbutton(
            ) {
                onNext()
            }
        }
        Spacer(modifier = Modifier.height(90.dp))
        progressbar(progress = 0.35F)

    }
}

@Composable
fun Pretype(onNext: () -> Unit){
    var select by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Text("선호 숙박 유형을 선택해주세요.", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp)

            ) {
                Button(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    shape = RoundedCornerShape(15.dp),
                    onClick = {
                        select = 1
                    }
                ) {
                    Column(
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img3),
                            contentDescription = null
                        )
                        Text("오토캠핑")

                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    shape = RoundedCornerShape(15.dp),
                    onClick = {
                        select = 2
                    }
                ) {
                    Column(
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img3),
                            contentDescription = null
                        )
                        Text("글램핑")

                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp)

            ) {
                Button(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    shape = RoundedCornerShape(15.dp),
                    onClick = {
                        select = 3
                    }
                ) {
                    Column(
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img3),
                            contentDescription = null
                        )
                        Text("카라반")

                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp),
                    shape = RoundedCornerShape(15.dp),
                    onClick = {
                        select = 4
                    }
                ) {
                    Column(
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img3),
                            contentDescription = null
                        )
                        Text("차박")

                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
        ) {
            Backbutton() { }
            Spacer(modifier = Modifier.width(120.dp))
            if(select > 0){
                Nextbutton() {
                    onNext()
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        progressbar(progress = 0.45F)
    }


}

@Composable
fun Checkin(onNext: () -> Unit){

}
@Composable
fun progressbar(progress : Float){
    LinearProgressIndicator(
        progress = {progress},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(4.dp)),
        color = Color.White,
        trackColor = Color.Gray
    )
}
@Preview
@Composable
fun SetipPreivew(){
    Setupscreen(startStep = 4)
}
