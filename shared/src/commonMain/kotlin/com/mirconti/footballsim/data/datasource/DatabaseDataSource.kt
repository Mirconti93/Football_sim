package com.mirconti.footballsim.data.datasource

import com.mirconti.footballsim.SportAlbumApplication
import com.mirconti.footballsim.domain.models.PlayerModel
import com.mirconti.footballsim.domain.models.TeamModel


class DatabaseDataSource : AlbumDataSource {
    private val players: MutableList<PlayerModel> = ArrayList()
    private val teams: MutableList<TeamModel> = ArrayList()
    val database: AppDatabase?

    init {
       database = AppDatabase.getInstance(SportAlbumApplication.instance.applicationContext)
    }

    override suspend fun fetchPlayers(): List<PlayerModel>? {
        if (players.isEmpty()) {
            database?.playerDao()?.getAll()?.forEach { player ->
                players.add(DataMapper.playerModelFromEntity(player))
            }
        }
        return players
    }

    override suspend fun fetchTeams(): List<TeamModel>? {
        if (teams.isEmpty()) {
            database?.teamDao()?.getAll()?.forEach {
                    team ->teams.add(DataMapper.teamModelFromEntity(team))
            }
        }

        return teams
    }

    override suspend fun insertPlayer(playerModel: PlayerModel) {
        database?.playerDao()?.insert(DataMapper.entityFromPlayerModel(playerModel))
    }

    override suspend fun updatePlayer(playerModel: PlayerModel) {
        database?.playerDao()?.update(DataMapper.entityFromPlayerModel(playerModel))
    }

    override suspend fun updateTeam(teamModel: TeamModel) {
        database?.teamDao()?.update(DataMapper.entityFromTeamModel(teamModel))
    }

    override suspend fun insertTeam(teamModel: TeamModel) {
        database?.teamDao()?.insert(DataMapper.entityFromTeamModel(teamModel))
    }

    fun insertAllTeams(teams: List<TeamModel>?) {
        val teamsEntities = ArrayList<Team>()
        teams?.forEach { teamsEntities.add(DataMapper.entityFromTeamModel(it)) }
        database?.teamDao()?.insertAll(teamsEntities)
    }

    fun insertAllPlayers(players: List<PlayerModel>?) {
        val playerEntities = ArrayList<Player>()
        players?.forEach { playerEntities.add(DataMapper.entityFromPlayerModel(it)) }
        database?.playerDao()?.insertAll(playerEntities)
    }


}