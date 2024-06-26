package com.mircontapp.sportalbum.domain.usecases

import com.mircontapp.sportalbum.domain.models.TeamModel
import com.mircontapp.sportalbum.domain.repository.TeamsRepository
import javax.inject.Inject

class UpdateTeamUC @Inject constructor(val teamsRepository: TeamsRepository) {
    operator suspend fun invoke(teamModel: TeamModel) {
        teamsRepository.updateTeam(teamModel)
    }
}