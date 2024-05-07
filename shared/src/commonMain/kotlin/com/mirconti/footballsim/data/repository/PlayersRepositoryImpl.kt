package com.mircontapp.sportalbum.data.repository

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.data.datasource.FootballDataSource
import com.mircontapp.sportalbum.domain.repository.PlayersRepository
import com.mirconti.footballsim.domain.models.PlayerModel


class PlayersRepositoryImpl(val footballDataSource: FootballDataSource): PlayersRepository {

    override suspend fun getAllPlayers(): List<PlayerModel> {
        return footballDataSource.fetchPlayers()?.toList() ?: ArrayList()
    }

    override suspend fun playersFromTeam(teamName: String) : List<PlayerModel> {
        return getAllPlayers().filter { it.team.equals(teamName) }
    }

    override suspend fun playersFromTeamLegend(teamName: String): List<PlayerModel> {
        return getAllPlayers().filter { teamName.equals(it?.teamLegend) }
    }

    override suspend fun playersFromNational(country: String, gender: Enums.Gender): List<PlayerModel> {
        return getAllPlayers().filter {country == it.country && gender == it.gender && it.national == 1}
    }

    override suspend fun playersFromNationalLegend(country: String, gender: Enums.Gender): List<PlayerModel> {
        return getAllPlayers().filter { country == it.country && gender == it.gender && it.nationalLegend == 1 }
    }

    override suspend fun insertPlayer(playerModel: PlayerModel) {
        footballDataSource.insertPlayer(playerModel)
    }

    override suspend fun updatePlayer(playerModel: PlayerModel) {
        footballDataSource.updatePlayer(playerModel)
    }


}