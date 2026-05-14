package com.example.worldskills001.screens

import android.R.attr.text
import android.icu.number.Scale
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldskills001.Mybutton.Backbutton
import com.example.worldskills001.Mybutton.Nextbutton
import com.example.worldskills001.R
import com.example.worldskills001.core.Core
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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
            6 -> Pretype2 { step = 7 }
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
                        Core.user.nickname = text
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
                    Core.user.exprience = when(select){
                        1 -> "캠핑초보"
                        2 -> "캠핑보통"
                        3 -> "캠핑숙련"
                        else -> ""
                    }
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
                Core.user.personCount = count
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
                    Core.user.perfertype = when (select) {
                        1 -> "오토캠핑"
                        2 -> "글램핑"
                        3 -> "카라반"
                        4 -> "차박"
                        else -> "" // when을 변수에 대입할 땐 반드시 else가 필요함
                    }
                    onNext()
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        progressbar(progress = 0.45F)
    }


}

@Composable
fun Checkin(onNext: () -> Unit) {
    // 1. 상태 관리: 현재 화면에 보여줄 기준 날짜 (기본값: 오늘)
    var focusDay by remember { mutableStateOf(LocalDate.now()) }

    // 2. 상태 관리: 사용자가 클릭해서 선택한 날짜 (초기값 없음)
    var selectDay by remember { mutableStateOf<LocalDate?>(null) }

    // 토스트 메시지를 띄우기 위한 컨텍스트 가져오기
    val context = LocalContext.current

    // 전체 레이아웃 시작
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(170.dp))
        // 제목 텍스트
        Text(
            text = "체크인 날짜를 선택해주세요.",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // 3. 월 이동 컨트롤러 (이전달 - 현재년월 - 다음달)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 이전 달로 이동 버튼
            Button(
                onClick = {},
                modifier = Modifier
            ) { }

            // 현재 보고 있는 년.월 표시 (예: 2026.05)
            Text(
                text = focusDay.format(DateTimeFormatter.ofPattern("yyyy.MM")),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // 다음 달로 이동 버튼
            Button(
                onClick = {}
            ) {

            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 4. 요일 헤더 (일~토)
        Row(modifier = Modifier.fillMaxWidth()) {
            val weekdays = listOf("일", "월", "화", "수", "목", "금", "토")
            weekdays.forEach { day ->
                Box(
                    modifier = Modifier.weight(1f), // 7칸을 동일한 비율로 나눔
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = day,
                        fontSize = 16.sp,
                        // 일요일은 빨강, 토요일은 파랑, 나머지는 검정
                        color = when(day) {
                            "일" -> Color.Red
                            "토" -> Color.Blue
                            else -> Color.Black
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // --- 여기서부터 달력 그리드 계산 시작 ---

        // 5. 이번 달의 1일 날짜 객체 생성
        val firstDayOfMonth = focusDay.withDayOfMonth(1)

        // 6. 시작 요일 오프셋 계산 (일요일=0, 월요일=1 ... 토요일=6)
        // dayOfWeek.value는 월(1)~일(7)을 주므로 %7 처리를 통해 일요일을 0으로 만듦
        val sPad = firstDayOfMonth.dayOfWeek.value % 7

        // 7. 이번 달이 총 며칠인지 계산 (28, 30, 31 등)
        val daysInMonth = focusDay.lengthOfMonth()

        // 8. 달력 격자 (7열 고정)
        LazyVerticalGrid(
            columns = GridCells.Fixed(7), // 무조건 7개씩 한 줄
            modifier = Modifier.fillMaxWidth()
        ) {
            // 9. 1일 시작 전 빈칸들 생성 (sPad 개수만큼)
            items(sPad) {
                Box(
                    modifier = Modifier
                        .aspectRatio(1f) // 정사각형 유지
                        .border(0.5.dp, Color.Black.copy(alpha = 0.1f)) // 아주 연한 테두리
                )
            }

            // 10. 실제 날짜들 생성 (1일부터 daysInMonth까지)
            items(daysInMonth) { index ->
                val dayNum = index + 1 // 인덱스는 0부터 시작하므로 +1
                val currentLocalDate = focusDay.withDayOfMonth(dayNum) // 해당 칸의 실제 날짜 객체
                val isSelected = selectDay == currentLocalDate // 사용자가 선택한 날짜인지 확인
                val isToday = currentLocalDate == LocalDate.now() // 오늘 날짜인지 확인

                Box(
                    modifier = Modifier
                        .aspectRatio(1f) // 정사각형 유지
                        .background(
                            // 선택된 날짜면 연한 파란색 배경, 아니면 투명
                            if (isSelected) Color.Blue.copy(alpha = 0.2f) else Color.Transparent
                        )
                        .border(0.5.dp, Color.Black.copy(alpha = 0.1f)) // 격자무늬 선
                        .clickable {
                            // 11. 예외 처리: 오늘보다 이전 날짜를 클릭하면 경고
                            if (currentLocalDate.isBefore(LocalDate.now())) {
                                Toast.makeText(context, "예약은 과거를 선택할 수 없습니다", Toast.LENGTH_SHORT).show()
                            } else {
                                // 정상 날짜면 선택 상태 업데이트
                                selectDay = currentLocalDate
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = dayNum.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        // 선택된 날짜는 파란색, 오늘 날짜는 강조, 나머지는 검정
                        color = when {
                            isSelected -> Color.Blue
                            isToday -> Color(0xFF008000) // 오늘 날짜는 초록색 등으로 포인트
                            else -> Color.Black
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Backbutton() { }
            Spacer(modifier = Modifier.width(90.dp))
            if(selectDay != null){
                Nextbutton() {
                    Core.user.checkinDate = selectDay!!
                    onNext()
                }
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        progressbar(progress = 0.75F)

    }
}

@Composable
fun Pretype2(onNext: () -> Unit){
    var select by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Text("선호 활동을 선택해주세요.")
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            modifier = Modifier
                .height(80.dp)
                .width(330.dp),
            onClick = {
                select = 1
            }
        ) {
            Image(
                painter = painterResource(R.drawable.img6),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(80.dp))
            Text(
                text = "힐링",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .height(80.dp)
                .width(330.dp),
            onClick = {
                select = 2
            }
        ) {
            Image(
                painter = painterResource(R.drawable.img4),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(70.dp))
            Text(
                text = "바비큐",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .height(80.dp)
                .width(330.dp),
            onClick = {
                select = 3
            }
        ) {
            Image(
                painter = painterResource(R.drawable.img4),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(70.dp))
            Text(
                text = "바비큐",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier
                .height(80.dp)
                .width(330.dp),
            onClick = {
                select = 4
            }
        ) {
            Image(
                painter = painterResource(R.drawable.img4),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(70.dp))
            Text(
                text = "바비큐",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Backbutton() { }
            Spacer(modifier = Modifier.width(100.dp))
            if(select > 0){
                Nextbutton() {
                    Core.user.activity = when(select){
                        1 -> "힐링"
                        2 -> "바비큐"
                        3 -> "액티비티"
                        5 -> "반려동물 동"
                        else -> ""
                    }
                    onNext()
                }
            }

        }
        Spacer(modifier = Modifier.height(40.dp))
        progressbar(progress = 0.85F)
    }
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
    Setupscreen(startStep = 6)
}
