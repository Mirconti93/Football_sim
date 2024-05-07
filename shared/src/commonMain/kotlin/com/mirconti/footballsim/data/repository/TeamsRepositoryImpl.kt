package com.mircontapp.sportalbum.data.repository

import com.mirco.sportalbum.utils.Enums
import com.mircontapp.sportalbum.data.datasource.FootballDataSource
import com.mircontapp.sportalbum.domain.repository.TeamsRepository
import com.mirconti.footballsim.domain.models.TeamModel
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class TeamsRepositoryImpl @Inject constructor(val footballDataSource: FootballDataSource) : TeamsRepository {

    override suspend fun getAllTeams(): List<TeamModel> {
        return footballDataSource.fetchTeams()?.toMutableList() ?: ArrayList()
    }

    override suspend fun addTeam(teamModel: TeamModel) {
        //teams.add(teamModel)
    }

    override suspend fun teamsFromArea(area: Enums.Area) : List<TeamModel> {
        return getAllTeams().filter { area.equals(it.area) }.sortedBy { it.name }
    }

    override suspend fun updateTeam(teamModel: TeamModel) {
        footballDataSource.updateTeam(teamModel)
    }

    override suspend fun insertTeam(teamModel: TeamModel) {
        footballDataSource.insertTeam(teamModel)
    }

    override suspend fun getNationalTeams(): List<TeamModel> {
        return getAllTeams().filter { "national".equals(it.type) }.sortedBy { it.name }
    }

    override suspend fun teamsFromSuperlega(): List<TeamModel> {
        return getAllTeams().filter { it.superlega ?: false }.sortedBy { it.name }
    }



}