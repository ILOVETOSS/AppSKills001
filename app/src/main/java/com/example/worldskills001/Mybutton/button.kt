    package com.example.worldskills001.Mybutton

    import android.R.attr.onClick
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.material3.Button
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.unit.dp
    import com.example.worldskills001.R


    @Composable
    fun Backbutton(
        modifier: Modifier = Modifier,
        onClick: () -> Unit
    ){
        Button(
            onClick = {},
            modifier = Modifier
                .height(60.dp)
                .width(130.dp),

        ) {
            Image(
                painter = painterResource(R.drawable.arrowback),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text("이전")
        }
    }

    @Composable
    fun Nextbutton(
        modifier: Modifier = Modifier,
        onClick: () -> Unit

    ){
        Button(
            onClick = onClick,
            modifier = Modifier
                .height(60.dp)
                .width(130.dp),

        ) {
            Text("다음")
            Spacer(modifier = Modifier.width(15.dp))
            Image(
                painter = painterResource(R.drawable.arrowgo),
                contentDescription = null
            )
        }

    }