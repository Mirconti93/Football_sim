package com.mircontapp.sportalbum.data.datasource

import com.mirconti.footballsim.domain.models.PlayerModel
import com.mirconti.footballsim.domain.models.TeamModel


interface FootballDataSource {
    abstract suspend fun fetchPlayers(): List<PlayerModel>?

    abstract suspend fun fetchTeams(): List<TeamModel>?

    abstract suspend fun insertPlayer(playerModel: PlayerModel)
    abstract suspend fun updatePlayer(playerModel: PlayerModel)

    abstract suspend fun updateTeam(teamModel: TeamModel)
    abstract suspend fun insertTeam(teamModel: TeamModel)

}