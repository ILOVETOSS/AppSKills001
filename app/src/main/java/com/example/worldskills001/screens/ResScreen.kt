package com.example.worldskills001.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskills001.R

@Composable
fun ResScreen(
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
        Spacer(modifier = Modifier.height(200.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(200.dp))
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),
                onClick = {}
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.img3),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("캠핑 닉네임", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("닉네임",fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),
                onClick = {}
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.img3),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("캠핑 경험", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("닉네임",fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),
                onClick = {}
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.img3),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("동반 인원", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("닉네임",fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),
                onClick = {}
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.img3),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("숙박 유형", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("닉네임",fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),
                onClick = {}
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.img3),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("체크인 날짜", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("닉네임",fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .height(70.dp)
                    .width(350.dp),
                onClick = {}
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.img3),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("선호 활동", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text("닉네임",fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Image(
                        painter = painterResource(R.drawable.arrowgo),
                        contentDescription = null
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun ResPreivew(){
    ResScreen()
}