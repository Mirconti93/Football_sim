package com.mircontapp.sportalbum.domain.models

import com.mirco.sportalbum.utils.Enums
import com.mirconti.footballsim.domain.models.PlayerModel
data class LineUpModel(
    val module: Enums.LineUpModule,
    val starting: List<PlayerModel>,
    val availables: List<PlayerModel>,
    val isLegend: Boolean
)