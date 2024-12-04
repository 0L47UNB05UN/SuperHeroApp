package com.example.superheroapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroapp.model.DataSource
import com.example.superheroapp.ui.theme.Shapes
import com.example.superheroapp.ui.theme.SuperHeroAppTheme

@Composable
fun HeroCard(
    @StringRes name: Int, @StringRes descrip: Int, @DrawableRes img: Int, modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier
            .padding(start=16.dp, bottom=8.dp, end=16.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(16.dp).clip(Shapes.medium)
                .fillMaxSize().sizeIn(minHeight=72.dp)
        ){
            Column(
                modifier.weight(3f)
            ){
                Text(
                    text = stringResource(name),
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = stringResource(descrip),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Box(
                modifier.padding(start=16.dp).weight(1f).size(72.dp)
            ){
                Image(
                    painter = painterResource(img),
                    contentDescription = null,
                    modifier = modifier.clip(Shapes.small)
                )
            }
        }
    }
}


@Composable
fun HeroList(modifier: Modifier=Modifier){
    LazyColumn {
        items(DataSource().loadHeroes()){hero->
            HeroCard(hero.name, hero.descrip, hero.img, modifier)
        }
    }
}

@Preview
@Composable
fun HeroCardPreview(){
    SuperHeroAppTheme(darkTheme = true) {
        HeroList()
    }
}